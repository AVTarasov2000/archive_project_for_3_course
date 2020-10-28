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
@Table
public class DAOFile {

    @Column
    private Date datetime;
    @Column
    private String name;
    @Column
    private FileType type;
    @Column
    private Place place;
    @Id
    @Column
    private Integer id;
    @Column
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
