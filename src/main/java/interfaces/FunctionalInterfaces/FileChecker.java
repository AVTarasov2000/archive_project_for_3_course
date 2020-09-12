package interfaces.FunctionalInterfaces;


import entitys.File;

@FunctionalInterface
public interface FileChecker{
    boolean checkFile(File key, File file);
}
