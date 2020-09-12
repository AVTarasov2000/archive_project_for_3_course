package logic;

import entitys.Archive;
import entitys.File;
import interfaces.FunctionalInterfaces.FileChecker;

import java.util.ArrayList;

public class ArchiveSorts {

    public static ArrayList<File> GetBy(Archive archive, Object key, FileChecker check){
        ArrayList<File> result = new ArrayList <File>();
        for (File f :
                archive.getFiles()) {
            if (check.checkFile(key, f)) {
                result.add(f);
            }
        }
        return result;
    }

}
