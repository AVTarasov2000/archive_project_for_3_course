package command.input;

import controller.ArchiveController;
import controller.OutputController;
import interfaces.ArchiveAccessCommand;

public class GetFileCommand extends ArchiveAccessCommand {

    private Integer id;

    public GetFileCommand(ArchiveController archiveUtils, OutputController outputController, Integer id) {
        super(archiveUtils, outputController);
        this.id = id;
    }

    @Override
    public void execute() {
        outputController.receiveFile(archiveUtils.getFile(id));
    }
}
