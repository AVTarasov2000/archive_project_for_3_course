package command.input;

import controller.ArchiveController;
import controller.OutputController;
import entitys.File;
import interfaces.ArchiveAccessCommand;

public class AddFileCommand extends ArchiveAccessCommand {

    private File file;

    public AddFileCommand(ArchiveController archiveUtils, OutputController outputController, File file) {
        super(archiveUtils, outputController);
        this.file = file;
    }

    @Override
    public void execute() {
        archiveUtils.addFile(file);
    }
}
