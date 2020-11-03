package dao.daoEntitys;

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
    @Column(name = "id" , type = Integer.class)
    private Integer id;
    @Column(name = "name", type = String.class)
    private String name = "";

    public DAOArchive() {
    }

    public DAOArchive(Integer id) {
        this.id = id;
    }

    public DAOArchive(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
