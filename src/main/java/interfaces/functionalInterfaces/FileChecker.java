package interfaces.functionalInterfaces;


import entitys.File;

@FunctionalInterface
public interface FileChecker{
    boolean checkFile(Object key, File file);
}
