package dao;

import java.sql.ResultSet;

public interface QuerySender {
    ResultSet send(Query query);
    void close();
}
