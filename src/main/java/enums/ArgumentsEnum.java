package enums;

public enum  ArgumentsEnum {

    KEY("key"),
    COMPARE_VALUE("compareValue"),
    FILE("file"),
    TYPE("type"),
    ID("id"),
    NAME("name");



    private final String command;

    ArgumentsEnum(String command) {
        this.command = command;
    }

    public String getArgument(){
        return command;
    }
}
