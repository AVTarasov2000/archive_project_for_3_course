package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class GetFileCommand extends ArchiveAccessCommand {


    public GetFileCommand(ArchiveService archiveUtils, Output outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFile(archiveUtils.getFile((Integer) arguments.get(Arguments.ID.getArgument())));
    }
}
