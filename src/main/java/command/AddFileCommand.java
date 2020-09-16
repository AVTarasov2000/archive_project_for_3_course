package command;

import entitys.File;
import interfaces.Command;
import utils.ArchiveUtils;

public class AddFileCommand extends Command {

    private ArchiveUtils archiveUtils;
    private File file;

    public AddFileCommand(ArchiveUtils archiveUtils, File file) {
        this.archiveUtils = archiveUtils;
        this.file = file;
    }

    @Override
    public void execute() {

    }
}
