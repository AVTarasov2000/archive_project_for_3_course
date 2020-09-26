package interfaces;


import services.ArchiveService;


import java.util.Map;

public abstract class ArchiveAccessCommand {

    protected ArchiveService archiveService;
    protected Output outputService;
    protected Map <String, Object> arguments;

    public ArchiveAccessCommand() {
    }

    public void setArchiveService(ArchiveService archiveService) {
        this.archiveService = archiveService;
    }

    public void setOutputService(Output outputService) {
        this.outputService = outputService;
    }

    public void setArguments(Map <String, Object> arguments) {
        this.arguments = arguments;
    }

//    public ArchiveAccessCommand(ArchiveService archiveService, Output outputService, Map<String, Object> arguments) {
//        this.archiveService = archiveService;
//        this.outputService = outputService;
//        this.arguments = arguments;
//    }

    public abstract void execute();


}
