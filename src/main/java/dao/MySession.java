package dao;


import dao.SQLMethods.Query;

import java.util.List;

public class MySession implements Session{



    private QueryMaker queryMaker;
    private Transaction transaction;
    private QuerySender querySender;
    private DataConverter dataConverter;


    public<T> void save(T entity) {
        Query query = queryMaker.makeQuery(DBMethods.INSERT,entity);
        querySender.send(query);
    }

    public<T> void delete(T entity) {
        Query query = queryMaker.makeQuery(DBMethods.DELETE,entity);
        querySender.send(query);
    }

    public<T> void update(T entity){
        Query query = queryMaker.makeQuery(DBMethods.UPDATE,entity);
        querySender.send(query);
    }

    public<T> void create(T entity){
        Query query = queryMaker.makeQuery(DBMethods.CREATE,entity);
        querySender.send(query);
    }

    public<T> List <T> get(Class<T> entityClass) {
        Query query = queryMaker.makeQuery(DBMethods.SELECT,entityClass);
        return dataConverter.convert(querySender.send(query), entityClass);
    }

    public<T> List <T> selectQuery(Class<T> entityClass, String postfix){
        Query query = queryMaker.makeQuery(DBMethods.SELECT, entityClass, postfix);
        return dataConverter.convert(querySender.send(query), entityClass);
    }

    public void close() {
        querySender.close();
    }

    public Transaction beginTransaction() {
        return null;
    }
}
