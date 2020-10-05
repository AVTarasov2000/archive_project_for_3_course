package command;

import annotations.Command;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

@Command(name = "remove_file")
public class RemoveFile extends ArchiveAccessCommand {

    public RemoveFile() {
    }

//    public RemoveFileCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute()
    {
        Object id = arguments.get(Arguments.ID.getArgument());
        if(id==null|| !(id instanceof Integer)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        archiveService.removeFile((Integer) id);
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.ID);
    }
}
