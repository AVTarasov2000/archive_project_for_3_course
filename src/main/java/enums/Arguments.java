package enums;

public enum Arguments {

    KEY("key"),
    COMPARE_VALUE("compareValue"),
    FILE("file"),
    TYPE("type"),
    ID("id"),
    NAME("name"),
    DATE("date"),
    DATE_FROM("date_from"),
    DATE_TO("date_to");



    private final String command;

    Arguments(String command) {
        this.command = command;
    }

    public String getArgument(){
        return command;
    }
}
