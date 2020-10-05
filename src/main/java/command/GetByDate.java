package command;

import annotations.Command;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.*;


@Command(name = "get_by_date")
public class GetByDate extends ArchiveAccessCommand {
    public GetByDate() {
    }
//    public GetByDateCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute()
    {
        Object date = arguments.get(Arguments.DATE.getArgument());
        if(date==null|| !(date instanceof Calendar)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        outputService.receiveFileList(archiveService.getByDate((Calendar) date));
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.DATE);
    }
}
