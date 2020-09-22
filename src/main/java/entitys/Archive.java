package entitys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Archive {

    private String name;
    private Map <Integer, File> files;


    public Archive(String name) {
        this.name = name;
        this.files = new HashMap<>();
    }

    public Archive(String name, ArrayList <File> files) {
        this.name = name;
        this.files = new HashMap<>();
        for (File f :
                files) {
            this.files.put(f.getId(), f);
        }
    }

    public Collection<File> getAllFiles() {
        return files.values();
    }

    public void addFile(File file){
        files.put(file.getId(), file);
    }

    public File getFile(int id){
        return files.get(id);
    }

    public String getName() {
        return name;
    }

    public void removeFile(int id){
        files.remove(id);
    }

    public void setName(String name) {
        this.name = name;
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
