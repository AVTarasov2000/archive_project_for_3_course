package command;

import annotations.Command;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

@Command(name = "get_file")
public class GetFile extends ArchiveAccessCommand {
    public GetFile() {
    }

//    public GetFileCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        Object id = arguments.get(Arguments.ID.getArgument());
        if(id==null|| !(id instanceof Integer)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        outputService.receiveFile(archiveService.getFile((Integer) id));
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.ID);
    }
}
