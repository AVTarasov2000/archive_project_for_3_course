package controller;

import entitys.Archive;
import entitys.File;
import utils.ArchiveUtils;


import java.util.Date;
import java.util.List;

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

    public List<File> getByType(String key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByType);
    }

    public List<File> getByName(String key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByName);
    }

    public List <File> getByDate(Date key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByDate);
    }

    public List <File> getByDateYear(Date key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByDateYear);
    }

    public List <File> getByDateMons(Date key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByDateMonth);
    }

    public List <File> getByDateDay(Date key){
        return ArchiveUtils.GetBy(archive,key, ArchiveUtils::getByDateDay);
    }

}
