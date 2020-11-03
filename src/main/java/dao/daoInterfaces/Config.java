package dao.daoInterfaces;


import org.reflections8.Reflections;

public interface Config {
    <T> Class<? extends T> getIplClass(Class<T> type);

    Reflections getScanner();
}
