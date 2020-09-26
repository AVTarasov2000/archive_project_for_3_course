package command;

import annotations.Command;
import entitys.File;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;
import throwable.InvalidArgumentsMapException;

import java.util.Date;
import java.util.Map;

@Command(name = "get_by_arguments")
public class GetByArgumentsCommand extends ArchiveAccessCommand {

    public GetByArgumentsCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
        super(archiveService, outputService, arguments);
    }

    @Override
    public void execute() {
        Object name = arguments.get(Arguments.NAME.getArgument());
        Object type = arguments.get(Arguments.TYPE.getArgument());
        Object from = arguments.get(Arguments.DATE_FROM.getArgument());
        Object to = arguments.get(Arguments.DATE_TO.getArgument());
        if(name == null|| type == null || !(type instanceof String) || !(name instanceof String) ||
                from == null|| to == null || !(from instanceof Date) || !(to instanceof Date)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        archiveService.getByArguments(
                (String) name,
                (String) type,
                (Date) from,
                (Date) to
        );
    }
}
