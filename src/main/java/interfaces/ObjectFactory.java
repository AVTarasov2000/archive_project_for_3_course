package interfaces;

import dao.MySession;

public interface ObjectFactory {

    public<T> T getObject(Class<T> type);
}
