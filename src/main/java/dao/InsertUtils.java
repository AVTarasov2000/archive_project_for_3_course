package dao;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InsertUtils {

    @SneakyThrows
    public static void set(Object obj, Field field, String string) {
        field.set(obj,field.getType().cast(string));
    }
}
