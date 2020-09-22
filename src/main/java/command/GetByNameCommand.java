package command;

import annotations.Command;
import services.ArchiveService;
import services.OutputService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class GetByNameCommand extends ArchiveAccessCommand {


    public GetByNameCommand(ArchiveService archiveUtils, OutputService outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveUtils.getByName((String)arguments.get(Arguments.NAME.getArgument())));
    }
}
