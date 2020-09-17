package command;

import controller.ArchiveController;
import interfaces.Command;

import java.util.Date;

public class GetByDateDay extends Command {

    private ArchiveController archiveUtils;
    private Date key;

    public GetByDateDay(ArchiveController archiveUtils, Date key) {
        this.archiveUtils = archiveUtils;
        this.key = key;
    }

    @Override
    public void execute() {
        archiveUtils.getByDateDay(key);
    }
}
