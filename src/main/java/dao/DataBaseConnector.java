package dao;

import entitys.Archive;
import entitys.File;
import enums.FileType;
import interfaces.DAO;

import java.util.Date;
import java.util.List;

public class DataBaseConnector implements DAO {

    private MySessionFactory sessionFactory;


    @Override
    public void addArchive(Archive archive) {
        MySession session = new MySession();
        Transaction tx = session.beginTransaction();
        session.save(archive);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteArchive(Archive archive) {
        MySession session = new MySession();
        Transaction tx = session.beginTransaction();
        session.delete(archive);
        tx.commit();
        session.close();
    }

    @Override
    public List <Archive> getAllArchives() {
        return new MySession().get(new Archive());
    }

    @Override
    public List <File> getAllFiles(Archive archive) {
        return new MySession().get(new File());
    }

    @Override
    public void addFile(File file, Archive archive) {

    }

    @Override
    public void removeFile(File file, Archive archive) {

    }

    @Override
    public File getFile(File file, Archive archive) {
        return null;
    }

    @Override
    public void editFile(File file, Archive archive) {

    }

    @Override
    public List <File> getByType(FileType key, Archive archive) {
        return null;
    }

    @Override
    public List <File> getByName(String key, Archive archive) {
        return null;
    }

    @Override
    public List <File> getByDate(Date key, Archive archive) {
        return null;
    }

    @Override
    public List <File> getByArguments(String name, FileType type, Date from, Date to, Archive archive) {
        return null;
    }
}
