package command;

import annotations.Command;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @Override
    public List <Arguments> getRequiredArguments() {
        return new ArrayList <>();
    }
}
