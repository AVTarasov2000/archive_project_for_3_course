package enums;

public enum Arguments {

    KEY("key"),
    COMPARE_VALUE("compareValue"),
    FILE("file"),
    TYPE("type"),
    ID("id"),
    NAME("name");



    private final String command;

    Arguments(String command) {
        this.command = command;
    }

    public String getArgument(){
        return command;
    }
}
