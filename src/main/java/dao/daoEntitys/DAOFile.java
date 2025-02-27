package dao.daoEntitys;

import annotations.db.Column;
import annotations.db.Id;
import annotations.db.Table;
import entitys.Place;
import enums.FileType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Table(name = "archive.files")
public class DAOFile {

    @Column(name = "date", type = Date.class)
    private Date datetime;
    @Column(name = "name", type = String.class)
    private String name;
    @Column(name = "type", type = String.class)
    private String type;
    @Column(name = "place", type = String.class)
    private String place;
    @Id
    @Column(name = "id", type = Integer.class)
    private Integer id;
    @Column(name = "archive", type = Integer.class)
    private Integer archiveId;

    public DAOFile() {
    }

    public DAOFile(Integer id) {
        this.id = id;
        this.datetime = new Date(0);
        this.name = "";
        this.type = "";
        this.place = "";
        this.archiveId = -1;
    }

    public DAOFile(Integer id, Date datetime, String name, FileType type, Place place, Integer archiveId) {
        this.id = id;
        this.datetime = datetime;
        this.name = name;
        this.type = type.toString();
        this.place = place.toString();
        this.archiveId = archiveId;
    }
}
