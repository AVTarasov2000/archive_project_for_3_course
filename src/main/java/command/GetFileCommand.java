package command;

import controller.ArchiveController;
import controller.OutputController;
import enums.ArgumentsEnum;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

public class GetFileCommand extends ArchiveAccessCommand {


    public GetFileCommand(ArchiveController archiveUtils, OutputController outputController, HashMap <String, Object> arguments) {
        super(archiveUtils, outputController, arguments);
    }

    @Override
    public void execute() {
        outputController.receiveFile(archiveUtils.getFile((Integer) arguments.get(ArgumentsEnum.ID.getArgument())));
    }
}
