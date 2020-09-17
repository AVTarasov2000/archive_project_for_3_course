package command;

import controller.ArchiveController;
import interfaces.Command;
import utils.ArchiveUtils;

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
