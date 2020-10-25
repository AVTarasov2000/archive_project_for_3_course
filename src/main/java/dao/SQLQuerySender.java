package dao;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.Statement;

public class SQLQuerySender implements QuerySender{

    Statement statement;
    ResultSet resultSet;

    @SneakyThrows
    public void send(Query query, Receiver tableReceiver) {
        resultSet = statement.executeQuery(query.getQuery());
        int columns = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()){
            String[] row = new String[columns];
            for (int i = 0; i < columns; i++) {
                row[i]=resultSet.getString(i);
            }
            tableReceiver.addRow(row);
        }
    }
}
