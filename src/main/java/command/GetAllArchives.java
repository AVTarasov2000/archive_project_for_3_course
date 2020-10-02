package command;

import annotations.Command;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;

import java.util.ArrayList;
import java.util.List;

@Command(name = "get_all_archives")
public class GetAllArchives extends ArchiveAccessCommand {
    public GetAllArchives() {
    }
//    public GetAllArchivesCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
//        super(archiveService, outputService, arguments);
//    }

    @Override
    public void execute() {
        outputService.receiveArchivesList(archiveService.getAllArchives());
    }

    @Override
    public List <Arguments> getRequiredArguments() {
        return new ArrayList <>();
    }
}
