package controller;

import entitys.File;

import java.util.List;

public class OutputController{

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
