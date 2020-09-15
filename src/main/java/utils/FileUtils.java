package utils;

import entitys.File;

import java.util.Date;

public class FileUtils {

    public static File createFile(String[] parameters){
        return new File(new Date(), parameters[0],parameters[1],parameters[2]);
    }

}
