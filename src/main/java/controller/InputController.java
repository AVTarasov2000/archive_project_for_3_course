package controller;

import command.*;
import enums.ArgumentsEnum;
import enums.CommandEnum;
import interfaces.ArchiveAccessCommand;
import utils.FileUtils;

import java.util.Date;
import java.util.HashMap;

public class InputController {

    AddFileCommand addFileCommand;
    GetByNameCommand getByNameCommand;
    GetFileCommand getFileCommand;
    GetByTypeCommand getByTypeCommand;
    RemoveFileCommand deleteFileCommand;
    GetByDateDay getByDateDay;
    GetByDateMonth getByDateMonth;
    GetByDateYear getByDateYear;
    GetByDateCommand getByDateCommand;
    Object[] args;
    HashMap<String, Object> argumentsInCommand;
    HashMap<String, ArchiveAccessCommand> archiveAccessCommandHashMap= new HashMap <>();
    String command;


    public InputController(AddFileCommand addFileCommand,
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
        archiveAccessCommandHashMap.put(CommandEnum.ADD.getCommand(), addFileCommand);
        archiveAccessCommandHashMap.put(CommandEnum.GET.getCommand(), getByNameCommand);
        archiveAccessCommandHashMap.put(CommandEnum.DELETE.getCommand(), deleteFileCommand);
//        archiveAccessCommandHashMap.put();
//        archiveAccessCommandHashMap.put();
//        archiveAccessCommandHashMap.put();
//        archiveAccessCommandHashMap.put();
//        archiveAccessCommandHashMap.put();

    }

    private void commandInterpreter(String command){
        String[] commands = command.split(" ");
//        archiveAccessCommandHashMap.put("command", commands[0]);
        this.command = commands[0];
        for (int i = 1; i < commands.length; i++) {
            if(commands[i].charAt(0)=='-'){
                if (commands[i].substring(1).compareTo(CommandEnum.ID.getCommand())==0)
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
        if (command.compareTo(CommandEnum.ADD.getCommand())==0){
            argumentsInCommand.put(ArgumentsEnum.FILE.getArgument(), FileUtils.createFile(
                    (Date) argumentsInCommand.get(CommandEnum.DATE.getCommand()),
                    (String) argumentsInCommand.get(CommandEnum.NAME.getCommand()),
                    (String) argumentsInCommand.get(CommandEnum.TYPE.getCommand()),
                    (String) argumentsInCommand.get(CommandEnum.PLACE.getCommand())));
            return addFileCommand;
        } else if (command.compareTo(CommandEnum.GET.getCommand())==0){
            if (argumentsInCommand.get(CommandEnum.NAME.getCommand())!=null){
                return getByNameCommand;
            }else if (argumentsInCommand.get(CommandEnum.TYPE.getCommand())!=null){
                return getByTypeCommand;
            }else if(argumentsInCommand.get(CommandEnum.DATE.getCommand())!=null){
                return getByDateCommand;
            }
        } else if (command.compareTo(CommandEnum.DELETE.getCommand())==0){
            return deleteFileCommand;
        }
        return null;

    }



}
