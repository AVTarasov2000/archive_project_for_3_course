package dao;

public interface QueryMaker {
    <T> Query makeQuery(DBMethods method, T entity, String... postfixes);
}
