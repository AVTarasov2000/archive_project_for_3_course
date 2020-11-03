import dao.*;
import dao.daoInterfaces.Session;
import interfaces.DAO;
import services.ArchiveService;
import services.CommandService;
import ui.InputService;
import ui.OutputService;

import java.sql.Statement;
import java.util.*;

public class Main {

    public static void main(String[] args){
        DAOContext daoContext = DAOInitialiser.init("",
                new HashMap <>(Map.of(Session.class, MySession.class)));
        daoContext.putInCache(Statement.class, JDBCStatement.getStatement());
        Session session = daoContext.getObject(Session.class);
        DAO archives = new DataBaseConnector(session);
//        DAO archives = new DataBase();
        HashMap<String, Object> arguments = new HashMap <>();
        OutputService outputService = new OutputService();
        ArchiveService archiveService = new ArchiveService(archives);
        CommandService commandService = new CommandService(archiveService, outputService, arguments);
        InputService inputService = new InputService(commandService);
        inputService.start();
    }
}
