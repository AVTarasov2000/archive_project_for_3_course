package command;

import annotations.Command;
import entitys.File;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import throwable.InvalidArgumentsMapException;

import java.util.HashMap;

@Command(name = "get_by_name")
public class GetByName extends ArchiveAccessCommand {
    public GetByName() {
    }
//    public GetByNameCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        Object name = arguments.get(Arguments.NAME.getArgument());
        if(name==null|| !(name instanceof String)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        outputService.receiveFileList(archiveService.getByName((String) name));
    }
}
