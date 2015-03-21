package popCultureReference;

import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

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
        StringBuilder sb = new StringBuilder();
        sb.append(myFile.getAbsolutePath());
        File temp = new File("./File Reference Directory/File Reference.txt");
        FileWriter writer = new FileWriter(temp, true);
        writer.write(sb.toString()+"\n");
        writer.flush();

    }

    public ArrayList<File> ArrayListCreator() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("./File Reference Directory/File Reference.txt"));
        String str;

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<File> fileList = new ArrayList<File>();
        while((str = in.readLine()) !=null){
            list.add(str);

        }

        for(String x: list){
            String poop[] = (String[]) list.toArray();
            int iterate = 0;
            File buttMunch = new File(poop[iterate]);
            fileList.add(iterate, buttMunch);
            iterate++;

        }

        return fileList;
    }

}
