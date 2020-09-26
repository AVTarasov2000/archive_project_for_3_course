package command;

import annotations.Command;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;
import throwable.InvalidArgumentsMapException;

import java.util.Map;

@Command(name = "chose_archive")
public class ChoseArchiveCommand extends ArchiveAccessCommand {
    public ChoseArchiveCommand() {
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
}
