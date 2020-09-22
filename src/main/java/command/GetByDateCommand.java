package command;

import annotations.Command;
import services.ArchiveService;
import services.OutputService;
import enums.Arguments;
import interfaces.ArchiveAccessCommand;

import java.util.Date;
import java.util.HashMap;


@Command
public class GetByDateCommand extends ArchiveAccessCommand {

    public GetByDateCommand(ArchiveService archiveUtils, OutputService outputService, HashMap <String, Object> arguments) {
        super(archiveUtils, outputService, arguments);
    }

    @Override
    public void execute()
    {
        outputService.receiveFileList(archiveUtils.getByDate((Date)arguments.get(Arguments.KEY.getArgument()), (Integer)arguments.get(Arguments.COMPARE_VALUE.getArgument())));
    }
}
