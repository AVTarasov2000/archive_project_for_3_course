package dao;

import dao.SQLMethods.Query;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.Statement;

public class SQLQuerySender implements QuerySender{

    Statement statement;
    ResultSet resultSet;

    @SneakyThrows
    public ResultSet send(Query query) {
        resultSet = statement.executeQuery(query.getQuery());
        return resultSet;
    }

    @SneakyThrows
    @Override
    public void close() {
        statement.close();
        resultSet.close();
    }
}
