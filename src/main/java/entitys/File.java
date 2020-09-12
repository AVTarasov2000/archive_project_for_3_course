package entitys;


import com.sun.istack.internal.NotNull;

import java.util.Date;

public class File {

    Date datetime;
    String metaInf;
    String type;
    String place;

    public File(Date datetime, String metaInf, String type, String place) {
        this.datetime = datetime;
        this.metaInf = metaInf;
        this.type = type;
        this.place = place;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getMetaInf() {
        return metaInf;
    }

    public void setMetaInf(String metaInf) {
        this.metaInf = metaInf;
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
}
