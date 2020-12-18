package dao;

import entitys.File;
import enums.FileType;
import utils.PlaceGenerator;

import java.util.*;

public class DataBase {

    public static Map <Integer, String> archiveNames;
    public static Map<Integer, List<File>> archives;
    private static int nextArchiveId = 0;

    static {
        archiveNames = new HashMap <>();
        archives = new HashMap <>();
        PlaceGenerator placeGenerator = new PlaceGenerator();

        archiveNames.put(0, "test1");
        archives.put(0, new ArrayList <>(Arrays.asList(
                new File(0, new Date(2017-1900, 5, 10),"file1", FileType.DOCUMENT, placeGenerator.createPlace("place1".split("_"))),
                new File(1, new Date(2017-1900, 5, 11),"file1", FileType.DOCUMENT, placeGenerator.createPlace("place2".split("_"))),
                new File(2, new Date(2017-1900, 5, 12),"file1",FileType.MEDIA_LOG, placeGenerator.createPlace("place1".split("_"))),
                new File(3, new Date(2017-1900, 5, 13),"file1",FileType.MEDIA_LOG, placeGenerator.createPlace("place2".split("_"))),
                new File(4, new Date(2017-1900, 5, 14),"file2", FileType.DOCUMENT, placeGenerator.createPlace("place1".split("_"))),
                new File(5, new Date(2017-1900, 5, 15),"file2", FileType.DOCUMENT, placeGenerator.createPlace("place2".split("_"))),
                new File(6, new Date(2017-1900, 5, 16),"file2",FileType.MEDIA_LOG, placeGenerator.createPlace("place1".split("_"))),
                new File(7, new Date(2017-1900, 5, 17),"file2",FileType.MEDIA_LOG, placeGenerator.createPlace("place2".split("_")))
        )));

        archiveNames.put(1, "test2");
        archives.put(1, new ArrayList <>(Arrays.asList(
                new File(0, new Date(2017-1900, 5, 10),"file1", FileType.DOCUMENT, placeGenerator.createPlace("place1".split("_"))),
                new File(1, new Date(2017-1900, 5, 11),"file1", FileType.DOCUMENT, placeGenerator.createPlace("place2".split("_"))),
                new File(2, new Date(2017-1900, 5, 12),"file1",FileType.MEDIA_LOG, placeGenerator.createPlace("place1".split("_"))),
                new File(3, new Date(2017-1900, 5, 13),"file1",FileType.MEDIA_LOG, placeGenerator.createPlace("place2".split("_"))),
                new File(4, new Date(2017-1900, 5, 14),"file2", FileType.DOCUMENT, placeGenerator.createPlace("place1".split("_"))),
                new File(5, new Date(2017-1900, 5, 15),"file2", FileType.DOCUMENT, placeGenerator.createPlace("place2".split("_"))),
                new File(6, new Date(2017-1900, 5, 16),"file2",FileType.MEDIA_LOG, placeGenerator.createPlace("place1".split("_"))),
                new File(7, new Date(2017-1900, 5, 17),"file2",FileType.MEDIA_LOG, placeGenerator.createPlace("place2".split("_")))
        )));
        nextArchiveId = 2;
    }


//    public DataBase() {
//    }
//
//    @Override
//    public void addArchive(DAOArchive archive) {
//
//    }
//
//    @Override
//    public void deleteArchive(DAOArchive archive) {
//
//    }
//
//    @Override
//    public List <? extends DAOArchive> getAllArchives() {
//        return null;
//    }
//
//    @Override
//    public List <DAOFile> getAllFiles(DAOArchive archive) {
//        return null;
//    }
//
//    @Override
//    public void addFile(DAOFile file, DAOArchive archive) {
//
//    }
//
//    @Override
//    public void removeFile(DAOFile file, DAOArchive archive) {
//
//    }
//
//    @Override
//    public DAOFile getFile(DAOFile file, DAOArchive archive) {
//        return null;
//    }
//
//    @Override
//    public void editFile(DAOFile file, DAOArchive archive) {
//
//    }
//
//    @Override
//    public List <DAOFile> getByType(FileType key, DAOArchive archive) {
//        return null;
//    }
//
//    @Override
//    public List <DAOFile> getByName(String key, DAOArchive archive) {
//        return null;
//    }
//
//    @Override
//    public List <DAOFile> getByDate(Date key, DAOArchive archive) {
//        return null;
//    }
//
//    @Override
//    public List <DAOFile> getByArguments(String name, FileType type, Date from, Date to, DAOArchive archive) {
//        return null;
//    }

    //    @Override
//    public void addArchive(String name) {
//        archiveNames.put(nextArchiveId,name);
//        archives.put(nextArchiveId, new ArrayList <>());
//        nextArchiveId++;
//    }
//
//    @Override
//    public void deleteArchive(Integer id) {
//        archives.remove(id);
//        archiveNames.remove(id);
//    }
//
//    @Override
//    public List <Archive> getAllArchives() {
//        List<Archive> res = new ArrayList <>();
//        for (int key :
//                archiveNames.keySet()) {
//            res.add(new Archive(key,archiveNames.get(key)));
//        }
//        return res;
//    }
//
//    @Override
//    public List <File> getAllFiles(int archiveId) {
//        return archives.get(archiveId);
//    }
//
//    @Override
//    public void addFile(File file, int archiveId)
//    {
//        file.setId(archives.get(archiveId).size());
//        archives.get(archiveId).add(file);
//    }
//
//    @Override
//    public void removeFile(int id, int archiveId) {
//        archives.get(archiveId).removeIf(file -> file.getId() == id);
//    }
//
//    @Override
//    public File getFile(int id, int archiveId) {
//        for (File f :
//                archives.get(archiveId)) {
//            if (f.getId() == id) {
//                return f;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void editFile(int id, File file, int archiveId) {
//        archives.get(archiveId).removeIf(f -> f.getId() == id);
//        file.setId(id);
//        archives.get(archiveId).add(file);
//    }
//
//    @Override
//    public List <File> getByType(FileType key, int archiveId) {
//        return archives.get(archiveId).stream().filter(file->file.getType().compareTo(key)==0).collect(Collectors.toList());
//    }
//
//    @Override
//    public List <File> getByName(String key, int archiveId) {
//        return archives.get(archiveId).stream().filter(file->file.getName().compareTo(key)==0).collect(Collectors.toList());
//    }
//
//    @Override
//    public List <File> getByDate(Date key, int archiveId) {
//        return archives.get(archiveId).stream().filter(file->file.getDatetime().compareTo(key)==0).collect(Collectors.toList());
//    }
//
//    @Override
//    public List <File> getByArguments(String name, FileType type, Date from, Date to, int archiveId) {
//        List<File> res = archives.get(archiveId);
//        if(name!=null)
//            res = res.stream().filter(file->file.getName().compareTo(name)==0).collect(Collectors.toList());
//        if (type!=null)
//            res = res.stream().filter(file->file.getType().compareTo(type)==0).collect(Collectors.toList());
//        if (from!=null)
//            res = res.stream().filter(file->file.getDatetime().compareTo(from)>0).collect(Collectors.toList());
//        if (to!=null)
//            res = res.stream().filter(file->file.getDatetime().compareTo(to)<0).collect(Collectors.toList());
//        return res;
//    }
}
