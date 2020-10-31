package interfaces;

import dao.DAOArchive;
import dao.DAOFile;
import enums.FileType;

import java.util.Date;
import java.util.List;

public interface DAO {

    public void addArchive(DAOArchive archive);

    public void deleteArchive(DAOArchive archive);

    public List <DAOArchive> getAllArchives();

    public List<DAOFile> getAllFiles(DAOArchive archive);

    public void addFile(DAOFile file);

    public void removeFile(DAOFile file);

    public DAOFile getFile(DAOFile file, DAOArchive archive);

    public void editFile(DAOFile file);

    public List<DAOFile> getByType(FileType key, DAOArchive archive);

    public List<DAOFile> getByName(String key, DAOArchive archive);

    public List <DAOFile> getByDate(Date key,DAOArchive archive);

    public List<DAOFile> getByArguments(String name, FileType type, Date from, Date to, DAOArchive archive);

}
