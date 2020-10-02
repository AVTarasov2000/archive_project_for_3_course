package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import entitys.File;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import throwable.InvalidArgumentsMapException;

import java.util.HashMap;

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
}
