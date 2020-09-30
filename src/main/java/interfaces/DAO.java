package interfaces;

import entitys.Archive;
import entitys.File;

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

    public List<File> getByType(String key, int archiveId);

    public List<File> getByName(String key, int archiveId);

    public List <File> getByDate(Calendar key, int archiveId);

    public List<File> getByArguments(String name, String type, Calendar from, Calendar to, int archiveId);

}
