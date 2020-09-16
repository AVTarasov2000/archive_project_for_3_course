package controller;

import entitys.Archive;
import entitys.File;
import utils.ArchiveUtils;

import java.util.ArrayList;

public class ArchiveController {

    private Archive archive;

    public ArchiveController(Archive archive) {
        this.archive = archive;
    }

    public void addFile(File file){
        archive.addFile(file);
    }

    public File getFile(int id){
        return archive.getFile(id);
    }

    public void removeFile(int id){
        archive.removeFile(id);
    }

    public ArrayList<File> getByType(String key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByType);
    }

    public ArrayList<File> getByName(String key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByName);
    }

    public ArrayList<File> getByDate(String key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByDate);
    }


}
