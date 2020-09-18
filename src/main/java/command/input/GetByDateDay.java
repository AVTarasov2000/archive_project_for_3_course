package command.input;

import controller.ArchiveController;
import controller.OutputController;
import interfaces.ArchiveAccessCommand;

import java.util.Date;
import java.util.List;

public class GetByDateDay extends ArchiveAccessCommand {


    private Date key;

    public GetByDateDay(ArchiveController archiveUtils,OutputController outputController, Date key) {
        super(archiveUtils, outputController);
        this.key = key;
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByDateDay(key));
    }
}
