package dao;

import annotations.db.Column;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyDataConverter implements DataConverter {

    @SneakyThrows
    @Override
    public <T> List <T> convert(ResultSet resultSet, Class<T> entity) {
        List<T> result = new ArrayList <>();
        while (resultSet.next()) {
            T tmp = entity.getDeclaredConstructor().newInstance();
            for (Field field : entity.getFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    String column = field.getAnnotation(Column.class).name();
                    if (column.equals("")) column = field.getName();
                    InsertUtils.set(tmp, field, resultSet.getString(column));
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
