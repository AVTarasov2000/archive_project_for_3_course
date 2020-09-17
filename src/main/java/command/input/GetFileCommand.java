package command.input;

import controller.ArchiveController;
import interfaces.Command;

public class GetFileCommand extends Command {

    private ArchiveController archiveUtils;
    private int id;

    public GetFileCommand(ArchiveController archiveUtils, int id) {
        this.archiveUtils = archiveUtils;
        this.id = id;
    }

    @Override
    public void execute() {
        archiveUtils.getFile(id);
    }
}
