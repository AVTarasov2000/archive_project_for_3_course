package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import throwable.InvalidArgumentsMapException;

import java.util.HashMap;

@Command
public class RemoveFileCommand extends ArchiveAccessCommand {

    public RemoveFileCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
        super(archiveService, outputService, arguments);
    }

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
}
