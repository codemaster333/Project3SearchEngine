package popCultureReference;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by brannoncenteno on 3/19/15.
 */


public class FileCreator {


   FileCreator() {
      System.out.println("File Creator Initialized");
   }

   ///////////////////////////////////////////////////////////
    /*
    Creates a file in the "File Reference Directory" folder
    Writes the path name of the selected file to the created .txt
    Every time a new file is selected it adds a new path name
     */
   public void FileWriterAwesome(File myFile) throws IOException {
      /*
      Before the path name is written to the .txt file I want
      to check to see if the path name already exists in the .txt.
       */


      StringBuilder sb = new StringBuilder();
      sb.append(myFile.getAbsolutePath());
      File temp = new File("./File Reference Directory/File Reference.txt");
      FileWriter writer = new FileWriter(temp, true);
      writer.write(sb.toString() + "\n");
      writer.flush();
   }
   /////////////////////////////////////////////////////////////

   public void FileObliterator(String name) throws IOException{
      String str;
      BufferedReader in = new BufferedReader(new FileReader("./File Reference Directory/File Reference.txt"));
      ArrayList<String> list = new ArrayList<>();
      while((str = in.readLine()) != null){
         list.add(str);
      }

      list.remove(name);
      StringBuilder sb = new StringBuilder();
      for(String x: list){
         sb.append(x+"\n");
      }

      Path path = Paths.get("./File Reference Directory/File Reference.txt");

      Files.delete(path);
      File temp = new File("./File Reference Directory/File Reference.txt");
      FileWriter writer = new FileWriter(temp, true);
      writer.write(sb.toString());
      writer.flush();
   }


   ////////////////////////////////////////////////////////////////////////
    /*
    Reads the reference text
    Takes the path names line by line in the reference text and puts it into a String array
    Then it takes the path names and converts them into File references and places them into a file array
     */
   public ArrayList<File> ArrayListCreator() throws IOException {

      BufferedReader in = new BufferedReader(new FileReader("./File Reference Directory/File Reference.txt"));
      String str;

      List<String> list = new ArrayList<>();
      ArrayList<File> fileList = new ArrayList<>();
      while ((str = in.readLine()) != null) {
         list.add(str);
      }

      for (String x : list) {

         File file = new File(x);
         fileList.add(file);

      }


      return fileList;
   }
   /////////////////////////////////////////////////////////////////


   public ArrayList<String> FileToString(File file) throws IOException {
      StringBuilder sb = new StringBuilder();
      int iterator = 0;
      ArrayList<String> arrayList = new ArrayList<>();
      BufferedReader in = new BufferedReader(new FileReader(file));
      String line;

      while ((line = in.readLine()) != null) {
         sb.append(wordSeparator(line + " "));
      }


      String string = sb.toString();

      Scanner scanner = new Scanner(string);

      while (scanner.hasNextLine()) {
         arrayList.add(iterator, scanner.nextLine());
         iterator++;
      }


      return arrayList;
   }

   public String changeHashSetIntoText(HashSet<String> hs) {
      StringBuilder sb = new StringBuilder();
      for (String x : hs) {
         sb.append(x + "\n");
      }



      String string = sb.toString();


      return string;

   }



   //This method takes in a string and changes it
   //so that there's only one word per a line
   public String wordSeparator(String str) {
      return str.replace(' ', '\n');
   }

   public ArrayList<String> stringFling(ArrayList<File> fileArrayList) throws IOException {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      ArrayList<String> stringArrayList = new ArrayList<>();
      int iterator = 0;
      for (File x : fileArrayList) {
         stringArrayList.add(iterator, "Name: " + x.getName() + "\nPath: " + x.getAbsolutePath() + "\nLast Modified: " + sdf.format(x.lastModified()));
         iterator++;
      }

      return stringArrayList;
   }
}
