package command;

import annotations.Command;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;
import throwable.InvalidArgumentsMapException;

import java.util.Map;

@Command(name = "delete_archive")
public class DeleteArchive extends ArchiveAccessCommand {
    public DeleteArchive() {
    }

    //    public DeleteArchiveCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
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
        archiveService.deleteArchive((Integer) id);
    }
}
