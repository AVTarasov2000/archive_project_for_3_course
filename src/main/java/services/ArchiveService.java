package services;

import entitys.Archive;
import entitys.File;
import interfaces.DAO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ArchiveService {

    private DAO dao;
    private int archiveId;

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

    public ArchiveService(DAO dao) {
        this.dao = dao;
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

    public List<File> getByType(String key){
        return dao.getByType(key, archiveId);
    }

    public List<File> getByName(String key){
        return dao.getByName(key, archiveId);
    }

    public List<File> getByDate(Calendar key){
        return dao.getByDate(key, archiveId);
    }

    public List<File> getByArguments(String name, String type, Calendar from, Calendar to){
        return dao.getByArguments(name, type, from, to, archiveId);
    }

}
