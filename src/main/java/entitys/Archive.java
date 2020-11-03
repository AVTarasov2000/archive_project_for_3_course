package entitys;

import dao.daoEntitys.DAOArchive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archive extends DAOArchive {

    private Integer id;
    private String name;

    public Archive() {
    }

    public Archive(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id=" + id +
                ", name=" + name;
    }
}
