package command;

import annotations.Command;
import services.ArchiveService;
import services.OutputService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class RemoveFileCommand extends ArchiveAccessCommand {

    public RemoveFileCommand(ArchiveService archiveUtils, OutputService outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        archiveUtils.removeFile((Integer) arguments.get(Arguments.ID.getArgument()));
    }
}
