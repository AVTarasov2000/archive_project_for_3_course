import com.sun.istack.internal.NotNull;
import entitys.Archive;
import entitys.File;
import interfaces.FunctionalInterfaces.FileChecker;
import logic.ArchiveSorts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        File file1 = new File(new Date(2020, Calendar.FEBRUARY,1), "aa","aa","aa");
        File file2 = new File(new Date(2020, Calendar.MARCH,1), "bb","bb","bb");
        File file3 = new File(new Date(2020, Calendar.APRIL,1), "cc","cc","cc");
        ArrayList<File> arr = new ArrayList <File>();
        arr.add(file1);
        arr.add(file2);
        arr.add(file3);
        Archive archive = new Archive(arr);
        ArrayList<File> res = ArchiveSorts.GetBy(archive,new File(new Date(2020, Calendar.FEBRUARY,1),
                "aa","bb","cc"), (File a, File b) -> {
            return a.getPlace().compareTo(b.getPlace());
        });
        System.out.print(res);
    }
}
