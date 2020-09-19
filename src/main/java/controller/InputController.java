package controller;

import command.*;
import enums.CommandEnum;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

public class InputController {

    AddFileCommand addFileCommand;
    GetByNameCommand getByNameCommand;
    GetFileCommand getFileCommand;
    GetByTypeCommand getByTypeCommand;
    RemoveFileCommand removeFileCommand;
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
                           RemoveFileCommand removeFileCommand,
                           GetByDateDay getByDateDay,
                           GetByDateMonth getByDateMonth,
                           GetByDateYear getByDateYear,
                           GetByDateCommand getByDateCommand,
                           HashMap<String, Object> argumentsInCommand) {
        this.addFileCommand = addFileCommand;
        this.getByNameCommand = getByNameCommand;
        this.getFileCommand = getFileCommand;
        this.getByTypeCommand = getByTypeCommand;
        this.removeFileCommand = removeFileCommand;
        this.getByDateDay = getByDateDay;
        this.getByDateMonth = getByDateMonth;
        this.getByDateYear = getByDateYear;
        this.getByDateCommand = getByDateCommand;
        this.argumentsInCommand= argumentsInCommand;
        archiveAccessCommandHashMap.put(CommandEnum.ADD.getCommand(), addFileCommand);
        archiveAccessCommandHashMap.put(CommandEnum.GET.getCommand(), getByNameCommand);
        archiveAccessCommandHashMap.put(CommandEnum.DELETE.getCommand(), removeFileCommand);
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
                argumentsInCommand.put(commands[i].substring(1), commands[i+1]);
            }
        }
    }

    public void sendCommand(String command){
        commandInterpreter(command);
        archiveAccessCommandHashMap.get(this.command).execute();
    }



}
