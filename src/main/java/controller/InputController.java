package controller;

import command.input.*;

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

    public InputController(AddFileCommand addFileCommand,
                           GetByNameCommand getByNameCommand,
                           GetFileCommand getFileCommand,
                           GetByTypeCommand getByTypeCommand,
                           RemoveFileCommand removeFileCommand,
                           GetByDateDay getByDateDay,
                           GetByDateMonth getByDateMonth,
                           GetByDateYear getByDateYear,
                           GetByDateCommand getByDateCommand,
                           Object[] args) {
        this.addFileCommand = addFileCommand;
        this.getByNameCommand = getByNameCommand;
        this.getFileCommand = getFileCommand;
        this.getByTypeCommand = getByTypeCommand;
        this.removeFileCommand = removeFileCommand;
        this.getByDateDay = getByDateDay;
        this.getByDateMonth = getByDateMonth;
        this.getByDateYear = getByDateYear;
        this.getByDateCommand = getByDateCommand;
        this.args = args;
    }
}
