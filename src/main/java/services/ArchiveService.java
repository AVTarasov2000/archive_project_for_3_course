package services;

import dao.Archive;
import entitys.File;
import interfaces.functionalInterfaces.FileChecker;
import utils.ArchiveUtils;


import java.util.Date;
import java.util.List;

public class ArchiveService {

    private Archive archive;

    public ArchiveService(Archive archive) {
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
        return ArchiveUtils.getBy(archive,key, new FileChecker[]{ArchiveUtils::getByType},new Integer[]{0});
    }

    public List<File> getByName(String key){
        return ArchiveUtils.getBy(archive,key, new FileChecker[]{ArchiveUtils::getByName}, new Integer[]{0});
    }

    public List <File> getByDate(Date key, Integer comparatorValue){
        return ArchiveUtils.getBy(archive,key, new FileChecker[]{ArchiveUtils::getByDate}, new Integer[]{comparatorValue});
    }

    public List <File> getByDateYear(Date key){
        return ArchiveUtils.getBy(archive,key, new FileChecker[]{ArchiveUtils::getByDateYear}, new Integer[]{0});
    }

    public List <File> getByDateMons(Date key){
        return ArchiveUtils.getBy(archive,key, new FileChecker[]{ArchiveUtils::getByDateMonth}, new Integer[]{0});
    }

    public List <File> getByDateDay(Date key){
        return ArchiveUtils.getBy(archive,key, new FileChecker[]{ArchiveUtils::getByDateDay}, new Integer[]{0});
    }

}
