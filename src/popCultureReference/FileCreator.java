package popCultureReference;

import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
    public ArrayList<File> ArrayListCreator() throws IOException{

        BufferedReader in = new BufferedReader(new FileReader("./File Reference Directory/File Reference.txt"));
        String str;

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<File> fileList = new ArrayList<File>();
        while((str = in.readLine()) !=null){
            list.add(str);
        }

        for(String x: list){
            int iterate = 0;
            File buttMunch = new File(x);
            fileList.add(iterate, buttMunch);
            iterate++;
        }

        return fileList;
    }

    /*
    This methods takes in an arraylist of type File.
    It then creates a HashMap whose key is of type String and value of type String
    An enhanced for-loop is used to  iterate through the ArrayList<File> fileArrayList
    Each index of fileArrayList is stored in File x, read into BufferedReader reader,
    and then appended to StringBuilder sb.

    Finally, the File name (x.getName();) is stored as the HashMap HashMapper's
    key and its value as the strings stored in StringBuilder sb stored with one word per a line

     Method wordSeparator used in wordSeparator(sb.toString()); returns a string that has only one
     word per a line

     hm.put inserts the key and value at that key into our HashMap

     */
    public HashMap HashMapper(ArrayList<File> fileArrayList) throws IOException {
        HashMap<String, String> hm = new HashMap<>();

        for (File x : fileArrayList) {
            BufferedReader reader = new BufferedReader( new FileReader (x));
            String         line = null;
            StringBuilder  sb = new StringBuilder();
            String         ls = System.getProperty("line.separator");

            while( ( line = reader.readLine() ) != null ) {
                sb.append( line );
                sb.append( ls );
            }

            hm.put(x.getName(), wordSeparator(sb.toString()));

        }

        return hm;
    }

    //This method takes in a string and changes it
    //so that there's only one word per a line
        public String wordSeparator(String str){
            String oneWordPerLine = str.replace(' ', '\n');
            return oneWordPerLine;
        }



    }


