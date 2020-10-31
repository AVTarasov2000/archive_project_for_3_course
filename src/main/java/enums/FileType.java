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

    public static FileType getTypeByStr(String str){
        for (FileType type:
                FileType.values()) {
            if(type.getType().equals(str) || type.name().equals(str))
                return type;
        }
        throw new IllegalArgumentException("No enum found with str: [" + str + "]");
    }
}
