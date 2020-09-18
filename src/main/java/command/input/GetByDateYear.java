package command.input;

import controller.ArchiveController;
import controller.OutputController;
import interfaces.ArchiveAccessCommand;

import java.util.Date;

public class GetByDateYear extends ArchiveAccessCommand {

    private Date key;

    public GetByDateYear(ArchiveController archiveUtils, OutputController outputController, Date key) {
        super(archiveUtils, outputController);
        this.key = key;
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByDateYear(key));
    }
}
