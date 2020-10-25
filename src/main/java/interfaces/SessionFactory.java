package interfaces;

import dao.MySession;

public interface SessionFactory {

    public MySession openSession();
}
