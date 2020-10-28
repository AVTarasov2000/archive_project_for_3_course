package entitys;

import annotations.db.Column;
import annotations.db.Entity;
import annotations.db.Id;
import annotations.db.Table;
import enums.FileType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class File {

    private Date datetime;
    private String name;
    private FileType type;
    private Place place;
    private Integer id;

    public File() {
    }

    public File(Integer id, Date datetime, String name, FileType type, Place place) {
        this.id = id;
        this.datetime = datetime;
        this.name = name;
        this.type = type;
        this.place = place;
    }

//    public Date getDatetime() {
//        return datetime;
//    }
//
//    public void setDatetime(Date datetime) {
//        this.datetime = datetime;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public FileType getType() {
//        return type;
//    }
//
//    public void setType(FileType type) {
//        this.type = type;
//    }
//
//    public Place getPlace() {
//        return place;
//    }
//
//    public void setPlace(Place place) {
//        this.place = place;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    @Override
    public String toString() {
        return "ID: " +id+
                "| Date: " + datetime.toString()+
                "| Name: "+ name +
                "| type: "+ type +
                "| place: " + place;
    }
}
