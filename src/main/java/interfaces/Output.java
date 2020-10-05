package interfaces;

import entitys.Archive;
import entitys.File;

import java.util.List;

public interface Output {

    public void receiveFile(File file);

    public void receiveFileList(List <File> files);

    public void receiveArchivesList(List<Archive> archives);

}
