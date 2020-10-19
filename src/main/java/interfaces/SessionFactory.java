package interfaces;

import dao.Session;

public interface SessionFactory {

    public Session openSession();
}
