package dao;


import java.util.List;

public class Session {



    QueryMaker queryMaker;
    Transaction transaction;
    QuerySender querySender;
    TableReceiver tableReceiver;


    public<T> void save(T entity) {
        Query query = queryMaker.makeQuery(DBMethods.INSERT,entity);
        querySender.send(query, tableReceiver);
    }

    public<T> void delete(T entity) {
        Query query = queryMaker.makeQuery(DBMethods.DELETE,entity);
        querySender.send(query, tableReceiver);
    }

    public<T> void update(T entity){
        Query query = queryMaker.makeQuery(DBMethods.UPDATE,entity);
        querySender.send(query, tableReceiver);
    }

    public<T> void create(T entity){
        Query query = queryMaker.makeQuery(DBMethods.CREATE,entity);
        querySender.send(query, tableReceiver);
    }

    public<T> List <T> get(T entity) {
        Query query = queryMaker.makeQuery(DBMethods.SELECT,entity);
        querySender.send(query, tableReceiver);
        return tableReceiver.getData();
    }

//    public<T> List <T> get(Class <T> archiveClass) {
//        Query query = queryMaker.makeQuery(DBMethods.SELECT,archiveClass);
//        querySender.send(query, tableReceiver);
//        return tableReceiver.getData();
//    }

    public<T> List <T> selectQuery(T entity, String postfix){
        Query query = queryMaker.makeQuery(DBMethods.SELECT, entity, postfix);
        querySender.send(query, tableReceiver);
        return tableReceiver.getData();
    }



    public void close() {

    }

    public Transaction beginTransaction() {
        return null;
    }
}
