//package config;
//
//import com.mongodb.*;
//import com.mongodb.util.JSON;
//
//import java.util.List;
//
//public class DBConnection {
//
//     public List<String> str;
//
//     public void connectToDB() {
////          MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
////          DB database = mongoClient.getDB("javaLabs");
////          DBCollection collection = database.getCollection("buses");
////
////          DBCursor cursor = collection.find();
////
////          try {
////               while(cursor.hasNext()) {
////                    System.out.println(cursor.next());
////               }
////          } finally {
////               cursor.close();
////          }
//
////          ArrayList<String> arr = new ArrayList<>();
//
////          String jsonString = "{'name':'"+name+"', 'number':"+num+"}";
//
//          try {
//
//               Mongo mongo = new Mongo("localhost", 27017);
//               DB db = mongo.getDB("javaLabs");
//               DBCollection collectionBus = db.getCollection("buses");
//               DBCollection collectionStation = db.getCollection("busStations");
////               addBuses(collectionBus);
////               addStation(collectionStation);
//               DBCursor cursorDoc = collectionBus.find();
//               while (cursorDoc.hasNext()) {
//                    DBObject obj = cursorDoc.next();
//                    str.add((String) obj.get("name"));
//               }
////               while (cursorDoc.hasNext()) {
//////                    strings.add(cursorDoc.next().toString());
//////                    strings = (List<Document>)collectionBus.getCollection(cursorDoc.next().toString());
//////                    System.out.println(cursorDoc.next());
////               }
//
//               System.out.println("Done");
//
//          } catch (MongoException e) {
//               e.printStackTrace();
//          }
//     }
//
//     private void addBuses(DBCollection collection) {
//          // convert JSON to DBObject directly
//          DBObject dbObject = null;
//          for (int i = 1; i < 5; i++) {
//               String jsonString = "{'name':'bus"+i+"', 'number':"+i+"}";
//               dbObject = (DBObject) JSON
//                       .parse(jsonString);
//               collection.insert(dbObject);
//          }
//     }
//
//     private void addStation(DBCollection collection) {
//          // convert JSON to DBObject directly
//          DBObject dbObject = null;
//          for (int i = 1; i < 5; i++) {
//               String jsonString = "{'name':'station"+i+"', 'number':"+i+"}";
//               dbObject = (DBObject) JSON
//                       .parse(jsonString);
//               collection.insert(dbObject);
//          }
//     }
//
////     private void addStops(DBCollection collection) {
////          // convert JSON to DBObject directly
////          DBObject dbObject = null;
////          for (int i = 1; i < 5; i++) {
////               String jsonString = "{'name':'stop"+i+"', 'number':"+i+"}";
////               dbObject = (DBObject) JSON
////                       .parse(jsonString);
////               collection.insert(dbObject);
////          }
////     }
//}
