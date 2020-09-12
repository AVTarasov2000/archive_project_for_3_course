package entitys;

import java.util.ArrayList;

public class Archive {

    ArrayList<File> files;

    public Archive() {
        this.files = new ArrayList <File>();
    }

    public Archive(ArrayList <File> files) {
        this.files = files;
    }

    public ArrayList <File> getFiles() {
        return files;
    }

    public static boolean getByMetaInf(Object key, File file){
        return file.getMetaInf().compareTo((String) key)==0;
    }




}
