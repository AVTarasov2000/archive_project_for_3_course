package command;

import annotations.Command;
import enums.Arguments;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List <Arguments> getRequiredArguments() {
        return new ArrayList <>();
    }
}
