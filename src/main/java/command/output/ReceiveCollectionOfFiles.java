package command.output;

import controller.OutputController;
import entitys.File;
import interfaces.Command;

import java.util.List;

public class ReceiveCollectionOfFiles extends Command {

    private OutputController outputController;
    private List <File> fileList;

    public ReceiveCollectionOfFiles(OutputController outputController, List <File> fileList) {
        this.outputController = outputController;
        this.fileList = fileList;
    }

    @Override
    public void execute() {
        outputController.receiveFileList(fileList);
    }
}
