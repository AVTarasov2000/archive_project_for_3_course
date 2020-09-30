package utils;

import entitys.File;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FileUtils {

    // TODO: 16/09/2020 брать последнее значение id из бд
    public static AutoIncrement autoIncrement = new AutoIncrement();

    public static File createFile(String[] parameters){
        return new File(autoIncrement.increment(), new GregorianCalendar(), parameters[0],parameters[1],parameters[2]);
    }

    public static File createFile(Calendar date, String name, String type, String place){
        if (date==null)
            date = new GregorianCalendar();
        return new File(autoIncrement.increment(), date,name, type, place);
    }

    public static File createFile(String name, String type, String place){
        return new File(autoIncrement.increment(), new GregorianCalendar(),name, type, place);
    }


}
