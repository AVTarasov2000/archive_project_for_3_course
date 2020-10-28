package dao;

import annotations.db.Column;
import annotations.db.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DAOArchive {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;

    public DAOArchive() {
    }

    public DAOArchive(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
