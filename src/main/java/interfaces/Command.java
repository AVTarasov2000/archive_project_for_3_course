package interfaces;

import utils.ArchiveUtils;

public abstract class Command {

    private ArchiveUtils archiveUtils;

    public abstract void execute();


}
