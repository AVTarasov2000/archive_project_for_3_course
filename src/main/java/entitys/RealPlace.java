package entitys;

public class RealPlace extends Place{

    Integer shelving;
    Integer shelf;
    Integer index;

    public RealPlace(Integer shelving, Integer shelf, Integer index) {
        this.shelving = shelving;
        this.shelf = shelf;
        this.index = index;
    }

    public Integer getShelving() {
        return shelving;
    }

    public void setShelving(Integer shelving) {
        this.shelving = shelving;
    }

    public Integer getShelf() {
        return shelf;
    }

    public void setShelf(Integer shelf) {
        this.shelf = shelf;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return shelving +
                "_" + shelf +
                "_" + index;
    }
}
