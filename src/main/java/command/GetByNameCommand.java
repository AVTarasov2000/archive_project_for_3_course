package command;

import controller.ArchiveController;
import interfaces.Command;

public class GetByNameCommand extends Command {

    private ArchiveController archiveUtils;
    private String name;

    public GetByNameCommand(ArchiveController archiveUtils, String name) {
        this.archiveUtils = archiveUtils;
        this.name = name;
    }

    @Override
    public void execute() {
        archiveUtils.getByName(name);
    }
}
