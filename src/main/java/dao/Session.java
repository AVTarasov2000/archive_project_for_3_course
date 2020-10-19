package dao;

import annotations.Entity;
import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.reflect.AnnotatedElement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Session {

    Statement statement;

    public Session(Statement statement) {
        this.statement = statement;
    }


    public Transaction beginTransaction(){
        return new Transaction();
    }

    public Object get(Object cls, Object id){
        Entity target = cls.getClass().getAnnotation(Entity.class);
//        cls.getAnnotatedField
        // TODO: 19.10.2020 making query from annotations
        statement.executeQuery("SELECT * FROM"+target.tableName()+"WHERE ID");
    }

    public void save(@Entity Object object){

    }

    public List<Entity> createQuery(String query){

    }

    public void close(){
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
