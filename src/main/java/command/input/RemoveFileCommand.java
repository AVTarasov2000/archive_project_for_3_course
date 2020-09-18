package command.input;

import controller.ArchiveController;
import controller.OutputController;
import interfaces.ArchiveAccessCommand;

public class RemoveFileCommand extends ArchiveAccessCommand {

    private Integer id;

    public RemoveFileCommand(ArchiveController archiveUtils, OutputController outputController, Integer id) {
        super(archiveUtils, outputController);
        this.id = id;
    }

    @Override
    public void execute() {
        archiveUtils.removeFile(id);
    }
}
