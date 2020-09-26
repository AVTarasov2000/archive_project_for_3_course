package command;

import annotations.Command;
import interfaces.ArchiveAccessCommand;
import interfaces.Output;
import services.ArchiveService;
import java.util.Map;

@Command(name = "get_all_archives")
public class GetAllArchivesCommand extends ArchiveAccessCommand {

    public GetAllArchivesCommand(ArchiveService archiveService, Output outputService, Map <String, Object> arguments) {
        super(archiveService, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveArchivesList(archiveService.getAllArchives());
    }
}
