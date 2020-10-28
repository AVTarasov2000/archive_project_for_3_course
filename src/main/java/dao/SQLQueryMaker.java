package dao;

import annotations.db.Table;

import java.lang.annotation.AnnotationTypeMismatchException;

public class SQLQueryMaker implements QueryMaker {

    public<T> Query makeQuery(DBMethods method, T entity, String... postfixes) {
        StringBuilder sb = new StringBuilder();
        for (String s :
                postfixes) {
            sb.append(" ").append(s);
        }
        // TODO: 24/10/2020 убрать new
        return new SQLQuery(String.format(method.getPrefix(), entity, sb.toString()));
    }

    private<T> String queryMaker(DBMethods method, T entity, String postfixes){
        if (!entity.getClass().isAnnotationPresent(Table.class))
            throw new AnnotationTypeMismatchException(null, "class is not annotated");
        String table = entity.getClass().getAnnotation(Table.class).name();
        if (table.equals("")) table = entity.getClass().getName();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format())
        return "";
    }
}
