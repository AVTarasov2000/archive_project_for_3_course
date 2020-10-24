package dao;

import lombok.Getter;

public enum DBMethods {
    INSERT("INSERT INTO %s VALUES %s"),
    SELECT("SELECT * FROM %s %s"),
    UPDATE(""),
    DELETE(""),
    CREATE("");

    @Getter
    private String prefix;

    DBMethods(String prefix) {
        this.prefix = prefix;
    }
}
