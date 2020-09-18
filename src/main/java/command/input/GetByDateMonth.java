package command.input;

import controller.ArchiveController;
import controller.OutputController;
import interfaces.ArchiveAccessCommand;

import java.util.Date;

public class GetByDateMonth extends ArchiveAccessCommand {

    private Date key;

    public GetByDateMonth(ArchiveController archiveUtils, OutputController outputController, Date key) {
        super(archiveUtils, outputController);
        this.key = key;
    }

    @Override
    public void execute() {
        archiveUtils.getByDateMons(key);
    }
}
