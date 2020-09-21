package enums;

public enum CommandEnum {

    GET("get"),
    ADD("add"),
    DELETE("delete"),
    DATE("date"),
    NAME("name"),
    TYPE("type"),
    ID("id"),
    PLACE("place");

    private final String command;

    CommandEnum(String command) {
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
