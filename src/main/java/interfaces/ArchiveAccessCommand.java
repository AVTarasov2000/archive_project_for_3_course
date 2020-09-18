package interfaces;


import controller.ArchiveController;
import controller.OutputController;

public abstract class ArchiveAccessCommand {

    protected ArchiveController archiveUtils;
    protected OutputController outputController;

    public ArchiveAccessCommand(ArchiveController archiveUtils, OutputController outputController) {
        this.archiveUtils = archiveUtils;
        this.outputController = outputController;
    }

    public abstract void execute();


}
