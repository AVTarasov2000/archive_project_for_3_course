package entitys;

import enums.FileType;

import java.util.Calendar;

public class File {

    private Calendar datetime;
    private String name;
    private FileType type;
    private Place place;
    private int id;

    public File(int id, Calendar datetime, String name, FileType type, Place place) {
        this.id = id;
        this.datetime = datetime;
        this.name = name;
        this.type = type;
        this.place = place;
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
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
        return "ID: " +id+
                "| Date: " + datetime.get(Calendar.YEAR)+"/"+datetime.get(Calendar.MONTH)+"/"+datetime.get(Calendar.DAY_OF_MONTH)+
                "| Name: "+ name +
                "| type: "+ type +
                "| place: " + place;
    }
}
