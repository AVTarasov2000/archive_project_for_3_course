package dao;

import dao.daoInterfaces.Config;
import interfaces.ObjectFactory;

import java.util.Map;

public class DAOInitialiser {

    public static DAOContext init(String packageToScan, Map <Class, Class> interfaceToImplClass) {
        Config config = new JavaConfig(packageToScan, interfaceToImplClass);
        DAOContext context = new DAOContext(config);
        ObjectFactory objectFactory = new DefaultObjectFactory(context);
        context.setFactory(objectFactory);
        return context;
    }
}
