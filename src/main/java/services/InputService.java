package services;

import command.*;
import enums.Arguments;
import enums.CommandType;
import interfaces.ArchiveAccessCommand;
import utils.FileUtils;

import java.util.Date;
import java.util.HashMap;

public class InputService {

    AddFileCommand addFileCommand;
    GetByNameCommand getByNameCommand;
    GetFileCommand getFileCommand;
    GetByTypeCommand getByTypeCommand;
    RemoveFileCommand deleteFileCommand;
    GetByDateDay getByDateDay;
    GetByDateMonth getByDateMonth;
    GetByDateYear getByDateYear;
    GetByDateCommand getByDateCommand;
    HashMap<String, Object> argumentsInCommand;
    String command;


    public InputService(AddFileCommand addFileCommand,
                        GetByNameCommand getByNameCommand,
                        GetFileCommand getFileCommand,
                        GetByTypeCommand getByTypeCommand,
                        RemoveFileCommand deleteFileCommand,
                        GetByDateDay getByDateDay,
                        GetByDateMonth getByDateMonth,
                        GetByDateYear getByDateYear,
                        GetByDateCommand getByDateCommand,
                        HashMap<String, Object> argumentsInCommand) {
        this.addFileCommand = addFileCommand;
        this.getByNameCommand = getByNameCommand;
        this.getFileCommand = getFileCommand;
        this.getByTypeCommand = getByTypeCommand;
        this.deleteFileCommand = deleteFileCommand;
        this.getByDateDay = getByDateDay;
        this.getByDateMonth = getByDateMonth;
        this.getByDateYear = getByDateYear;
        this.getByDateCommand = getByDateCommand;
        this.argumentsInCommand= argumentsInCommand;


    }

    private void commandInterpreter(String command){
        String[] commands = command.split(" ");
        this.command = commands[0];
        for (int i = 1; i < commands.length; i++) {
            if(commands[i].charAt(0)=='-'){
                if (commands[i].substring(1).compareTo(CommandType.ID.getCommand())==0)
                    argumentsInCommand.put(commands[i].substring(1), Integer.parseInt(commands[i+1]));
                else
                    argumentsInCommand.put(commands[i].substring(1), commands[i+1]);
            }
        }
    }

    public void sendCommand(String command){
        commandInterpreter(command);
        getCommand().execute();
    }

    private ArchiveAccessCommand getCommand(){
        if (command.compareTo(CommandType.ADD.getCommand())==0){
            argumentsInCommand.put(Arguments.FILE.getArgument(), FileUtils.createFile(
                    (Date) argumentsInCommand.get(CommandType.DATE.getCommand()),
                    (String) argumentsInCommand.get(CommandType.NAME.getCommand()),
                    (String) argumentsInCommand.get(CommandType.TYPE.getCommand()),
                    (String) argumentsInCommand.get(CommandType.PLACE.getCommand())));
            return addFileCommand;
        } else if (command.compareTo(CommandType.GET.getCommand())==0){
            if (argumentsInCommand.get(CommandType.NAME.getCommand())!=null){
                return getByNameCommand;
            }else if (argumentsInCommand.get(CommandType.TYPE.getCommand())!=null){
                return getByTypeCommand;
            }else if(argumentsInCommand.get(CommandType.DATE.getCommand())!=null){
                return getByDateCommand;
            }
        } else if (command.compareTo(CommandType.DELETE.getCommand())==0){
            return deleteFileCommand;
        }
        return null;

    }



}
