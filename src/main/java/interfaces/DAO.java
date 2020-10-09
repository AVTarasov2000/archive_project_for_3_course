package interfaces;

import entitys.Archive;
import entitys.File;
import enums.FileType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface DAO {

    public void addArchive(String name);

    public void deleteArchive(int id);

    public List<Archive> getAllArchives();

    public List<File> getAllFiles(int archiveId);

    public void addFile(File file, int archiveId);

    public void removeFile(int id, int archiveId);

    public File getFile(int id, int archiveId);

    public void editFile(int id, File file, int archiveId);

    public List<File> getByType(FileType key, int archiveId);

    public List<File> getByName(String key, int archiveId);

    public List <File> getByDate(Date key, int archiveId);

    public List<File> getByArguments(String name, FileType type, Date from, Date to, int archiveId);

}
