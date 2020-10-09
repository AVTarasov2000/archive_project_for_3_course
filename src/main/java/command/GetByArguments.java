package command;

import annotations.Command;
import enums.Arguments;
import enums.FileType;
import throwable.InvalidArgumentsMapException;

import java.util.*;

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
                from == null|| to == null || !(from instanceof Date) || !(to instanceof Date)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        outputService.receiveFileList(archiveService.getByArguments(
                (String) name,
                (FileType) type,
                (Date) from,
                (Date) to
        ));
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.NAME, Arguments.TYPE, Arguments.DATE_FROM, Arguments.DATE_TO);
    }
}
