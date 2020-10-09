package dao;

import entitys.Archive;
import entitys.File;
import enums.FileType;
import interfaces.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseConnector implements DAO {

    private SessionFactory sessionFactory;

    @Override
    public void addArchive(String name) {
        Session session = sessionFactory.openSession();
    }

    @Override
    public void deleteArchive(int id) {

    }

    @Override
    public List <Archive> getAllArchives() {
        return null;
    }

    @Override
    public List <File> getAllFiles(int archiveId) {
        return null;
    }

    @Override
    public void addFile(File file, int archiveId) {

    }

    @Override
    public void removeFile(int id, int archiveId) {

    }

    @Override
    public File getFile(int id, int archiveId) {
        return null;
    }

    @Override
    public void editFile(int id, File file, int archiveId) {

    }

    @Override
    public List <File> getByType(FileType key, int archiveId) {
        return null;
    }

    @Override
    public List <File> getByName(String key, int archiveId) {
        return null;
    }

    @Override
    public List <File> getByDate(Date key, int archiveId) {
        return null;
    }

    @Override
    public List <File> getByArguments(String name, FileType type, Date from, Date to, int archiveId) {
        return null;
    }
}
