import command.*;
import dao.DataBase;
import enums.Arguments;
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

//        commandService.executeCommand("get_all_archives");
//        commandService.setArgument(Arguments.ID.getArgument(),0);
//        commandService.executeCommand("get_all_files");
//        commandService.setArgument(Arguments.ID.getArgument(), 1);
//        commandService.executeCommand("get_all_files");

//        Scanner scanner = new Scanner(System.in);
//        while (true){
//            String input = scanner.nextLine();
//            if(input.compareTo("exit")==0){
//                break;
//            }
//            inputService.sendCommand(input);
//        }
    }
}
