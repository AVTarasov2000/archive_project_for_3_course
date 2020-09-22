package dao;

import entitys.File;

import java.util.Date;
import java.util.List;

public interface DAO {

    public List<File> getAllFiles();

    public void addFile(File file);

    public void removeFile(int id);

    public void changeFile(int id, File file);

    public List<File> getByType(String key);

    public List<File> getByName(String key);

    public List <File> getByDate(Date key, Integer comparatorValue);


}
