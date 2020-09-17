package command;

import controller.ArchiveController;
import interfaces.Command;

public class RemoveFileCommand extends Command {

    private ArchiveController archiveUtils;
    private int id;

    public RemoveFileCommand(ArchiveController archiveUtils, int id) {
        this.archiveUtils = archiveUtils;
        this.id = id;
    }

    @Override
    public void execute() {
        archiveUtils.removeFile(id);
    }
}
