package dao;

public interface Config {
    <T> Class<? extends T> getIplClass(Class<T> type);
}
