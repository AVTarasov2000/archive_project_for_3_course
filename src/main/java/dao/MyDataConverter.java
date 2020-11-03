package dao;

import annotations.db.Column;
import annotations.db.InjectByType;
import dao.daoInterfaces.DataConverter;
import dao.daoInterfaces.FromStringToObjectCaster;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyDataConverter implements DataConverter {

    @InjectByType
    private FromStringToObjectCaster caster;

    @SneakyThrows
    @Override
    public <T> List <T> convert(ResultSet resultSet, Class<T> entity) {
        List<T> result = new ArrayList <>();
        while (resultSet.next()) {
            T tmp = entity.getDeclaredConstructor().newInstance();
            for (Field field : entity.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    String column = columnAnnotation.name();
                    if (column.equals("")) column = field.getName();
                    field.set(tmp,caster.cast(columnAnnotation.type(),resultSet.getString(column)));
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
