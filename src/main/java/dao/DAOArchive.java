package dao;

import annotations.db.Column;
import annotations.db.Id;
import annotations.db.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "archive.archive")
public class DAOArchive {
    @Id
    @Column
    private Integer id;
    @Column(name = "name")
    private String name;

    public DAOArchive() {
    }

    public DAOArchive(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
