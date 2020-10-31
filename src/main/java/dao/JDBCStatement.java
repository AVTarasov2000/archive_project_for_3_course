package dao;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Archive";
    static final String USER = "postgres";
    static final String PASS = "andrey2000";

    @SneakyThrows
    public static Statement getStatement(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

        return connection.createStatement();
    }
}
