package popCultureReference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;

/**
 * Created by brannoncenteno on 3/19/15.
 */
public class FileCreator {

    FileCreator(){

        System.out.println("File Creator Initialized");

    }

    /*
    Creates a file in the "File Reference Directory" folder
    In the newly created file, the 1st line has the referenced file's name and the 2nd line its absolute path. 3rd line last mod time
     */
    public void FileWriterAwesome(File myFile) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        StringBuilder sb = new StringBuilder();
        sb.append(myFile.getName()+"\n"+myFile.getAbsolutePath()+"\n"+sdf.format(myFile.lastModified()));
        File temp = new File("./File Reference Directory/"+myFile.getName()+" Reference");
        FileWriter writer = new FileWriter(temp, true);
        writer.write(sb.toString());
        writer.flush();




    }

}
