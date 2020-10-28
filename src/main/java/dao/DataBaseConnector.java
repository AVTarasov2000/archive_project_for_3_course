package dao;

import enums.FileType;
import interfaces.DAO;
import interfaces.ObjectFactory;

import java.util.Date;
import java.util.List;

public class DataBaseConnector implements DAO {


    private ObjectFactory sessionFactory;


    @Override
    public void addArchive(DAOArchive archive) {
        Session session = sessionFactory.getObject(Session.class);
        session.save(archive.getClass());
        session.close();
    }

    @Override
    public void deleteArchive(DAOArchive archive) {
        Session session = sessionFactory.getObject(Session.class);
        session.delete(archive.getClass());
        session.close();
    }

    @Override
    public List <DAOArchive> getAllArchives() {
        Session session = sessionFactory.getObject(Session.class);
        return session.get(DAOArchive.class);
    }

    @Override
    public List <DAOFile> getAllFiles(DAOArchive archive) {
        Session session = sessionFactory.getObject(Session.class);
        return session.get(DAOFile.class);
    }

    @Override
    public void addFile(DAOFile file, DAOArchive archive) {

    }

    @Override
    public void removeFile(DAOFile file, DAOArchive archive) {

    }

    @Override
    public DAOFile getFile(DAOFile file, DAOArchive archive) {
        return null;
    }

    @Override
    public void editFile(DAOFile file, DAOArchive archive) {

    }

    @Override
    public List <DAOFile> getByType(FileType key, DAOArchive archive) {
        return null;
    }

    @Override
    public List <DAOFile> getByName(String key, DAOArchive archive) {
        return null;
    }

    @Override
    public List <DAOFile> getByDate(Date key, DAOArchive archive) {
        return null;
    }

    @Override
    public List <DAOFile> getByArguments(String name, FileType type, Date from, Date to, DAOArchive archive) {
        return null;
    }
}
