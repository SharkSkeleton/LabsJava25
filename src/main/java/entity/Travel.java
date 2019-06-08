package entity;

import java.util.Date;

public class Travel {
    private String id;
    private int number;
    private Date startDate;
    private Date endDate;
    private String busId;
    private String fromStationId;
    private String toStationId;
    private String fromPlatformId;

    public Travel() {
    }

    public Travel(int number, Date startDate, Date endDate, String busId, String fromStationId, String toStationId, String fromPlatformId) {
        this.number = number;
        this.startDate = startDate;
        this.endDate = endDate;
        this.busId = busId;
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
        this.fromPlatformId = fromPlatformId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(String fromStationId) {
        this.fromStationId = fromStationId;
    }

    public String getToStationId() {
        return toStationId;
    }

    public void setToStationId(String toStationId) {
        this.toStationId = toStationId;
    }

    public String getFromPlatformId() {
        return fromPlatformId;
    }

    public void setFromPlatformId(String fromPlatformId) {
        this.fromPlatformId = fromPlatformId;
    }
}
