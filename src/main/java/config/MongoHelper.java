//package config;
//
//import com.mongodb.DBObject;
//import com.mongodb.DB;
//import com.mongodb.Mongo;
//import com.mongodb.MongoException;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCollection;
//import org.bson.types.ObjectId;
//
//public class MongoHelper {
//
//    private static final String DB_NAME = "javaLabs";
//    private DB db;
//
//    public MongoHelper() {
//        init();
//    }
//
//    private void init() {
//        try {
//            Mongo mongo = new Mongo("localhost", 27017);
//            this.db = mongo.getDB(DB_NAME);
//            System.out.println("DB initialized");
//        } catch (MongoException e) {
////            e.printStackTrace();
//        }
//    }
//
//    public void add(DBObject dbObject, String collectionName) {
//        db.getCollection(collectionName).insert(dbObject);
//    }
//
//    public void update(DBObject item, DBObject query, String collectionName) {
//        db.getCollection(collectionName).update(item,query);
//    }
//
//    public void delete(DBObject query, String collectionName) {
//        db.getCollection(collectionName).remove(query);
//    }
//
//    public DBObject get(String id, String collectionName) {
//        BasicDBObject query = new BasicDBObject();
//        query.put("_id", new ObjectId(id));
//
//        DBObject dbObj = db.getCollection(collectionName).findOne(query);
//        return dbObj;
//    }
//
//    public DBCollection getAll(String collectionName) {
//        return db.getCollection(collectionName).find().getCollection();
//    }
//}
//
//
