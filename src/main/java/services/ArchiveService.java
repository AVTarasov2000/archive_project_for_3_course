package services;

import dao.DAOArchive;
import dao.DAOFile;
import dao.EntityConverter;
import entitys.Archive;
import entitys.File;
import enums.FileType;
import interfaces.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArchiveService {

    private final DAO dao;
    private DAOArchive archive;

    public ArchiveService(DAO dao) {
        this.dao = dao;
    }

    public void choseArchive(Integer archiveId){
        this.archive = new DAOArchive(archiveId);
    }

    public void addArchive(String name){
        dao.addArchive(new DAOArchive(-1, name));
    }

    public void deleteArchive(Integer id){
        dao.deleteArchive(new DAOArchive(id));
    }

    public List<Archive> getAllArchives(){
        List<Archive> res = new ArrayList <>();
        for (DAOArchive allArchive : dao.getAllArchives()) {
            res.add(EntityConverter.convert(allArchive));
        }
        return res;
    }

    public List<File> getAllFiles(){
        List<File> res = new ArrayList <>();
        for (DAOFile file : dao.getAllFiles(archive)) {
            res.add(EntityConverter.convert(file));
        }
        return res;
    }

    public void addFile(File file){
        dao.addFile(EntityConverter.convert(file, archive.getId()));
    }

    public File getFile(int id){
        return EntityConverter.convert(dao.getFile(new DAOFile(id), archive));
    }

    public void removeFile(int id){
        dao.removeFile(new DAOFile(id));
    }

    public void editFile(File file){
        dao.editFile(EntityConverter.convert(file, archive.getId()));
    }

    public List<File> getByType(FileType key){
        List<File> res = new ArrayList <>();
        for (DAOFile file : dao.getByType(key, archive)) {
            res.add(EntityConverter.convert(file));
        }
        return res;
    }

    public List<File> getByName(String key){
        List<File> res = new ArrayList <>();
        for (DAOFile file : dao.getByName(key, archive)) {
            res.add(EntityConverter.convert(file));
        }
        return res;
    }

    public List<File> getByDate(Date key){
        List<File> res = new ArrayList <>();
        for (DAOFile file : dao.getByDate(key, archive)) {
            res.add(EntityConverter.convert(file));
        }
        return res;
    }

    public List<File> getByArguments(String name, FileType type, Date from, Date to){
        List<File> res = new ArrayList <>();
        for (DAOFile file : dao.getByArguments(name, type, from, to, archive)) {
            res.add(EntityConverter.convert(file));
        }
        return res;
    }

}
