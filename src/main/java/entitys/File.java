package entitys;

import java.util.Date;

public class File {

    Date datetime;
    String name;
    String type;
    String place;

    public File(Date datetime, String name, String type, String place) {
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

    @Override
    public String toString() {
        return "Date: " + datetime.toString()+
                "| MetaInf: "+ name +
                "| type: "+ type +
                "| place: " + place;
    }
}
