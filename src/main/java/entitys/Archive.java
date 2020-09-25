package entitys;

public class Archive {

    private int Id;
    private String name;

    public Archive(int id, String name) {
        Id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id=" + Id +
                ", name=" + name;
    }
}
