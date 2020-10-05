package command;

import annotations.Command;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Command(name = "chose_archive")
public class ChoseArchive extends ArchiveAccessCommand {
    public ChoseArchive() {
    }

    //    public ChoseArchiveCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
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
        archiveService.choseArchive((Integer) id);
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.ID);
    }
}
