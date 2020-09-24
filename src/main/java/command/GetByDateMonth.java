package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.Date;
import java.util.HashMap;


@Command
public class GetByDateMonth extends ArchiveAccessCommand {

    public GetByDateMonth(ArchiveService archiveUtils, Output outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveUtils.getByDateMons((Date) arguments.get(Arguments.KEY.getArgument())));
    }
}
