package interfaces;

import entitys.Archive;
import entitys.File;
import enums.FileType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface DAO {

    public void addArchive(Archive archive);

    public void deleteArchive(Archive archive);

    public List<Archive> getAllArchives();

    public List<File> getAllFiles(Archive archive);

    public void addFile(File file, Archive archive);

    public void removeFile(File file, Archive archive);

    public File getFile(File file, Archive archive);

    public void editFile(File file, Archive archive);

    public List<File> getByType(FileType key, Archive archive);

    public List<File> getByName(String key, Archive archive);

    public List <File> getByDate(Date key,Archive archive);

    public List<File> getByArguments(String name, FileType type, Date from, Date to, Archive archive);

}
