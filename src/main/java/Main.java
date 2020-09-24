import command.*;
import services.ArchiveService;
import services.InputService;
import services.OutputService;
import dao.Archive;

import java.util.*;

public class Main {

    public static void main(String[] args){

        Archive archive = new Archive("abdyabdya");
        HashMap<String, Object> arguments = new HashMap <>();
        OutputService outputService = new OutputService();
        ArchiveService archiveService = new ArchiveService(archive);
        AddFileCommand addFileCommand = new AddFileCommand(archiveService, outputService, arguments);
        GetByNameCommand getByNameCommand = new GetByNameCommand(archiveService, outputService, arguments);
        GetFileCommand getFileCommand = new GetFileCommand(archiveService, outputService, arguments);
        GetByTypeCommand getByTypeCommand = new GetByTypeCommand(archiveService, outputService, arguments);
        RemoveFileCommand deleteFileCommand = new RemoveFileCommand(archiveService, outputService, arguments);
        GetByDateDay getByDateDay = new GetByDateDay(archiveService, outputService, arguments);
        GetByDateMonth getByDateMonth = new GetByDateMonth(archiveService, outputService, arguments);
        GetByDateYear getByDateYear = new GetByDateYear(archiveService, outputService, arguments);
        GetByDateCommand getByDateCommand = new GetByDateCommand(archiveService, outputService, arguments);
        InputService inputService = new InputService(addFileCommand,getByNameCommand,
                getFileCommand, getByTypeCommand,
                deleteFileCommand,getByDateDay,
                getByDateMonth, getByDateYear,
                getByDateCommand, arguments);
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if(input.compareTo("exit")==0){
                break;
            }
            inputService.sendCommand(input);
        }
    }
}
