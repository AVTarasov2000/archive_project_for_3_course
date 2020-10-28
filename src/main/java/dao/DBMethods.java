package dao;

import lombok.Getter;

public enum DBMethods {
    // TODO: 27/10/2020 переделать из enum d class
    INSERT("INSERT INTO %s VALUES %s ;"),
    SELECT("SELECT * FROM %s %s ;"),
    UPDATE("UPDATE %s Set %s ;"),
    DELETE("DELETE FROM %s %s"),
    CREATE("CREATE TABLE ( %s %s );");

    @Getter
    private String prefix;

    DBMethods(String prefix) {
        this.prefix = prefix;
    }
}
