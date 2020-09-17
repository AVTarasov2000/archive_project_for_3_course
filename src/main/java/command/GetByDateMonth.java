package command;

import controller.ArchiveController;
import interfaces.Command;

import java.util.Date;

public class GetByDateMonth extends Command {

    private ArchiveController archiveUtils;
    private Date key;

    public GetByDateMonth(ArchiveController archiveUtils, Date key) {
        this.archiveUtils = archiveUtils;
        this.key = key;
    }

    @Override
    public void execute() {
        archiveUtils.getByDateMons(key);
    }
}
