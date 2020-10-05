package command;

import annotations.Command;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

@Command(name = "add_archive")
public class AddArchive extends ArchiveAccessCommand {
    public AddArchive() {
    }

//    public addArchiveCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        Object name = arguments.get(Arguments.NAME.getArgument());
        if(name==null|| !(name instanceof String)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        archiveService.addArchive((String) name);
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.NAME);
    }
}
