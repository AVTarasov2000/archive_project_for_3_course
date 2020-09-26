import command.*;
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
//        AddFileCommand addFileCommand = new AddFileCommand(archiveService, outputService, arguments);
//        GetByNameCommand getByNameCommand = new GetByNameCommand(archiveService, outputService, arguments);
//        GetFileCommand getFileCommand = new GetFileCommand(archiveService, outputService, arguments);
//        GetByTypeCommand getByTypeCommand = new GetByTypeCommand(archiveService, outputService, arguments);
//        RemoveFileCommand deleteFileCommand = new RemoveFileCommand(archiveService, outputService, arguments);
//        GetByDateCommand getByDateCommand = new GetByDateCommand(archiveService, outputService, arguments);
//        InputService inputService = new InputService(addFileCommand,getByNameCommand,
//                getFileCommand, getByTypeCommand,
//                deleteFileCommand,
//                getByDateCommand, arguments);
        CommandService commandService = new CommandService(archiveService, outputService, arguments);
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
