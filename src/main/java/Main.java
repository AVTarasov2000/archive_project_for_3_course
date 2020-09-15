import entitys.Archive;
import entitys.File;
import utils.ArchiveUtils;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static boolean getByMetaInf(Object key, File file){
        return file.getName().compareTo((String) key)==0;
    }

    public static void main(String[] args){
        File file1 = new File(new Date(2020, Calendar.FEBRUARY,1), "aa","aa","aa");
        File file2 = new File(new Date(2020, Calendar.MARCH,1), "bb","bb","bb");
        File file3 = new File(new Date(2020, Calendar.APRIL,1), "cc","cc","cc");
        ArrayList<File> arr = new ArrayList <File>();
        arr.add(file1);
        arr.add(file2);
        arr.add(file3);
        Archive archive = new Archive("abdyabdya", arr);
        ArrayList<File> res = ArchiveUtils.GetBy(archive,"bb", ArchiveUtils::getByName);
        System.out.println(res);
        System.out.println(archive);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(FileUtils.createFile(str.split(" ")));
    }
}
