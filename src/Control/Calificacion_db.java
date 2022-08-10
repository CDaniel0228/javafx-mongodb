package Control;

import Modelo.Calificacion;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Calificacion_db extends Conexion_db {

    MongoCollection collection = coneccion().getCollection("Datos");

    public boolean registrar(Calificacion nuevo) {
        boolean band = false;
        try {
            Document doc = new Document();
            doc.put("caracteristica", nuevo.getCaracteristicas());
            doc.put("asesor", nuevo.getAsesor());
            doc.put("tecnico", nuevo.getTecnico());
            doc.put("ventas", nuevo.getVentas());
            doc.put("total", nuevo.getTotal());

            collection.insertOne(doc);
            band = true;
        } catch (MongoException e) {
            System.out.println(e);
        }
        return band;
    }

}
