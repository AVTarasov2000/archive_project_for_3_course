package enums;

public enum FileType {

    DOCUMENT("document"),
    BOOK("book"),
    MEDIA_LOG("media"),
    REFERENCES("reference");

    private final String type;

    FileType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
