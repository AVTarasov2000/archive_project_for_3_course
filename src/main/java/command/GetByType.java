package command;

import annotations.Command;
import enums.FileType;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import throwable.InvalidArgumentsMapException;

import java.util.HashMap;

@Command(name = "get_by_type")
public class GetByType extends ArchiveAccessCommand {
    public GetByType() {
    }
//    public GetByTypeCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        Object type = arguments.get(Arguments.TYPE.getArgument());
        if(type==null|| !(type instanceof FileType)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        outputService.receiveFileList(archiveService.getByType((FileType) type));
    }
}
