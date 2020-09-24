package interfaces;

import entitys.File;

import java.util.List;

public interface Output {

    public void receiveFile(File file);

    public void receiveFileList(List <File> files);

}
