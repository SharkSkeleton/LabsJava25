package dao;

import com.mongodb.*;
import converters.TravelConverter;
import entity.Travel;
import org.bson.types.ObjectId;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static constants.GeneralConstants.DB.DB_NAME;


public class TravelDao implements GenericDao<Travel>{
//
    private static final String COLLECTION_NAME = "Travel";
    private DBCollection travelCol;

    public TravelDao(MongoClient client) {
        this.travelCol = client.getDB(DB_NAME).getCollection(COLLECTION_NAME);
    }

    @Override
    public Travel findItem(String id) {
//        Travel item = new Travel();
//
//        DBObject travelObj = helper.get(id, COLLECTION_NAME);
//        item.setNumber(Integer.parseInt((String) travelObj.get("number")));
//        item.setStartDate(Date.valueOf((String) travelObj.get("startDate")));
//        item.setEndDate(Date.valueOf(((String) travelObj.get("endDate"))));
//        item.setBusId((String) travelObj.get("busId"));
//        item.setFromStationId((String) travelObj.get("fromStationId"));
//        item.setToStationId((String) travelObj.get("toStationId"));
//        item.setFromPlatformId(((String) travelObj.get("fromPlatformId")));
//
//        return item;

        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(id)).get();
        DBObject data = travelCol.findOne(query);
        return TravelConverter.toTravel(data);
    }

    @Override
    public Collection<Travel> findAll() {
        List<Travel> travels = new ArrayList<>();
        DBCursor cursor = travelCol.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            Travel travel = TravelConverter.toTravel(doc);
            travels.add(travel);
        }
        return travels;
    }

    @Override
    public void addItem(Travel item) {
//        DBObject dbObject = new BasicDBObject();
//        dbObject.put("number", item.getNumber());
//        dbObject.put("startDate", item.getStartDate());
//        dbObject.put("endDate", item.getEndDate());
//        dbObject.put("busId", item.getBusId());
//        dbObject.put("fromStationId", item.getFromStationId());
//        dbObject.put("toStationId", item.getToStationId());
//        dbObject.put("fromPlatformId", item.getFromPlatformId());
//
//        helper.add(dbObject, COLLECTION_NAME);

        DBObject doc = TravelConverter.toDBObject(item);
        travelCol.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        item.setId(id.toString());
    }

    @Override
    public void updateItem(Travel item) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(item.getId())).get();
        travelCol.update(query, TravelConverter.toDBObject(item));
    }

    @Override
    public void deleteItem(String id) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(id)).get();
        travelCol.remove(query);
    }
}
