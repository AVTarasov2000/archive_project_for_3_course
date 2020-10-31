package dao;

import java.util.List;

public interface Session {

    <T> void save(T entity);
    <T> void delete(T entity);
    <T> void update(T entity);
    <T> void create(T entity);
    <T> List <T> get(Class<T> entity);
    <T> List <T> selectQuery(Class<T> entity, String... postfix);
    void close();
}
