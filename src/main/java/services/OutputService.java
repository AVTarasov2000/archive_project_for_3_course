package services;

import entitys.File;
import interfaces.Output;

import java.util.List;

public class OutputService implements Output {

    public void receiveFile(File file){
        System.out.println(file);
    }

    public void receiveFileList(List<File> files){
        for (File f:
             files) {
            System.out.println(f);
        }
    }

}
