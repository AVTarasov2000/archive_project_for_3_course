package command;

import annotations.Command;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;

import java.util.Map;

@Command(name = "get_all_files")
public class GetAllFiles extends ArchiveAccessCommand {
    public GetAllFiles() {
    }
//    public GetAllFilesCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveService.getAllFiles());
    }
}
