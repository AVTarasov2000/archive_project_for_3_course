package dao;

import annotations.db.Singleton;
import interfaces.ObjectFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DAOContext {
    @Setter
    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap <>();
    @Getter
    private Config config;

    public DAOContext(Config config) {
        this.config = config;
    }

    public void putInCache(Class cls, Object obj){
        cache.put(cls, obj);
    }

    public <T> T getObject(Class <T> type){
        if (cache.containsKey(type))
            return (T) cache.get(type);

        Class<? extends T> implClass = type;

        if(type.isInterface())
            implClass = config.getIplClass(type);

        T t = factory.getObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class))
            cache.put(type, t);

        return t;
    }

}
