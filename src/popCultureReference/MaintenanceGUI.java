package popCultureReference;


import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

interface MaintanceInterface {


   void addFile();

   void rebuildData();

   void removeFile();

}

public class MaintenanceGUI implements MaintanceInterface {


   private FileCreator fc = new FileCreator();
   private JFrame frame;
   private JTable table;
   private String[][] data;
   private BorderLayout borderLayout = new BorderLayout();
   private DefaultTableModel defaultTableModel = new DefaultTableModel();
   private GetsAndSets getsAndSets = new GetsAndSets();
   private ListSelectionModel listSelectionModel;
   private String[] columnName = {"Path Name", "Last Modified"};


   MaintenanceGUI() {
      System.out.println("Maintenance Initialized");
      try {
         initialize();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void initialize() throws IOException {
      // table data initialization
      frame = new JFrame();
      frame.setTitle("Maintenance");
      frame.setBounds(100, 100, 600, 400);
      frame.setResizable(false);
      // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setLayout(borderLayout);

      // South Buttons
      JPanel bottom = new JPanel();
      JButton addFileButton = new JButton("Add File");
      JButton deleteFileButton = new JButton("Delete File");
      JButton rebuildFileButton = new JButton("Rebuild File");
      bottom.add(addFileButton);
      bottom.add(deleteFileButton);
      bottom.add(rebuildFileButton);
      frame.add(bottom, borderLayout.SOUTH);
      // South Button ActionListeners

      JTable();


      //South Button ActionListeners
      addFileButton.addActionListener(e -> addFile());


      deleteFileButton.addActionListener(e -> removeFile());


      rebuildFileButton.addActionListener(e -> rebuildData());

   }

   public void JTable() {
      JPanel top = new JPanel();
      try {
         data = updateData();
      } catch (IOException e) {
         e.printStackTrace();
      }
      table = new JTable(data, columnName);
      JScrollPane scrollPane = new JScrollPane(table);
      defaultTableModel.fireTableDataChanged();
      Dimension dimension = new Dimension(599, 399);
      scrollPane.setPreferredSize(dimension);
      top.add(scrollPane);
      frame.add(top, borderLayout.CENTER);

      listSelectionModel = table.getSelectionModel();
      listSelectionModel.addListSelectionListener(e -> {
         if (e.getValueIsAdjusting()) {
            getsAndSets.setSelection(listSelectionModel.getLeadSelectionIndex());

         }
      });

   }


   /*
   Is called when the "Add File" button is clicked
   A new instance of FileCreator is created
   A file chooser that only allows for the selection of .txt files is brought up
   The selected file is then passed into the method "FileWriterAwesome" which is located in the FileCreator class

   What FileWriterAwesome does:
   Creates a file in the "File Reference Directory" folder
    Writes the path name of the selected file to the created .txt
    Every time a new file is selected it adds a new path name

    */
   @Override
   public void addFile() {


      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files Only", "txt");
      chooser.setFileFilter(filter);
      if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
         File chosenFile = chooser.getSelectedFile();
         StringBuilder sb = new StringBuilder(chosenFile.getName());


         if (!sb.subSequence(sb.length() - 4, sb.length()).equals(".txt")) {
            JOptionPane.showMessageDialog(null, "Only text files with the extension '.txt' can be selected.\nClose this dialog box and try again");

         } else {

            try {
               if (fc.ArrayListCreator().contains(chosenFile)) {
                  JOptionPane.showMessageDialog(null, "That file has already been indexed");

               } else {

                  fc.FileWriterAwesome(chosenFile);
                  frame.dispose();
                  initialize();


               }
            } catch (IOException e) {
               e.printStackTrace();
            }

         }
      }
   }

   /* Rebuilds/Refreshes the files in the maintenance menu, based on whether
    * or not there have been changes to the files */
   @Override
   public void rebuildData() {

      try {
         if (!fc.ArrayListCreator().isEmpty()) {

            String str;
            BufferedReader in = new BufferedReader(new FileReader("./File Reference Directory/File Reference.txt"));
            ArrayList<String> list = new ArrayList<>();
            while ((str = in.readLine()) != null) {
               list.add(str);
            }

            for (File x : fc.ArrayListCreator()) {
               if (!x.exists()) {
                  list.remove(x.getPath());
                  list.trimToSize();
               }
            }





            StringBuilder sb = new StringBuilder();
            for (String x : list) {
               sb.append(x + "\n");
            }



            Path path = Paths.get("./File Reference Directory/File Reference.txt");
            Files.delete(path);

            File temp = new File("./File Reference Directory/File Reference.txt");
            FileWriter writer = new FileWriter(temp, true);
            writer.write(sb.toString());
            writer.flush();

            frame.dispose();
            initialize();
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /* Removes selected files from the Maintenance menu*/

   public void removeFile() {
      try {
         if (!fc.ArrayListCreator().isEmpty()){

            System.out.println(getsAndSets.getSelection());

            String selectedPath = updateData()[getsAndSets.getSelection()][0];
            getsAndSets.setSelection(-1);
            fc.FileObliterator(selectedPath);
            frame.dispose();
            initialize();


         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String[][] updateData() throws IOException {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      int iterator = 0;


      String[][] data = new String[fc.ArrayListCreator().size()][2];
      if (fc.ArrayListCreator().isEmpty()) {
      } else {
         for (File x : fc.ArrayListCreator()) {
            data[iterator][0] = x.getPath();
            data[iterator][1] = sdf.format(x.lastModified());
            iterator++;
         }
      }

      return data;
   }
}
