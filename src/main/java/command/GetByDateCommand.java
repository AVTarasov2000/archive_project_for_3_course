package command;

import interfaces.Command;
import utils.ArchiveUtils;

import java.util.Date;

public class GetByDateCommand extends Command {

    private ArchiveUtils archiveUtils;
    private Date key;

    public GetByDateCommand(ArchiveUtils archiveUtils, Date key) {
        this.archiveUtils = archiveUtils;
        this.key = key;
    }

    @Override
    public void execute() {

    }
}
