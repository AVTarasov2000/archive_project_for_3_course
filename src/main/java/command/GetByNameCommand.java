package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class GetByNameCommand extends ArchiveAccessCommand {


    public GetByNameCommand(ArchiveService archiveUtils, Output outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveUtils.getByName((String)arguments.get(Arguments.NAME.getArgument())));
    }
}
