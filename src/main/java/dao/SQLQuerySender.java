package dao;

import annotations.db.InjectByType;
import dao.SQLMethods.Query;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.Statement;

public class SQLQuerySender implements QuerySender{

    Statement statement;
    ResultSet resultSet;

    @SneakyThrows
    public ResultSet send(Query query) {
        System.out.println(query.getQuery()); // TODO: 29/10/2020 заполнить поля
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
