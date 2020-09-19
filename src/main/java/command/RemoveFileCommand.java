package command;

import controller.ArchiveController;
import controller.OutputController;
import enums.ArgumentsEnum;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

public class RemoveFileCommand extends ArchiveAccessCommand {


    public RemoveFileCommand(ArchiveController archiveUtils, OutputController outputController, HashMap <String, Object> arguments) {
        super(archiveUtils, outputController, arguments);
    }

    @Override
    public void execute() {
        archiveUtils.removeFile((Integer) arguments.get(ArgumentsEnum.ID.getArgument()));
    }
}
