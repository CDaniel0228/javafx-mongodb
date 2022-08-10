package Control;

import com.mongodb.MongoClient;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoDatabase;


public class Conexion_db {
    private final String bd = "Software";
    private final String host = "localhost";
    private final int port = 27017;

    public MongoDatabase coneccion(){
        try{
            MongoClient mongoClient = new MongoClient(host,port);
            return mongoClient.getDatabase(bd);
        }catch(MongoSocketOpenException e){
            return null;
        }
        
    }
}
