package command.input;

import controller.ArchiveController;
import controller.OutputController;
import interfaces.ArchiveAccessCommand;

public class GetByTypeCommand extends ArchiveAccessCommand {

    private String type;

    public GetByTypeCommand(ArchiveController archiveUtils, OutputController outputController, String type) {
        super(archiveUtils, outputController);
        this.type = type;
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByType(type));
    }
}
