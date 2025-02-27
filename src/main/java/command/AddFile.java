package command;

import annotations.Command;
import entitys.File;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

@Command(name = "add_file")
public class AddFile extends ArchiveAccessCommand {
    public AddFile() {
    }
//    public AddFileCommand(ArchiveService archiveService, Output outputService, HashMap<String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        Object file = arguments.get(Arguments.FILE.getArgument());
        if(file==null || !(file instanceof File)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        archiveService.addFile((File) file);
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.FILE);
    }
}
