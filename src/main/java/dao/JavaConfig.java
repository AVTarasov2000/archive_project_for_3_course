package dao;

import annotations.db.Singleton;
import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections8.Reflections;

import java.util.Map;
import java.util.Set;

@Singleton
public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> interfaceToImplClass;

    public JavaConfig(String packageToScan, Map <Class, Class> interfaceToImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.interfaceToImplClass = interfaceToImplClass;
    }

    @Override
    @SneakyThrows
    public <T> Class <? extends T> getIplClass(Class <T> ifc) {
        return interfaceToImplClass.computeIfAbsent(ifc, aClass -> {
            Set <Class<? extends T>> classes = scanner.getSubTypesOf(ifc);

            if (classes.size()!=1)
                throw new RuntimeException(ifc+"has 0 or more than 1 impl and there no config");

            return classes.iterator().next();
        });
    }
}
