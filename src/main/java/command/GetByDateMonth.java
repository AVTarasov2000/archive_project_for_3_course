package command;

import controller.ArchiveController;
import controller.OutputController;
import enums.ArgumentsEnum;
import interfaces.ArchiveAccessCommand;

import java.util.Date;
import java.util.HashMap;

public class GetByDateMonth extends ArchiveAccessCommand {


    public GetByDateMonth(ArchiveController archiveUtils, OutputController outputController, HashMap <String, Object> arguments) {
        super(archiveUtils, outputController, arguments);
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByDateMons((Date) arguments.get(ArgumentsEnum.KEY.getArgument())));
    }
}
