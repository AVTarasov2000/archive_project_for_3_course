package ui;

import entitys.Archive;
import entitys.File;
import interfaces.Output;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class OutputForServlets implements Output {

    @Getter @Setter
    private File receivedFile;
    @Getter @Setter
    private List<File> receivedFiles = new ArrayList <>();
    @Getter @Setter
    private List<Archive> receivedArchive = new ArrayList <>();

    @Override
    public void receiveFile(File file) {
        if (file!=null)
            receivedFile = file;
    }

    @Override
    public void receiveFileList(List <File> files) {
        if (files!=null)
            receivedFiles = files;
    }

    @Override
    public void receiveArchivesList(List <Archive> archives) {
        if (archives!=null)
            receivedArchive = archives;
    }
}
