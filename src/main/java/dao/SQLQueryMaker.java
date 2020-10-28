package dao;

import annotations.db.Table;
import dao.SQLMethods.Create;
import dao.SQLMethods.Query;

import java.lang.annotation.AnnotationTypeMismatchException;

public class SQLQueryMaker implements QueryMaker {

    public<T> Query makeQuery(DBMethods method, T entity, String... conditions) {
        if (!entity.getClass().isAnnotationPresent(Table.class))
            throw new AnnotationTypeMismatchException(null, "class is not annotated");

        String table = entity.getClass().getAnnotation(Table.class).name();
        if (table.equals(""))
            table = entity.getClass().getName();

        switch (method) {
            case CREATE:
                return new Create(table,new String[]{""}); // TODO: 28/10/2020 переделать create metod 
            case DELETE:

            case SELECT:

            case UPDATE:

            case INSERT:

        }


    }

    private<T> String queryMaker(DBMethods method, T entity, String postfixes){
        if (!entity.getClass().isAnnotationPresent(Table.class))
            throw new AnnotationTypeMismatchException(null, "class is not annotated");
        String table = entity.getClass().getAnnotation(Table.class).name();
        if (table.equals("")) table = entity.getClass().getName();

//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format())
        return "";
    }
}
