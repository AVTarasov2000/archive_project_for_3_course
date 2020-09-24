package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.Date;
import java.util.HashMap;


@Command
public class GetByDateDay extends ArchiveAccessCommand {

    public GetByDateDay(ArchiveService archiveUtils, Output outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveUtils.getByDateDay((Date) arguments.get(Arguments.KEY.getArgument())));
    }
}
