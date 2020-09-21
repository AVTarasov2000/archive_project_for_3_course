package utils;

import entitys.File;

import java.util.Date;

public class FileUtils {

    // TODO: 16/09/2020 брать последнее значение id из бд
    public static AutoIncrement autoIncrement = new AutoIncrement();

    public static File createFile(String[] parameters){
        return new File(autoIncrement.increment(), new Date(), parameters[0],parameters[1],parameters[2]);
    }

    public static File createFile(Date date, String name, String type, String place){
        if (date==null)
            date = new Date();
        return new File(autoIncrement.increment(), date,name, type, place);
    }

    public static File createFile(String name, String type, String place){
        return new File(autoIncrement.increment(), new Date(),name, type, place);
    }


}
