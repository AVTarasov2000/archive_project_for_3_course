package command;

import interfaces.Command;
import utils.ArchiveUtils;

public class RemoveFileCommand extends Command {

    private ArchiveUtils archiveUtils;
    private int id;

    public RemoveFileCommand(ArchiveUtils archiveUtils, int id) {
        this.archiveUtils = archiveUtils;
        this.id = id;
    }

    @Override
    public void execute() {

    }
}
