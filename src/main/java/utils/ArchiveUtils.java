package utils;

import entitys.Archive;
import entitys.File;
import interfaces.functionalInterfaces.FileChecker;

import java.util.ArrayList;
import java.util.Date;

public class ArchiveUtils {


    public static boolean getByName(Object key, File file){
        return file.getName().compareTo((String) key)==0;
    }

    public static boolean getByType(Object key, File file){
        return file.getType().compareTo((String) key)==0;
    }

    public static boolean getByDate(Object key, File file){
        return file.getDatetime().compareTo((Date) key)==0;
    }

    public static boolean getByDateYear(Object key, File file){
        return ((Date) key).getYear() == file.getDatetime().getYear();
    }

    public static boolean getByDateMonth(Object key, File file){
        return ((Date) key).getYear() == file.getDatetime().getYear()
                && ((Date) key).getMonth() == file.getDatetime().getMonth();
    }

    public static boolean getByDateDay(Object key, File file){
        return ((Date) key).getYear() == file.getDatetime().getYear()
                && ((Date) key).getMonth() == file.getDatetime().getMonth()
                && ((Date) key).getDay() == file.getDatetime().getDay();
    }



    public static ArrayList<File> GetBy(Archive archive, Object key, FileChecker check){
        ArrayList<File> result = new ArrayList <>();
        for (File f :
                archive.getAllFiles()) {
            if (check.checkFile(key, f)) {
                result.add(f);
            }
        }
        return result;
    }

}
