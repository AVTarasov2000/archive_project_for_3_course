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
}
