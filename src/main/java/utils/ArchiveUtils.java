package utils;

import entitys.Archive;
import entitys.File;
import interfaces.functionalInterfaces.FileChecker;

import java.util.ArrayList;
import java.util.Date;

public class ArchiveUtils {


    public static boolean getByName(Object key, File file, Integer compareValue){
        return file.getName().compareTo((String) key)==compareValue;
    }

    public static boolean getByType(Object key, File file, Integer compareValue){
        return file.getType().compareTo((String) key)==compareValue;
    }

    public static boolean getByDate(Object key, File file, Integer compareValue){
        return file.getDatetime().compareTo((Date) key)==compareValue;
    }

    public static boolean getByDateYear(Object key, File file, Integer compareValue){
        return ((Date) key).getYear() == file.getDatetime().getYear();
    }

    public static boolean getByDateMonth(Object key, File file, Integer compareValue){
        return ((Date) key).getYear() == file.getDatetime().getYear()
                && ((Date) key).getMonth() == file.getDatetime().getMonth();
    }

    public static boolean getByDateDay(Object key, File file, Integer compareValue){
        return ((Date) key).getYear() == file.getDatetime().getYear()
                && ((Date) key).getMonth() == file.getDatetime().getMonth()
                && ((Date) key).getDay() == file.getDatetime().getDay();
    }

    public static ArrayList<File> getBy(Archive archive, Object key, FileChecker[] checker, Integer[] compareValues){
        ArrayList<File> result = new ArrayList <>();
        if(checker.length!=compareValues.length) try {
            throw new Exception("different length of compareValues and check Functions");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (File f :
                archive.getAllFiles()) {
            boolean check = true;
            for (int i = 0; i < checker.length; i++) {
                check = checker[i].checkFile(key, f, compareValues[i]);
                if (!check) break;
            }
            if (check) {
                result.add(f);
            }
        }
        return result;
    }

}
