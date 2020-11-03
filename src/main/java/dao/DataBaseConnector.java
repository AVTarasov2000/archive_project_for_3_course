package dao;

import dao.daoEntitys.DAOArchive;
import dao.daoEntitys.DAOFile;
import dao.daoInterfaces.Session;
import enums.FileType;
import interfaces.DAO;

import java.sql.Date;
import java.util.List;

public class DataBaseConnector implements DAO {


    private Session session;

    public DataBaseConnector(Session session) {
        this.session = session;
    }

    @Override
    public void addArchive(DAOArchive archive) {
        session.save(archive);
    }

    @Override
    public void deleteArchive(DAOArchive archive) {
        session.delete(archive);
    }

    @Override
    public List <DAOArchive> getAllArchives() {
        return session.get(DAOArchive.class);
    }

    @Override
    public List <DAOFile> getAllFiles(DAOArchive archive) {
        return session.selectQuery(DAOFile.class, "archive="+archive.getId());
//        return session.get(DAOFile.class);
    }

    @Override
    public void addFile(DAOFile file) {
        session.save(file);
    }

    @Override
    public void removeFile(DAOFile file) {
        session.delete(file);
    }

    @Override
    public DAOFile getFile(DAOFile file, DAOArchive archive) {
        return null;
    }

    @Override
    public void editFile(DAOFile file) {
        session.update(file);
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
        return session.selectQuery(DAOFile.class,
                "archive="+archive.getId(),"name='"+name+"'","type='"+type+"'",
                "date>'"+from.toString()+"'::date", "date<'"+to.toString()+"'::date");
    }
}
