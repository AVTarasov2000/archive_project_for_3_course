package command;

import interfaces.Command;
import utils.ArchiveUtils;

public class GetByNameCommand extends Command {

    private ArchiveUtils archiveUtils;
    private String name;

    public GetByNameCommand(ArchiveUtils archiveUtils, String name) {
        this.archiveUtils = archiveUtils;
        this.name = name;
    }

    @Override
    public void execute() {

    }
}
