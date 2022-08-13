package Control;

import Modelo.Caracteristicas;
import Modelo.Producto;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.bson.Document;

public class Caracteristicas_db extends Conexion_db {

    MongoCollection collection = coneccion().getCollection("Caracteristicas");

    public boolean registrar(Caracteristicas nuevo) {
        boolean band = false;
        try {
            Document doc = new Document();
            doc.put("producto", nuevo.getProducto());
            doc.put("nombre", nuevo.getNombre());
            doc.put("descripcion", nuevo.getDescripcion());

            collection.insertOne(doc);
            band = true;
        } catch (MongoException e) {
            System.out.println(e);
        }
        return band;
    }

    public ObservableList buscarInformacion(String mostrar) {
        ObservableList items = FXCollections.observableArrayList();

        try {
            Document doc = new Document("producto", mostrar);
            Document doc2 = new Document("nombre", 1).append("_id", 0);
            MongoCursor<Document> resultDocument = collection.find(doc).projection(doc2).iterator();
            while (resultDocument.hasNext()) {
                Document document = resultDocument.next();
                items.add(document.get("nombre").toString());
            }

        } catch (MongoException e) {
            System.out.println(e);
        }
        return items;
    }

}
