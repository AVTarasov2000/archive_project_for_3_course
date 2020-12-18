package ui.servlets;

import dao.*;
import dao.daoInterfaces.Session;
import enums.CommandType;
import interfaces.DAO;
import interfaces.Output;
import services.ArchiveService;
import services.CommandService;
import ui.InputService;
import ui.OutputForServlets;
import ui.OutputService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/",loadOnStartup = 0)
public class LogicSingleton extends HttpServlet {

    private static CommandService commandService;
    private static OutputForServlets output;

    @Override
    public void init() throws ServletException {
        super.init();
        DAOContext daoContext = DAOInitialiser.init("",
                new HashMap <>(Map.of(Session.class, MySession.class)));
        daoContext.putInCache(Statement.class, JDBCStatement.getStatement());
        Session session = daoContext.getObject(Session.class);
        DAO archives = new DataBaseConnector(session);
        HashMap<String, Object> arguments = new HashMap <>();
        ArchiveService archiveService = new ArchiveService(archives);

        output = new OutputForServlets();
        commandService = new CommandService(archiveService, output, arguments);

    }

    public static CommandService getCommandService(){
        return commandService;
    }

    public static OutputForServlets getOutput(){
        return output;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
