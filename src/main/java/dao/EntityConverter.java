package dao;

import entitys.Archive;
import entitys.File;


public class EntityConverter {

    public static DAOFile convert(File f){
        return new DAOFile();
    }

    public static File convert(DAOFile f){
        return new File();
    }

    public static DAOArchive convert(Archive f){
        return new DAOArchive(f.getId(),f.getName());
    }
    public static Archive convert(DAOArchive f){
        return new Archive(f.getId(),f.getName());
    }
}
