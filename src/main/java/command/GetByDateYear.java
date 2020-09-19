package command;

import controller.ArchiveController;
import controller.OutputController;
import enums.ArgumentsEnum;
import interfaces.ArchiveAccessCommand;

import java.util.Date;
import java.util.HashMap;

public class GetByDateYear extends ArchiveAccessCommand {


    public GetByDateYear(ArchiveController archiveUtils, OutputController outputController, HashMap <String, Object> arguments) {
        super(archiveUtils, outputController, arguments);
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByDateYear((Date) arguments.get(ArgumentsEnum.KEY.getArgument())));
    }
}
