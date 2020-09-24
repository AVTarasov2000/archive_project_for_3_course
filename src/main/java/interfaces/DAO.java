package interfaces;

import entitys.File;

import java.util.Date;
import java.util.List;

public interface DAO {

    public List<File> getAllFiles();

    public void addFile(File file);

    public void removeFile(int id);

    public File getFile(int id);

    public void editFile(int id, File file);

    public List<File> getByType(String key);

    public List<File> getByName(String key);

    public List <File> getByDate(Date key);

    public List<File> getByArguments(String name, String type, Date from, Date to);

}
