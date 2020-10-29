package dao;

import interfaces.ObjectFactory;

public interface ObjectConfigurator {
    void configure(Object t,  DAOContext daoContext);
}
