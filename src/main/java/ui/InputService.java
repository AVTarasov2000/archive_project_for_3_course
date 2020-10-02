package ui;


import entitys.File;
import enums.Arguments;
import enums.FileType;
import services.CommandService;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class InputService {

    CommandService commandService;
    int condition = 0;
    int command;

    public InputService(CommandService commandService) {
        this.commandService = commandService;
    }

    public void start(){
        System.out.println("THE APPLICATION IS STARTED\n");
        applicationLoop();
    }

    private FileType getTypeByStr(String str){
        for (FileType type:
             FileType.values()) {
            if(type.getType().equals(str))
                return type;
        }
        throw new IllegalArgumentException("No enum found with str: [" + str + "]");
    }

//    private int ifExit(Scanner scanner){
//        System.out.println("to exit command write: -1");
//        int command = scanner.nextInt();
//        if(command!=-1)
//    }

    private void choseArchive(Scanner scanner){
        System.out.println("wright archive id");
        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
        commandService.executeCommand("chose_archive");
        condition=1;
    }

    private void addArchive(Scanner scanner){
        System.out.println("write archive name");
        String name = scanner.next();
        commandService.setArgument(Arguments.NAME.getArgument(), name);
        commandService.executeCommand("add_archive");
    }

    private void deleteArchive(Scanner scanner){
        System.out.println("wright archive id");
        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
        commandService.executeCommand("delete_archive");
    }

    private void getAllArchives(Scanner scanner){
        commandService.executeCommand("get_all_archives");
    }

    private void addFile(Scanner scanner){
        System.out.println("wright args <name> <type> <place>");
        String name = scanner.next();
        FileType type = getTypeByStr(scanner.next());//FileType.valueOf(scanner.next());
        String place = scanner.next();
        File f = new File(0, new GregorianCalendar(), name, type, place);
        commandService.setArgument(Arguments.FILE.getArgument(),f);
        commandService.executeCommand("add_file");
    }

    private void deleteFile(Scanner scanner){
        System.out.println("write file id");
        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
        commandService.executeCommand("remove_file");
    }

    private void editFile(Scanner scanner){
        System.out.println("wright args <id> <name> <type> <place>");
        int id = scanner.nextInt();
        String name = scanner.next();
        FileType type = getTypeByStr(scanner.next()); //FileType.valueOf(scanner.next());
        String place = scanner.next();
        File f = new File(id, new GregorianCalendar() {
        }, name, type, place);
        commandService.setArgument(Arguments.ID.getArgument(),id);
        commandService.setArgument(Arguments.FILE.getArgument(),f);
        commandService.executeCommand("edit_file");
    }

    private void getFilesByArgs(Scanner scanner){
        System.out.println("wright args <name> <type> <date from(yyyy mm dd)> <date to(yyyy mm dd)>");
        String name = scanner.next();
        FileType type = getTypeByStr(scanner.next());//FileType.valueOf(scanner.next());
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int date = scanner.nextInt();
        Calendar from = new GregorianCalendar(year,month,date);
        year = scanner.nextInt();
        month = scanner.nextInt();
        date = scanner.nextInt();
        Calendar to = new GregorianCalendar(year, month, date);
        commandService.setArgument(Arguments.NAME.getArgument(),name);
        commandService.setArgument(Arguments.TYPE.getArgument(),type);
        commandService.setArgument(Arguments.DATE_FROM.getArgument(),from);
        commandService.setArgument(Arguments.DATE_TO.getArgument(),to);
        commandService.executeCommand("get_by_arguments");
    }

    public void getAllFiles(Scanner scanner){
        commandService.executeCommand("get_all_files");
    }

//    public void applicationLoop(){
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            if (condition == 0) {
//                System.out.println(
//                        "\nto chose archive wright: 1 \n" +
//                            "to add archive wright: 2 \n" +
//                                "to delete archive wright: 3\n" +
//                                    "to get all archives wright: 4\n" +
//                                        "to exit program wright: 5"
//                );
//                command = scanner.nextInt();
//                switch (command){
//                    case 1:
//                        System.out.println("wright archive id");
//                        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
//                        commandService.executeCommand("chose_archive");
//                        condition=1;
//                        break;
//                    case 2:
//                        System.out.println("write archive name");
//                        String name = scanner.next();
//                        commandService.setArgument(Arguments.NAME.getArgument(), name);
//                        commandService.executeCommand("add_archive");
//                        break;
//                    case 3:
//                        System.out.println("wright archive id");
//                        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
//                        commandService.executeCommand("delete_archive");
//                        break;
//                    case 4:
//                        commandService.executeCommand("get_all_archives");
//                        break;
//                    case 5:
//                        return;
//                }
//            }
//            else if(condition==1){
//                System.out.println(
//                            "\nto add file wright: 1\n" +
//                                "to delete file wright: 2\n" +
//                                    "to edit file wright: 3\n" +
//                                        "to get files by args wright: 4\n" +
//                                            "to get all files wright: 5\n" +
//                                                "to go back to choose archives: 6"
//                );
//                command = scanner.nextInt();
//                File f;
//                String name;
//                FileType type;
//                String place;
//                int id;
//                switch (command){
//                    case 1:
//                        System.out.println("wright args <name> <type> <place>");
//                        name = scanner.next();
//                        type = getTypeByStr(scanner.next());//FileType.valueOf(scanner.next());
//                        place = scanner.next();
//                        f = new File(0, new GregorianCalendar(), name, type, place);
//                        commandService.setArgument(Arguments.FILE.getArgument(),f);
//                        commandService.executeCommand("add_file");
//                        break;
//                    case 2:
//                        System.out.println("write file id");
//                        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
//                        commandService.executeCommand("remove_file");
//                        break;
//                    case 3:
//                        System.out.println("wright args <id> <name> <type> <place>");
//                        id = scanner.nextInt();
//                        name = scanner.next();
//                        type = getTypeByStr(scanner.next()); //FileType.valueOf(scanner.next());
//                        place = scanner.next();
//                        f = new File(id, new GregorianCalendar() {
//                        }, name, type, place);
//                        commandService.setArgument(Arguments.ID.getArgument(),id);
//                        commandService.setArgument(Arguments.FILE.getArgument(),f);
//                        commandService.executeCommand("edit_file");
//                        break;
//                    case 4:
//                        System.out.println("wright args <name> <type> <date from(yyyy mm dd)> <date to(yyyy mm dd)>");
//                        name = scanner.next();
//                        type = getTypeByStr(scanner.next());//FileType.valueOf(scanner.next());
//                        int year = scanner.nextInt();
//                        int month = scanner.nextInt();
//                        int date = scanner.nextInt();
//                        Calendar from = new GregorianCalendar(year,month,date);
//                        year = scanner.nextInt();
//                        month = scanner.nextInt();
//                        date = scanner.nextInt();
//                        Calendar to = new GregorianCalendar(year, month, date);
//                        commandService.setArgument(Arguments.NAME.getArgument(),name);
//                        commandService.setArgument(Arguments.TYPE.getArgument(),type);
//                        commandService.setArgument(Arguments.DATE_FROM.getArgument(),from);
//                        commandService.setArgument(Arguments.DATE_TO.getArgument(),to);
//                        commandService.executeCommand("get_by_arguments");
//                        break;
//                    case 5:
//                        commandService.executeCommand("get_all_files");
//                        break;
//                    case 6:
//                        condition=0;
//                        break;
//                }
//            }
//        }
//    }

    public void applicationLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (condition == 0) {
                System.out.println(
                                        "\nto chose archive wright: 1 \n" +
                                        "to add archive wright: 2 \n" +
                                        "to delete archive wright: 3\n" +
                                        "to get all archives wright: 4\n" +
                                        "to exit program wright: 5"
                );
                command = scanner.nextInt();
                switch (command) {
                    case 1:
                       choseArchive(scanner);
                        break;
                    case 2:
                        addArchive(scanner);
                        break;
                    case 3:
                        deleteArchive(scanner);
                        break;
                    case 4:
                        getAllArchives(scanner);
                        break;
                    case 5:
                        return;
                }
            } else if (condition == 1) {
                System.out.println(
                        "\nto add file wright: 1\n" +
                                "to delete file wright: 2\n" +
                                "to edit file wright: 3\n" +
                                "to get files by args wright: 4\n" +
                                "to get all files wright: 5\n" +
                                "to go choosing archives: 6"
                );
                command = scanner.nextInt();

                switch (command) {
                    case 1:
                        addFile(scanner);
                        break;
                    case 2:
                        deleteFile(scanner);
                        break;
                    case 3:
                        editFile(scanner);
                        break;
                    case 4:
                        getFilesByArgs(scanner);
                        break;
                    case 5:
                        getAllFiles(scanner);
                        break;
                    case 6:
                        condition = 0;
                        break;
                }
            }
        }
    }



}
