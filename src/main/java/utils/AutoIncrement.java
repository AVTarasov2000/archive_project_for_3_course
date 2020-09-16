package utils;

public class AutoIncrement {

    private int counter;

    public AutoIncrement(int counter) {
        this.counter = counter;
    }

    public AutoIncrement() {
    }

    public int increment(){
        return counter++;
    }
}
