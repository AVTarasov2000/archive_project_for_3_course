package services;

import dao.Archive;
import entitys.File;
import interfaces.DAO;
import interfaces.functionalInterfaces.FileChecker;
import utils.ArchiveUtils;
import java.util.Date;
import java.util.List;

public class ArchiveService {

    private DAO archive;

    public ArchiveService(DAO archive) {
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

    public void editFile(int id, File file){
        archive.editFile(id, file);
    }

    public List<File> getByType(String key){
        return archive.getByType(key);
    }

    public List<File> getByName(String key){
        return archive.getByName(key);
    }

    public List<File> getByDate(Date key){
        return archive.getByDate(key);
    }

    public List<File> getByArguments(String name, String type, Date from, Date to){
        return archive.getByArguments(name, type, from, to);
    }

}
