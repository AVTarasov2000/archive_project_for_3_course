package services;

import entitys.Archive;
import entitys.File;
import enums.FileType;
import interfaces.DAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ArchiveService {

    private final DAO dao;
    private int archiveId;

    public ArchiveService(DAO dao) {
        this.dao = dao;
    }

    public void choseArchive(int archiveId){
        this.archiveId = archiveId;
    }

    public void addArchive(String name){
        dao.addArchive(name);
    }

    public void deleteArchive(int id){
        dao.deleteArchive(id);
    }

    public List<Archive> getAllArchives(){
        return dao.getAllArchives();
    }

    public List<File> getAllFiles(){
        return dao.getAllFiles(archiveId);
    }

    public void addFile(File file){
        dao.addFile(file, archiveId);
    }

    public File getFile(int id){
        return dao.getFile(id, archiveId);
    }

    public void removeFile(int id){
        dao.removeFile(id, archiveId);
    }

    public void editFile(int id, File file){
        dao.editFile(id, file, archiveId);
    }

    public List<File> getByType(FileType key){
        return dao.getByType(key, archiveId);
    }

    public List<File> getByName(String key){
        return dao.getByName(key, archiveId);
    }

    public List<File> getByDate(Date key){
        return dao.getByDate(key, archiveId);
    }

    public List<File> getByArguments(String name, FileType type, Date from, Date to){
        return dao.getByArguments(name, type, from, to, archiveId);
    }

}
