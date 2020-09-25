package services;

import entitys.Archive;
import entitys.File;
import interfaces.DAO;

import java.util.Date;
import java.util.List;

public class ArchiveService {

    private DAO dao;

    public void choseArchive(int archiveId){
        dao.choseArchive(archiveId);
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
        return dao.getAllFiles();
    }

    public ArchiveService(DAO dao) {
        this.dao = dao;
    }

    public void addFile(File file){
        dao.addFile(file);
    }

    public File getFile(int id){
        return dao.getFile(id);
    }

    public void removeFile(int id){
        dao.removeFile(id);
    }

    public void editFile(int id, File file){
        dao.editFile(id, file);
    }

    public List<File> getByType(String key){
        return dao.getByType(key);
    }

    public List<File> getByName(String key){
        return dao.getByName(key);
    }

    public List<File> getByDate(Date key){
        return dao.getByDate(key);
    }

    public List<File> getByArguments(String name, String type, Date from, Date to){
        return dao.getByArguments(name, type, from, to);
    }

}
