package dao.daoInterfaces;

import dao.DAOContext;
import interfaces.ObjectFactory;

public interface ObjectConfigurator {
    void configure(Object t,  DAOContext daoContext);
}
