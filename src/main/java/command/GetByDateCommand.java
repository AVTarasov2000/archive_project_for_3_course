package command;

import annotations.Command;
import entitys.File;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import throwable.InvalidArgumentsMapException;

import java.util.Date;
import java.util.HashMap;


@Command(name = "get_by_date")
public class GetByDateCommand extends ArchiveAccessCommand {

    public GetByDateCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
        super(archiveService, outputService, arguments);
    }

    @Override
    public void execute()
    {
        Object date = arguments.get(Arguments.DATE.getArgument());
        if(date==null|| !(date instanceof Date)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        outputService.receiveFileList(archiveService.getByDate((Date) date));
    }
}
