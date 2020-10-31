package dao;


import annotations.db.InjectByType;
import dao.SQLMethods.Query;
import lombok.SneakyThrows;
import org.postgresql.util.PSQLException;

import java.sql.ResultSet;
import java.sql.Statement;

public class SQLQuerySender implements QuerySender{


    @InjectByType
    Statement statement;
    ResultSet resultSet;

    @SneakyThrows
    public ResultSet send(Query query) {
        System.out.println(query.getQuery());
        try {
            return statement.executeQuery(query.getQuery());
        }catch (PSQLException e){

        }
        return resultSet;
    }

    @SneakyThrows
    @Override
    public void close() {
        statement.close();
        resultSet.close();
    }
}
