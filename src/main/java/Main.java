import command.input.AddFileCommand;
import command.input.GetByDateDay;
import command.input.GetByNameCommand;
import controller.ArchiveController;
import controller.OutputController;
import entitys.Archive;
import entitys.File;
import utils.ArchiveUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        File file1 = new File(1, new Date(2020, Calendar.FEBRUARY,1), "aa","aa","aa");
        File file2 = new File(2, new Date(2020, Calendar.MARCH,1), "bb","bb","bb");
        File file3 = new File(3, new Date(2020, Calendar.APRIL,1), "vv","vv","vv");
        File file4 = new File(4, new Date(2020, Calendar.APRIL,1), "vv","vv","cb");
        ArrayList<File> arr = new ArrayList <File>();
        arr.add(file1);
        arr.add(file2);
        arr.add(file3);
        Archive archive = new Archive("abdyabdya", arr);
        ArrayList<File> res = ArchiveUtils.GetBy(archive,"bb", ArchiveUtils::getByName);
        System.out.println(res);
        System.out.println(archive);


        OutputController outputController = new OutputController();
        Object[] arg = {"vv",file4};
        ArchiveController archiveController = new ArchiveController(archive);
        AddFileCommand addFileCommand = new AddFileCommand(archiveController,outputController, (File) arg[1]);
        addFileCommand.execute();
        System.out.println(archive);
        GetByNameCommand getByDateDay = new GetByNameCommand(archiveController, outputController, (String) arg[0]);

        getByDateDay.execute();


    }
}
