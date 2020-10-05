package command;

import annotations.Command;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

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
    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.ID);
    }
}
