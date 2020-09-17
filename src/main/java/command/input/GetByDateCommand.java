package command.input;

import controller.ArchiveController;
import interfaces.Command;

import java.util.Date;

public class GetByDateCommand extends Command {

    private ArchiveController archiveUtils;
    private Date key;

    public GetByDateCommand(ArchiveController archiveUtils, Date key) {
        this.archiveUtils = archiveUtils;
        this.key = key;
    }

    @Override
    public void execute() {
        archiveUtils.getByDate(key);
    }
}
