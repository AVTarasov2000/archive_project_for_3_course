package dao;

import annotations.db.Column;
import annotations.db.Id;
import annotations.db.Table;
import dao.SQLMethods.*;
import dao.daoInterfaces.QueryMaker;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;
import java.util.*;
import java.sql.Date;

public class SQLQueryMaker implements QueryMaker {

    @SneakyThrows
    public<T> Query makeQuery(@NonNull DBMethods method, T entity, String... conditions) {
        Class<?> cls = (entity instanceof Class)? (Class) entity :entity.getClass();

        boolean isSelect = entity instanceof Class;

        if (!cls.isAnnotationPresent(Table.class))
            throw new AnnotationTypeMismatchException(null, "class is not annotated");

        String table = cls.getAnnotation(Table.class).name();
        if (table.equals(""))
            table = entity.getClass().getName();

        StringBuilder conBuilder = new StringBuilder();
        Iterator iterator = Arrays.stream(conditions).iterator();
        while (iterator.hasNext()){
            conBuilder.append(iterator.next());
            if (iterator.hasNext())
                conBuilder.append(" AND ");
        }

        Field[] fields = cls.getDeclaredFields();
        List<String> columnNames = new ArrayList <>();
        List<String> values = new ArrayList <>();
        String id = "";

        if (!isSelect){
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].isAnnotationPresent(Id.class)) {
                    id = fields[i].get(entity).toString();
                    continue;
                }
                Column column = fields[i].getAnnotation(Column.class);
                String columnName = column.name();
                if (columnName.equals(""))
                    columnName = fields[i].getName();
                columnNames.add(columnName);
                if (column.type() == String.class)
                    values.add("'" + fields[i].get(entity).toString() + "'");
                else if(column.type() == Date.class){
                    values.add("'" + fields[i].get(entity).toString() + "'::date");
                }
                else
                    values.add(fields[i].get(entity).toString());
            }
        }

        switch (method) {
            case CREATE:
                return new Create(table,new String[]{""});
            case DELETE:
                return new Delete(table, id);
            case SELECT:
                return new Select(table, conBuilder.toString());
            case UPDATE:
                return new Update(table, columnNames, values, conBuilder.toString(), id);
            case INSERT:
                return new Insert(table,columnNames,values);
        }

        throw new Exception("need some realisation for new data base method");
    }
}
