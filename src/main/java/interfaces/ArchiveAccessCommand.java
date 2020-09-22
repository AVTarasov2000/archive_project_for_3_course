package interfaces;


import services.ArchiveService;
import services.OutputService;

import java.util.HashMap;

public abstract class ArchiveAccessCommand {

    protected ArchiveService archiveUtils;
    protected OutputService outputService;
    protected HashMap <String, Object> arguments;

    public ArchiveAccessCommand(ArchiveService archiveUtils, OutputService outputService, HashMap<String, Object> arguments) {
        this.archiveUtils = archiveUtils;
        this.outputService = outputService;
        this.arguments = arguments;
    }

    public abstract void execute();


}
