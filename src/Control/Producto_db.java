package Control;

import Modelo.Producto;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.bson.Document;

public class Producto_db extends Conexion_db {

    MongoCollection collection = coneccion().getCollection("Productos");

    public boolean registrar(Producto nuevo) {
        boolean band = false;
        try {
            Document doc = new Document();
            doc.put("nombre", nuevo.getNombre());
            doc.put("descripcion", nuevo.getDescripcion());
            doc.put("mercado_objetivo", nuevo.getMercadoObjetivo());
            collection.insertOne(doc);
            band = true;
        } catch (MongoException e) {
            System.out.println(e);
        }
        return band;
    }

    public ObservableList buscarNombre() {
        ObservableList items = FXCollections.observableArrayList();
        try {
            Document doc = new Document("nombre", 1).append("_id", 0);
            MongoCursor<Document> resultDocument = collection.find().projection(doc).iterator();
            while (resultDocument.hasNext()) {
                Document document = resultDocument.next();
                items.add(document.get("nombre").toString());
            }

        } catch (MongoException e) {
            System.out.println(e);
        }
        return items;
    }

    public boolean actualizar(Producto rename) {
        boolean band = false;
        try {
            Document editar = new Document("nombre", rename.getNombre());
            Document editDoc = new Document("$set", new Document("descripcion", rename.getDescripcion()));
            collection.findOneAndUpdate(editar, editDoc);
            band = true;
        } catch (MongoException e) {
            System.out.println(e);
        }
        return band;
    }

    public boolean eliminar(String nombre) {
        boolean band = false;
        try {
            Document remover = new Document("nombre", nombre);
            collection.findOneAndDelete(remover);
            band = true;
        } catch (MongoException e) {
            System.out.println(e);
        }
        return band;
    }

}
