package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import entitys.File;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

@Command
public class AddFileCommand extends ArchiveAccessCommand {


    public AddFileCommand(ArchiveService archiveUtils, Output outputService, HashMap<String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        archiveUtils.addFile((File) arguments.get(Arguments.FILE.getArgument()));
    }
}
