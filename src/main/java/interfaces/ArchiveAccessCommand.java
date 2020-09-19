package interfaces;


import controller.ArchiveController;
import controller.OutputController;

import java.util.HashMap;

public abstract class ArchiveAccessCommand {

    protected ArchiveController archiveUtils;
    protected OutputController outputController;
    protected HashMap <String, Object> arguments;

    public ArchiveAccessCommand(ArchiveController archiveUtils, OutputController outputController, HashMap<String, Object> arguments) {
        this.archiveUtils = archiveUtils;
        this.outputController = outputController;
        this.arguments = arguments;
    }

    public abstract void execute();


}
