package converters;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import entity.Travel;
import org.bson.types.ObjectId;

import java.util.Date;

public class TravelConverter {
    public static DBObject toDBObject(Travel model) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("number", model.getNumber())
                .append("startDate", model.getStartDate())
                .append("endDate", model.getEndDate())
                .append("busId", model.getBusId())
                .append("fromStationId", model.getFromStationId())
                .append("toStationId", model.getToStationId())
                .append("fromPlatformId", model.getFromPlatformId());
        if (model.getId() != null)
            builder = builder.append("_id", new ObjectId(model.getId()));
        return builder.get();
    }

    public static Travel toTravel(DBObject doc) {
        Travel model = new Travel();
        model.setNumber((int) doc.get("number"));
        model.setStartDate((Date) doc.get("startDate"));
        model.setEndDate((Date) doc.get("endDate"));
        model.setBusId((String) doc.get("busId"));
        model.setFromStationId((String) doc.get("fromStationId"));
        model.setToStationId((String) doc.get("toStationId"));
        model.setFromPlatformId((String) doc.get("fromPlatformId"));
        ObjectId id = (ObjectId) doc.get("_id");
        model.setId(id.toString());
        return model;
    }
}
