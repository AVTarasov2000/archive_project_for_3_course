package dao;

import entitys.Archive;
import entitys.File;
import entitys.VirtualPlace;
import enums.FileType;
import utils.PlaceFabric;

import java.util.Date;


public class EntityConverter {

    public static DAOFile convert(File f, Integer archiveId){
        return new DAOFile(f.getId(),new java.sql.Date(f.getDatetime().getTime()),f.getName(),f.getType(),f.getPlace(), archiveId);
    }

    public static File convert(DAOFile f){
        return new File(f.getId(),f.getDatetime(),f.getName(), FileType.getTypeByStr(f.getType()),new PlaceFabric().createPlace(f.getPlace().split("_")));
    }

    public static DAOArchive convert(Archive f){
        return new DAOArchive(f.getId(),f.getName());
    }
    public static Archive convert(DAOArchive f){
        return new Archive(f.getId(),f.getName());
    }
}
