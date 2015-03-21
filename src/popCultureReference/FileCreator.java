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
    Writes the path name of the selected file to the created .txt
    Every time a new file is selected it adds a new path name
     */
    public void FileWriterAwesome(File myFile) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(myFile.getAbsolutePath());
        File temp = new File("./File Reference Directory/File Reference.txt");
        FileWriter writer = new FileWriter(temp, true);
        writer.write(sb.toString()+"\n");
        writer.flush();

    }

    /*
    Reads the reference text
    Takes the path names line by line in the reference text and puts it into a String array
    Then it takes the path names and converts them into File references and places them into a file array
     */
    public ArrayList<File> ArrayListCreator() throws IOException, FileNotFoundException {

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
