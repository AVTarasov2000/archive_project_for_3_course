package entitys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class Archive {

    String name;
//    ArrayList<File> files;
    HashMap<String, File> files;

    public Archive(String name) {
        this.name = name;
        this.files = new HashMap<String, File>();
    }

    public Archive(String name, ArrayList <File> files) {
        this.name = name;
        this.files = new HashMap<String, File>();
        for (File f :
                files) {
            this.files.put(f.name, f);
        }
    }

    public Collection<File> getAllFiles() {
        return files.values();
    }

    public void addFile(File file){
        files.put(file.name, file);
    }

    public File getFile(String name){
        return files.get(name);
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (File f :
                files.values()) {
            sb.append(f.toString()).append("\n");
        }
        return sb.toString();
    }



}
