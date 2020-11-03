package dao.daoInterfaces;

import dao.SQLMethods.Query;

import java.sql.ResultSet;

public interface QuerySender {
    ResultSet send(Query query);
    void close();
}
