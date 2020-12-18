package utils;

import dao.daoEntitys.DAOArchive;
import dao.daoEntitys.DAOFile;
import entitys.Archive;
import entitys.File;
import enums.FileType;


public class EntityConverter {

    public static DAOFile convert(File f, Integer archiveId){
        return new DAOFile(f.getId(),new java.sql.Date(f.getDatetime().getTime()),f.getName(),f.getType(),f.getPlace(), archiveId);
    }

    public static File convert(DAOFile f){
        return new File(f.getId(),f.getDatetime(),f.getName(), FileType.getTypeByStr(f.getType()),new PlaceGenerator().createPlace(f.getPlace().split("_")));
    }

    public static DAOArchive convert(Archive f){
        return new DAOArchive(f.getId(),f.getName());
    }
    public static Archive convert(DAOArchive f){
        return new Archive(f.getId(),f.getName());
    }
}
