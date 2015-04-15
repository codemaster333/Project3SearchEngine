package popCultureReference;

/* Search Engine created by Group Pop Culture Reference
 *
 * Comprising of Jordan Hart, Brannon Centeno, Kish Moore
 * and Alexis Herrera.
*/


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.*;
import java.util.prefs.Preferences;


interface MainWindow {


   void allSearchTerms(String terms);

   void anySearchTerms(String terms);

   void exactPhrase(String terms);

   void search(String Terms);
}


public class SearchEngine implements MainWindow {

   private JFrame frame;
   private int selection;
   FileCreator fc = new FileCreator();
   JTextArea textArea;
   GetsAndSets getsAndSets = new GetsAndSets();


   /**
    * Launch the application.
    */
   public static void main(String[] args) throws IOException {


      if (Files.notExists(Paths.get("./File Reference Directory/File Reference.txt"))) {
         new File("./File Reference Directory").mkdir();
         File temp = new File("./File Reference Directory/File Reference.txt");
         FileWriter writer = new FileWriter(temp, true);
      }


      SearchEngine window = new SearchEngine();
      window.frame.setVisible(true);
   }


   class ViewHelpMenuListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {

         JOptionPane.showMessageDialog(null, "Need to create help menu");
      }
   }


   /**
    * Create the application.
    */
   public SearchEngine() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {


      frame = new JFrame();
      frame.setTitle("Search Engine");
      frame.setBounds(100, 100, 600, 400);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);

      ///////////////////////////The File & Help menus//////////////////////////////////////////////
      JMenu fileMenu = new JMenu("File");
      menuBar.add(fileMenu);

      JMenuItem maintenanceItem = new JMenuItem("Maintenance");
      fileMenu.add(maintenanceItem);
      maintenanceItem.addActionListener(e -> new MaintenanceGUI());

      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(e -> System.exit(0));
      fileMenu.add(exitItem);


      JMenu helpMenu = new JMenu("Help");
      menuBar.add(helpMenu);

      JMenuItem aboutItem = new JMenuItem("About");
      aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(null, " Created by Jordan Hart, Brannon Centeno, Kish Moore and Alexis Herrera"));
      helpMenu.add(aboutItem);

      frame.getContentPane().setLayout(new BorderLayout(0, 0));
      ///////////////////////////////////////////////////////////////////////////////

		/* Top Bar */

      JPanel searchBarPanel = new JPanel();
      frame.getContentPane().add(searchBarPanel, BorderLayout.NORTH);

      JLabel searchLabel = new JLabel("Search Terms");
      searchBarPanel.add(searchLabel);

      JTextField searchField = new JTextField(" ", 28);
      searchBarPanel.add(searchField);

      JButton searchButton = new JButton("Search");
      searchBarPanel.add(searchButton);
      searchButton.addActionListener(e -> {
         String terms = Normalizer.normalize(searchField.getText(), Normalizer.Form.NFKC);


         switch (selection) {
            case 1:
               allSearchTerms(terms);
               //textArea.setText(getsAndSets.getTextAreaDisplayer());
               break;

            case 2:
               anySearchTerms(terms);
               textArea.setText(getsAndSets.getTextAreaDisplayer());
               break;

            case 3:
               exactPhrase(terms);
               textArea.setText("null");
               break;

            default:
               selection = 0;

         }
      });


      /////////////////Center JText Area//////////////////////////////////////
      JPanel resultPanel = new JPanel();
      frame.getContentPane().add(resultPanel);

      textArea = new JTextArea(15, 49);
      textArea.setEditable(false);

      resultPanel.add(textArea);

      JTextArea resultArea = new JTextArea();
      resultArea.setEditable(false);
      resultPanel.add(resultArea);
      //textArea.setText();
      /////////////////////////////////////////////////////////////////////////


      //////////////Radio Button Stuff (South)////////////////////////////////////////////////////////////////////////////////////////////////

      JPanel searchTypePanel = new JPanel();


      JLabel searchTypeLabel = new JLabel("Search Type:");
      searchTypePanel.add(searchTypeLabel);

      JRadioButton allSearchTermButton = new JRadioButton();
      allSearchTermButton.setText("All Search Terms");

      JRadioButton anySearchButton = new JRadioButton();
      anySearchButton.setText("Any Search Terms");

      JRadioButton exactPhraseButton = new JRadioButton();
      exactPhraseButton.setText("Exact Phrase");
      searchTypePanel.add(exactPhraseButton);

      ButtonGroup group = new ButtonGroup();
      group.add(allSearchTermButton);
      group.add(anySearchButton);
      group.add(exactPhraseButton);
      searchTypePanel.add(allSearchTermButton);
      searchTypePanel.add(anySearchButton);
      searchTypePanel.add(exactPhraseButton);

      frame.getContentPane().add(searchTypePanel, BorderLayout.SOUTH);

      allSearchTermButton.addActionListener(e -> {
         selection = 1;
         System.out.println("All Search Activated");
      });

      anySearchButton.addActionListener(e -> {
         selection = 2;
         System.out.println("Any Search Activated");

      });


      exactPhraseButton.addActionListener(e -> {
         selection = 3;
         System.out.println("Exact Phrase Search Activated");
      });

      //////////////////////////////////////////////////////////////////////////////////////////////////////////////


   }

   @Override
   public void allSearchTerms(String terms) {
      terms = fc.wordSeparator(terms);
      HashSet<String> isInFile = new HashSet<>();
      ArrayList<String> enteredSearchTerms = new ArrayList<>();
      Scanner scanner = new Scanner(terms);
      while (scanner.hasNextLine()) {
         enteredSearchTerms.add(scanner.nextLine());

      }

      System.out.println(enteredSearchTerms);

      for (String x : enteredSearchTerms) {


         try {
            for (File y : fc.ArrayListCreator()) {

               ArrayList<String> termsInFile = fc.FileToString(y);

               if (termsInFile.contains(x) == true) {
                  isInFile.add(y.getName());
               }

            }



         } catch (IOException e) {
            e.printStackTrace();
         }

      }

      System.out.println("orsearch:"+ isInFile);

      for (String x : enteredSearchTerms) {

         StringBuilder sb = new StringBuilder();
         try {
            for (File y : fc.ArrayListCreator()) {
               ArrayList<String> termsInFile = fc.FileToString(y);

               for (String string : termsInFile) {
                  sb.append(string + "\n");
               }

            }


            ArrayList<String> al = new ArrayList<>();
            String s = sb.toString();
            int it = 0;


            Scanner sc = new Scanner(s);

            while (sc.hasNextLine()) {
               al.add(it, sc.nextLine());
               it++;
            }

            System.out.println("Contents of ArrayList:" + al);

            for (File y : fc.ArrayListCreator()) {

               ArrayList<String> ese = fc.FileToString(y);

               if (ese.contains(x) == false) {
                  isInFile.remove(y.getName());
               }

            }

         } catch (Exception e) {System.out.println("Exception");}


      }

      System.out.println("And:" + isInFile);



   }

   @Override
   public void anySearchTerms(String terms) {
      terms = fc.wordSeparator(terms);
      HashSet<String> isInFile = new HashSet<>();
      ArrayList<String> enteredSearchTerms = new ArrayList<>();
      Scanner scanner = new Scanner(terms);
      while (scanner.hasNextLine()) {
         enteredSearchTerms.add(scanner.nextLine());

      }

      for (String x : enteredSearchTerms) {


         try {
            for (File y : fc.ArrayListCreator()) {

               ArrayList<String> termsInFile = fc.FileToString(y);

               if (termsInFile.contains(x) == true) {
                  isInFile.add(y.getName());
               }

            }

         } catch (IOException e) {
            e.printStackTrace();
         }

      }
      getsAndSets.setContainsTheWord(isInFile);
      getsAndSets.setTextAreaDisplayer(fc.changeHashSetIntoText(getsAndSets.getContainsTheWord()));

   }

   @Override
   public void exactPhrase(String terms) {
      // TODO Auto-generated method stub


   }

   @Override
   public void search(String Terms) {
      // TODO Auto-generated method stub

   }


}
