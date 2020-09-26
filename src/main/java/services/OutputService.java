package services;

import entitys.Archive;
import entitys.File;
import interfaces.Output;

import java.util.List;

public class OutputService implements Output {

    @Override
    public void receiveFile(File file){
        System.out.println(file);
    }
    @Override
    public void receiveFileList(List<File> files){
        for (File f:
             files) {
            System.out.println(f);
        }
    }

    @Override
    public void receiveArchivesList(List <Archive> archives) {
        for (Archive arch :
                archives) {
            System.out.printf(arch.toString());
        }
    }

}
