package entitys;

import java.util.Date;

public class File {

    private Date datetime;
    private String name;
    private String type;
    private String place;
    private int id;

    public File(int id, Date datetime, String name, String type, String place) {
        this.datetime = datetime;
        this.name = name;
        this.type = type;
        this.place = place;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Date: " + datetime.toString()+
                "| MetaInf: "+ name +
                "| type: "+ type +
                "| place: " + place;
    }
}
