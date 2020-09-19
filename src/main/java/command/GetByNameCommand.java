package command;

import controller.ArchiveController;
import controller.OutputController;
import entitys.File;
import enums.ArgumentsEnum;
import interfaces.ArchiveAccessCommand;

import java.util.HashMap;

public class GetByNameCommand extends ArchiveAccessCommand {


    public GetByNameCommand(ArchiveController archiveUtils, OutputController outputController, HashMap <String, Object> arguments) {
        super(archiveUtils, outputController, arguments);
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByName((String)arguments.get(ArgumentsEnum.NAME.getArgument())));
    }
}
