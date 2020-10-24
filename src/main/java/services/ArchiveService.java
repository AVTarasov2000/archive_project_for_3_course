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
    private Archive archive;

    public ArchiveService(DAO dao) {
        this.dao = dao;
    }

    public void choseArchive(Integer archiveId){
        this.archive = new Archive(archiveId, null);
    }

    public void addArchive(String name){
        dao.addArchive(new Archive(null, name));
    }

    public void deleteArchive(Integer id){
        dao.deleteArchive(new Archive(id, null));
    }

    public List<Archive> getAllArchives(){
        return dao.getAllArchives();
    }

    public List<File> getAllFiles(){
        return dao.getAllFiles(archive);
    }

    public void addFile(File file){
        dao.addFile(file, archive);
    }

    public File getFile(int id){
        return dao.getFile(new File(id, null,null,null, null), archive);
    }

    public void removeFile(int id){
        dao.removeFile(new File(id, null,null,null, null), archive);
    }

    public void editFile(File file){
        dao.editFile(file, archive);
    }

    public List<File> getByType(FileType key){
        return dao.getByType(key, archive);
    }

    public List<File> getByName(String key){
        return dao.getByName(key, archive);
    }

    public List<File> getByDate(Date key){
        return dao.getByDate(key, archive);
    }

    public List<File> getByArguments(String name, FileType type, Date from, Date to){
        return dao.getByArguments(name, type, from, to, archive);
    }

}
