package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class GetByTypeCommand extends ArchiveAccessCommand {


    public GetByTypeCommand(ArchiveService archiveUtils, Output outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveUtils.getByType((String) arguments.get(Arguments.TYPE.getArgument())));
    }
}
