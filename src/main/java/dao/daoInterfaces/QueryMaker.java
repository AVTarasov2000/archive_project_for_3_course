package dao.daoInterfaces;

import dao.DBMethods;
import dao.SQLMethods.Query;

public interface QueryMaker {
    <T> Query makeQuery(DBMethods method, T entity, String... postfixes);
}
