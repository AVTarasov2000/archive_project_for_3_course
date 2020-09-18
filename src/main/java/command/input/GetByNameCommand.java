package command.input;

import controller.ArchiveController;
import controller.OutputController;
import entitys.File;
import interfaces.ArchiveAccessCommand;

public class GetByNameCommand extends ArchiveAccessCommand {

    private String name;

    public GetByNameCommand(ArchiveController archiveUtils, OutputController outputController, String name) {
        super(archiveUtils, outputController);
        this.name = name;
    }

    @Override
    public void execute() {
        outputController.receiveFileList(archiveUtils.getByName(name));
    }
}
