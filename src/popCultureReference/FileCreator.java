package popCultureReference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by brannoncenteno on 3/19/15.
 */
public class FileCreator {

    FileCreator(){

        System.out.println("File Creator Initialized");

    }

    public void FileWriterAwesome(File myFile) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(myFile.getName()+"\n"+myFile.getAbsolutePath());
        File temp = new File("./File Reference Directory/"+myFile.getName()+" Reference");
        FileWriter writer = new FileWriter(temp, true);
        writer.write(sb.toString());
        writer.flush();




    }

}
