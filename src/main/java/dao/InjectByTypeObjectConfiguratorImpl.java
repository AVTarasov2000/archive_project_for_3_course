package dao;

import annotations.db.InjectByType;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectByTypeObjectConfiguratorImpl implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object t, DAOContext context) {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getFields()) {
            InjectByType injectByTypeAnnotation = field.getAnnotation(InjectByType.class);
            if (injectByTypeAnnotation!=null){
                Class<?> type = field.getType();
                Object o = context.getObject(type);
                field.setAccessible(true);
                field.set(t,o);
            }

        }
    }
}
