package command;

import annotations.Command;
import enums.FileType;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

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
    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.TYPE);
    }
}
