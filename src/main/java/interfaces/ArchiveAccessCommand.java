package interfaces;


import services.ArchiveService;


import java.util.Map;

public abstract class ArchiveAccessCommand {

    protected ArchiveService archiveService;
    protected Output outputService;
    protected Map <String, Object> arguments;

    public ArchiveAccessCommand(ArchiveService archiveService, Output outputService, Map<String, Object> arguments) {
        this.archiveService = archiveService;
        this.outputService = outputService;
        this.arguments = arguments;
    }

    public abstract void execute();


}
