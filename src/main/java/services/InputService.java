package services;


import entitys.File;
import enums.Arguments;

import java.util.Date;
import java.util.Scanner;

public class InputService {

    CommandService commandService;
    int condition = 0;
    int command;

    public InputService(CommandService commandService) {
        this.commandService = commandService;
        System.out.println("THE APPLICATION IS STARTED\n");
        applicationLoop();
    }

    public void applicationLoop(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (condition == 0) {
                System.out.println(
                        "\nto chose archive wright: 1 \n" +
                            "to add archive wright: 2 \n" +
                                "to delete archive wright: 3\n" +
                                    "to get all archives wright: 4"
                );
                command = scanner.nextInt();
                switch (command){
                    case 1:
                        System.out.println("wright archive id");
                        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
                        commandService.executeCommand("chose_archive");
                        condition=1;
                        break;
                    case 2:
                        System.out.println("write archive name");
                        String name = scanner.next();
                        commandService.setArgument(Arguments.NAME.getArgument(), name);
                        commandService.executeCommand("add_archive");
                        break;
                    case 3:
                        System.out.println("wright archive id");
                        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
                        commandService.executeCommand("delete_archive");
                        break;
                    case 4:
                        commandService.executeCommand("get_all_archives");
                        break;
                }
            }
            else if(condition==1){
                System.out.println(
                            "\nto add file wright: 1\n" +
                                "to delete file wright: 2\n" +
                                    "to edit file wright: 3\n" +
                                        "to get files by args wright: 4\n" +
                                            "to get all files wright: 5\n" +
                                                "to go choosing archives: 6"
                );
                command = scanner.nextInt();
                File f;
                String name;
                String type;
                String place;
                int id;
                switch (command){
                    case 1:
                        System.out.println("wright args <name> <type> <place>");
                        name = scanner.next();
                        type = scanner.next();
                        place = scanner.next();
                        f = new File(0, new Date(), name, type, place);
                        commandService.setArgument(Arguments.FILE.getArgument(),f);
                        commandService.executeCommand("add_file");
                        break;
                    case 2:
                        System.out.println("write file id");
                        commandService.setArgument(Arguments.ID.getArgument(), scanner.nextInt());
                        commandService.executeCommand("remove_file");
                        break;
                    case 3:
                        System.out.println("wright args <id> <name> <type> <place>");
                        id = scanner.nextInt();
                        name = scanner.next();
                        type = scanner.next();
                        place = scanner.next();
                        f = new File(id, new Date(), name, type, place);
                        commandService.setArgument(Arguments.ID.getArgument(),id);
                        commandService.setArgument(Arguments.FILE.getArgument(),f);
                        commandService.executeCommand("edit_file");
                        break;
                    case 4:
                        // TODO: 27/09/2020 класс даты рассчитан для двухтысячных использовать другой!!!
                        System.out.println("wright args <name> <type> <date from(yyyy mm dd)> <date to(yyyy mm dd)>");
                        name = scanner.next();
                        type = scanner.next();
                        int year = scanner.nextInt();
                        int month = scanner.nextInt();
                        int date = scanner.nextInt();
                        Date from = new Date(year);
                        from.setYear(year);
                        from.setMonth(month);
                        from.setDate(date);
                        year = scanner.nextInt();
                        month = scanner.nextInt();
                        date = scanner.nextInt();
                        Date to = new Date(year, month, date);
                        to.setYear(year);
                        to.setMonth(month);
                        to.setDate(date);
                        commandService.setArgument(Arguments.NAME.getArgument(),name);
                        commandService.setArgument(Arguments.TYPE.getArgument(),type);
                        commandService.setArgument(Arguments.DATE_FROM.getArgument(),from);
                        commandService.setArgument(Arguments.DATE_TO.getArgument(),to);
                        commandService.executeCommand("get_by_name");
                        break;
                    case 5:
                        commandService.executeCommand("get_all_files");
                        break;
                    case 6:
                        condition=0;
                        break;
                }
            }
        }
    }




}
