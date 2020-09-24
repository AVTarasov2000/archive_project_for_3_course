package interfaces;


import services.ArchiveService;


import java.util.HashMap;

public abstract class ArchiveAccessCommand {

    protected ArchiveService archiveUtils;
    protected Output outputService;
    protected HashMap <String, Object> arguments;

    public ArchiveAccessCommand(ArchiveService archiveUtils, Output outputService, HashMap<String, Object> arguments) {
        this.archiveUtils = archiveUtils;
        this.outputService = outputService;
        this.arguments = arguments;
    }

    public abstract void execute();


}
