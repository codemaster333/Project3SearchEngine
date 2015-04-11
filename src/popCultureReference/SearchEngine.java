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


   void allSearchTerms();

   void anySearchTerms();

   void exactPhrase();

   void search(String Terms);
}


public class SearchEngine implements MainWindow {

   private JFrame frame;
   private int selection;


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
      //Preferences arent working yet
      Preferences userPreferences = Preferences.userRoot();

      frame = new JFrame();
      frame.setTitle("Search Engine");
      frame.setBounds(userPreferences.getInt("x", 100), userPreferences.getInt("y", 100), 600, 400);
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
         System.out.println(terms);

         switch (selection) {
            case 1:
               anySearchTerms();
               System.out.println("We did it 1");

               break;
            case 2:
               allSearchTerms();
               System.out.println("We did it 2");
               break;
            case 3:
               exactPhrase();
               System.out.println("We did it 3");
               break;

            default:
               selection = 0;
         }
      });



      /////////////////Center JText Area//////////////////////////////////////
      JPanel resultPanel = new JPanel();
      frame.getContentPane().add(resultPanel);

      JTextArea textArea = new JTextArea(15, 49);
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
   public void allSearchTerms() {

   }

   @Override
   public void anySearchTerms() {
      // TODO Auto-generated method stub
   }

   @Override
   public void exactPhrase() {
      // TODO Auto-generated method stub
   }

   @Override
   public void search(String Terms) {
      // TODO Auto-generated method stub

   }

   public boolean ArraySearcher() throws IOException {

      FileCreator fc = new FileCreator();
      StringBuilder sb = new StringBuilder();
      ArrayList<File> arrayList = new ArrayList<>();
      arrayList = fc.ArrayListCreator();


      for (File file : arrayList) {

         BufferedReader br = new BufferedReader(new FileReader(file));

         for (String line; (line = br.readLine()) != null; ) {
            sb.append(line + "\n");
         }

         System.out.println(sb);
         System.out.println("////////////////////////////////////////////////////");

         String string = sb.toString();
         string = fc.wordSeparator(string);

         ArrayList<String> str = new ArrayList<>();


      }


      return true;
   }


}
