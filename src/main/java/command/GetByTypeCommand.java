package command;

import annotations.Command;
import services.ArchiveService;
import services.OutputService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class GetByTypeCommand extends ArchiveAccessCommand {


    public GetByTypeCommand(ArchiveService archiveUtils, OutputService outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveUtils.getByType((String) arguments.get(Arguments.TYPE.getArgument())));
    }
}
