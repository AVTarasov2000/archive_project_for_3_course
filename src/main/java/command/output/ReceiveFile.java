package command.output;

import controller.OutputController;
import entitys.File;
import interfaces.Command;


public class ReceiveFile extends Command {

    private OutputController outputController;
    private File file;

    public ReceiveFile(OutputController outputController, File file) {
        this.outputController = outputController;
        this.file = file;
    }

    @Override
    public void execute() {
        outputController.receiveFile(file);
    }
}
