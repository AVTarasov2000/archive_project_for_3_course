package command;

import annotations.Command;
import entitys.File;
import enums.Arguments;
import enums.FileType;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;
import throwable.InvalidArgumentsMapException;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Command(name = "get_by_arguments")
public class GetByArguments extends ArchiveAccessCommand {
    public GetByArguments() {
    }
//    public GetByArgumentsCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        Object name = arguments.get(Arguments.NAME.getArgument());
        Object type = arguments.get(Arguments.TYPE.getArgument());
        Object from = arguments.get(Arguments.DATE_FROM.getArgument());
        Object to = arguments.get(Arguments.DATE_TO.getArgument());
        if(name == null|| type == null || !(type instanceof FileType) || !(name instanceof String) ||
                from == null|| to == null || !(from instanceof Calendar) || !(to instanceof Calendar)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        outputService.receiveFileList(archiveService.getByArguments(
                (String) name,
                (FileType) type,
                (Calendar) from,
                (Calendar) to
        ));
    }
}
