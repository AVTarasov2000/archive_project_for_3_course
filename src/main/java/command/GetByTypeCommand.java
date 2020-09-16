package command;

import interfaces.Command;
import utils.ArchiveUtils;

public class GetByTypeCommand extends Command {

    private ArchiveUtils archiveUtils;
    private String type;

    public GetByTypeCommand(ArchiveUtils archiveUtils, String type) {
        this.archiveUtils = archiveUtils;
        this.type = type;
    }

    @Override
    public void execute() {

    }
}
