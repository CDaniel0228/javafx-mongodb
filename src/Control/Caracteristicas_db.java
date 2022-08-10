package Control;

import Modelo.Caracteristicas;
import Modelo.Producto;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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

    public boolean buscar(Producto mostrar) {
        boolean band = false;
        try {
            Document doc = new Document("nombre", mostrar.getNombre());
            MongoCursor<Document> resultDocument = collection.find(doc).iterator();
            while (resultDocument.hasNext()) {
                mostrar.setDescripcion(resultDocument.next().get("descripcion").toString());
                mostrar.setMercadoObjetivo(resultDocument.next().get("mercado_objetivo").toString());

            }
            band = true;
        } catch (MongoException e) {
            System.out.println(e);
        }
        return band;
    }

}
