import command.*;
import controller.ArchiveController;
import controller.InputController;
import controller.OutputController;
import entitys.Archive;
import entitys.File;
import enums.ArgumentsEnum;

import java.util.*;

public class Main {

    public static void main(String[] args){
//        File file1 = new File(1, new Date(2020, Calendar.FEBRUARY,1), "aa","aa","aa");
//        File file2 = new File(2, new Date(2020, Calendar.MARCH,1), "xx","bb","bb");
//        File file3 = new File(3, new Date(2020, Calendar.APRIL,1), "vv","nn","vv");
//        File file4 = new File(4, new Date(2020, Calendar.APRIL,1), "vv","vb","cb");
//        ArrayList<File> arr = new ArrayList <File>();
//        arr.add(file1);
//        arr.add(file2);
//        arr.add(file3);
//        arr.add(file4);
//        Archive archive = new Archive("abdyabdya", arr);
//
//
//        HashMap<String, Object> test = new HashMap <>();
//        OutputController outputController = new OutputController();
////        test.put(ArgumentsEnum.ID.getArgument(), 1);
////        test.put(ArgumentsEnum.FILE.getArgument(), file4);
////        test.put(ArgumentsEnum.NAME.getArgument(), "vv");
//        ArchiveController archiveController = new ArchiveController(archive);
//        AddFileCommand addFileCommand = new AddFileCommand(archiveController,outputController, test);
////        addFileCommand.execute();
//        System.out.println(archive);
//        GetByNameCommand getByNameCommand = new GetByNameCommand(archiveController, outputController, test);
////        getByNameCommand.execute();
////        test.put(ArgumentsEnum.NAME.getArgument(), "aa");
////        getByNameCommand.execute();
//
//        GetByTypeCommand getByTypeCommand = new GetByTypeCommand(archiveController, outputController, test);
//
//        InputController inputController = new InputController(addFileCommand,getByNameCommand,
//                null, getByTypeCommand,
//            null,null,
//                null, null,
//                null, test);
//
//        inputController.sendCommand("add -name bb -type take -place p");
//        inputController.sendCommand("get -type take");


        Archive archive = new Archive("abdyabdya");
        HashMap<String, Object> arguments = new HashMap <>();
        OutputController outputController = new OutputController();
        ArchiveController archiveController = new ArchiveController(archive);
        AddFileCommand addFileCommand = new AddFileCommand(archiveController, outputController, arguments);
        GetByNameCommand getByNameCommand = new GetByNameCommand(archiveController, outputController, arguments);
        GetFileCommand getFileCommand = new GetFileCommand(archiveController, outputController, arguments);
        GetByTypeCommand getByTypeCommand = new GetByTypeCommand(archiveController, outputController, arguments);
        RemoveFileCommand deleteFileCommand = new RemoveFileCommand(archiveController, outputController, arguments);
        GetByDateDay getByDateDay = new GetByDateDay(archiveController, outputController, arguments);
        GetByDateMonth getByDateMonth = new GetByDateMonth(archiveController, outputController, arguments);
        GetByDateYear getByDateYear = new GetByDateYear(archiveController, outputController, arguments);
        GetByDateCommand getByDateCommand = new GetByDateCommand(archiveController, outputController, arguments);
        InputController inputController = new InputController(addFileCommand,getByNameCommand,
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
            inputController.sendCommand(input);
        }
    }
}
