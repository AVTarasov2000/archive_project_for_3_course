package command.input;

import controller.ArchiveController;
import interfaces.Command;

public class GetByTypeCommand extends Command {

    private ArchiveController archiveUtils;
    private String type;

    public GetByTypeCommand(ArchiveController archiveUtils, String type) {
        this.archiveUtils = archiveUtils;
        this.type = type;
    }

    @Override
    public void execute() {
        archiveUtils.getByType(type);
    }
}
