package command.input;

import controller.ArchiveController;
import entitys.File;
import interfaces.Command;

public class AddFileCommand extends Command {

    private ArchiveController archiveUtils;
    private File file;

    public AddFileCommand(ArchiveController archiveUtils, File file) {
        this.archiveUtils = archiveUtils;
        this.file = file;
    }

    @Override
    public void execute() {
        archiveUtils.addFile(file);
    }
}
