package dao;

import annotations.db.Column;
import annotations.db.Id;
import annotations.db.Table;
import entitys.Place;
import enums.FileType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "archive.files")
public class DAOFile {

    @Column(name = "datetime")
    private Date datetime;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private FileType type;
    @Column(name = "place")
    private Place place;
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "archiveId")
    private Integer archiveId;

    public DAOFile() {
    }

    public DAOFile(Integer id, Date datetime, String name, FileType type, Place place) {
        this.id = id;
        this.datetime = datetime;
        this.name = name;
        this.type = type;
        this.place = place;
    }
}
