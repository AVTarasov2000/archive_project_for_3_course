package ui.servlets;

import entitys.Archive;
import entitys.File;
import entitys.Place;
import entitys.VirtualPlace;
import enums.Arguments;
import enums.FileType;
import utils.PlaceGenerator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/main")
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext selvletContext = getServletContext();
        selvletContext.setAttribute("name", "Tom");
        selvletContext.setAttribute("age", 35);
        selvletContext.setAttribute("bot", 0);
        LogicSingleton.getCommandService().executeCommand("get_all_archives");
        selvletContext.setAttribute("archives", LogicSingleton.getOutput().getReceivedArchive());
        selvletContext.setAttribute("files", LogicSingleton.getOutput().getReceivedFiles());
        selvletContext.setAttribute("types", FileType.values());
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext selvletContext = getServletContext();

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch (action){
            case "addArchive":
                String name = request.getParameter("name");
                LogicSingleton.getCommandService().setArgument(Arguments.NAME.getArgument(), name);
                LogicSingleton.getCommandService().executeCommand("add_archive");
                break;
            case "chooseArchive":
                LogicSingleton.getCommandService().setArgument(Arguments.ID.getArgument(), Integer.parseInt(request.getParameter("id")));
                LogicSingleton.getCommandService().executeCommand("chose_archive");
                LogicSingleton.getCommandService().executeCommand("get_all_files");
//                id = Integer.parseInt(request.getParameter("id"));
                break;
            case "deleteArchive":
                LogicSingleton.getCommandService().setArgument(Arguments.ID.getArgument(), Integer.parseInt(request.getParameter("id")));
                LogicSingleton.getCommandService().executeCommand("delete_archive");
                break;
            case "addFile":
                FileType type = FileType.getTypeByStr(request.getParameter("type"));//FileType.valueOf(scanner.next());
                Place place = new VirtualPlace(request.getParameter("place"));
                File f = new File(0, new Date(), request.getParameter("name"), type, place);
                LogicSingleton.getCommandService().setArgument(Arguments.FILE.getArgument(),f);
                LogicSingleton.getCommandService().executeCommand("add_file");
                LogicSingleton.getCommandService().executeCommand("get_all_files");
                break;
            case "deleteFile":
                LogicSingleton.getCommandService().setArgument(Arguments.ID.getArgument(), Integer.parseInt(request.getParameter("id")));
                LogicSingleton.getCommandService().executeCommand("remove_file");
                LogicSingleton.getCommandService().executeCommand("get_all_files");
                break;
            case "updateFile":
                LogicSingleton.getCommandService().setArgument(Arguments.ID.getArgument(),Integer.parseInt(request.getParameter("id")));
                LogicSingleton.getCommandService().setArgument(Arguments.FILE.getArgument(),
                        new File(Integer.parseInt(request.getParameter("id")),
                        new Date(),
                        request.getParameter("name"),
                        FileType.getTypeByStr(request.getParameter("type")),
                        new VirtualPlace(request.getParameter("place"))));
                LogicSingleton.getCommandService().executeCommand("edit_file");
                LogicSingleton.getCommandService().executeCommand("get_all_files");
                break;
        }
        LogicSingleton.getCommandService().executeCommand("get_all_archives");
        selvletContext.setAttribute("archives", LogicSingleton.getOutput().getReceivedArchive());

        selvletContext.setAttribute("files", LogicSingleton.getOutput().getReceivedFiles());
        getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
