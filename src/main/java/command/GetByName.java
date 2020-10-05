package command;

import annotations.Command;
import enums.Arguments;
import throwable.InvalidArgumentsMapException;

import java.util.Arrays;
import java.util.List;

@Command(name = "get_by_name")
public class GetByName extends ArchiveAccessCommand {
    public GetByName() {
    }
//    public GetByNameCommand(ArchiveService archiveService, Output outputService, HashMap <String, Object> arguments) {
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
        outputService.receiveFileList(archiveService.getByName((String) name));
    }
    @Override
    public List <Arguments> getRequiredArguments() {
        return Arrays.asList(Arguments.NAME);
    }
}
