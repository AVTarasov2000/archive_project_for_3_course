package dao;

import interfaces.ObjectFactory;

public class DefaultObjectFactory implements ObjectFactory {

    private Config config;

    public<T> T getObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()){
            implClass = config.getIplClass(type);
        }
        return null;
    }
}
