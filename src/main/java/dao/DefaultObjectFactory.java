package dao;

import annotations.db.Singleton;
import dao.daoInterfaces.ObjectConfigurator;
import interfaces.ObjectFactory;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class DefaultObjectFactory implements ObjectFactory {

    private List <ObjectConfigurator> configurators = new ArrayList <>();
    private  DAOContext context;

    @SneakyThrows
    public DefaultObjectFactory(DAOContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass :
                context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)){
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public<T> T getObject(Class<T> implClass) {
        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t, context));

        return t;
    }
}
