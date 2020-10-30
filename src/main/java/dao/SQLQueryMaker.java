package dao;

import annotations.db.Column;
import annotations.db.Table;
import dao.SQLMethods.*;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;

public class SQLQueryMaker implements QueryMaker {

    @SneakyThrows
    public<T> Query makeQuery(@NonNull DBMethods method, T entity, String... conditions) {
        Class<?> cls = (entity instanceof Class)? (Class) entity :entity.getClass();

        if (!cls.isAnnotationPresent(Table.class))
            throw new AnnotationTypeMismatchException(null, "class is not annotated");

        String table = cls.getAnnotation(Table.class).name();
        if (table.equals(""))
            table = entity.getClass().getName();

        StringBuilder conBuilder = new StringBuilder();
        for (String condition : conditions) {
            conBuilder.append(condition).append(" AND ");
        }

        Field[] fields = cls.getDeclaredFields();
        String[] columnNames = new String[fields.length];
        String[] values = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String column = fields[i].getAnnotation(Column.class).name();
            if (column.equals(""))
                column = fields[i].getName();
            columnNames[i] = column;
            values[i] = fields[i].get(entity).toString();
        }

        switch (method) {
            case CREATE:
                return new Create(table,new String[]{""}); // TODO: 28/10/2020 переделать create method
            case DELETE:
                return new Delete(table, conBuilder.toString());
            case SELECT:
                return new Select(table, conBuilder.toString());
            case UPDATE:
                return new Update(table, columnNames, values, conBuilder.toString());
            case INSERT:
                return new Insert(table,columnNames,values);
        }

        throw new Exception("need some realisation for new data base method");
    }
}
