package command;

import annotations.Command;
import services.ArchiveService;
import services.OutputService;
import entitys.File;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class AddFileCommand extends ArchiveAccessCommand {


    public AddFileCommand(ArchiveService archiveUtils, OutputService outputService, HashMap<String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        archiveUtils.addFile((File) arguments.get(Arguments.FILE.getArgument()));
    }
}
