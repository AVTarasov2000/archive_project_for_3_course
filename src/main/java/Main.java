import dao.DataBase;
import interfaces.DAO;
import services.ArchiveService;
import services.CommandService;
import services.InputService;
import services.OutputService;

import java.util.*;

public class Main {

    public static void main(String[] args){

        DAO archives = new DataBase();
        HashMap<String, Object> arguments = new HashMap <>();
        OutputService outputService = new OutputService();
        ArchiveService archiveService = new ArchiveService(archives);
        CommandService commandService = new CommandService(archiveService, outputService, arguments);
        InputService inputService = new InputService(commandService);
        inputService.start();
    }
}
