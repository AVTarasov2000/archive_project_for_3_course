package command;

import controller.ArchiveController;
import controller.OutputController;
import entitys.File;
import enums.ArgumentsEnum;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

public class AddFileCommand extends ArchiveAccessCommand {


    public AddFileCommand(ArchiveController archiveUtils, OutputController outputController, HashMap<String, Object> arguments) {
        super(archiveUtils, outputController, arguments);
    }

    @Override
    public void execute() {
        archiveUtils.addFile((File) arguments.get(ArgumentsEnum.FILE.getArgument()));
    }
}
