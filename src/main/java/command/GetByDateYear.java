package command;

import annotations.Command;
import interfaces.Output;
import services.ArchiveService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.Date;
import java.util.HashMap;

@Command
public class GetByDateYear extends ArchiveAccessCommand {


    public GetByDateYear(ArchiveService archiveUtils, Output outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute() {
        outputService.receiveFileList(archiveUtils.getByDateYear((Date) arguments.get(Arguments.KEY.getArgument())));
    }
}
