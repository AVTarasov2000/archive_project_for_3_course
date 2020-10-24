package command;

import annotations.Command;
import entitys.File;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

@Command(name = "edit_file")
public class EditFile extends ArchiveAccessCommand {
    public EditFile() {
    }

    //    public EditFileCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute()
    {
        Object file = arguments.get(Arguments.FILE.getArgument());
        Object id = arguments.get(Arguments.ID.getArgument());
        if(file==null|| id==null || !(id instanceof Integer) || !(file instanceof File)){
            try {
                throw new InvalidArgumentsMapException();
            } catch (InvalidArgumentsMapException e) {
                e.printStackTrace();
            }
        }
        archiveService.editFile((File) file);
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.FILE, Arguments.ID);
    }
}
