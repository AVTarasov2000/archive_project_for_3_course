package command;

import controller.ArchiveController;
import controller.OutputController;
import enums.ArgumentsEnum;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

public class GetByTypeCommand extends ArchiveAccessCommand {


    public GetByTypeCommand(ArchiveController archiveUtils, OutputController outputController, HashMap <String, Object> arguments) {
        super(archiveUtils, outputController, arguments);
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByType((String) arguments.get(ArgumentsEnum.TYPE.getArgument())));
    }
}
