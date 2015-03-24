package popCultureReference;

/* Search Engine created by Group Pop Culture Reference
 *
 * Comprising of Jordan Hart, Brannon Centeno, Kish Moore
 * and Alexis Herrera.
 *
 * This program takes in text files and allows users to 
 * search for terms in said files
 *
 * EDIT: Alexis Herrera - 7:12PM
 * This version is done completely in Swing 
 * and renamed popCultureReference.SearchEngine.java to differentiate it from the Main
 * in the master branch
 *
 *  Brannon
 *  Made some action listeners for the file and help menu
 *  Made it so the radio buttons deselect if you choose a different one
 *  Made it so that when the Maintenance button is pressed, a new window pops up
 *  ...
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
=======
import java.util.*;
>>>>>>> BrannonPart2

interface MainWindow {


	void allSearchTerms();

	void anySearchTerms();

	void exactPhrase();

	void search(String Terms);
}


public class SearchEngine implements MainWindow {


<<<<<<< HEAD
	private JFrame frame;


	/**
	 * Create the application.
	 */
	public SearchEngine() {
		initialize();
	}
=======



	private JFrame frame;

>>>>>>> BrannonPart2

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
=======

		/*
		This code checks if "./File Reference Directory/File Reference.txt" exists
		If it doesn't, it creates it.
		 */
		if(Files.notExists(Paths.get("./File Reference Directory/File Reference.txt"))){
			new File("./File Reference Directory").mkdir();
			File temp = new File("./File Reference Directory/File Reference.txt");
			FileWriter writer = new FileWriter(temp, true);
		}
		HashMap<File, String> hm;
		SearchEngine window = new SearchEngine();
		FileCreator fc = new FileCreator();
		/*
		Makes itTastesLikeKevinBacon equal to the File arraylist created in FileCreator.ArrayListCreator
		The if statement is to handle the initial program startup where our File Reference.txt hasn't been created yet
		 */
		ArrayList<File> itTastesLikeKevinBacon;
		//File f = new File("./File Reference Directory/File Reference.txt");
			itTastesLikeKevinBacon = fc.ArrayListCreator();
		hm = fc.HashMapper(itTastesLikeKevinBacon);


					window.frame.setVisible(true);
	}
>>>>>>> BrannonPart2

		/*
		This code checks if "./File Reference Directory/File Reference.txt" exists
		If it doesn't, it creates it.
		 */
		if (Files.notExists(Paths.get("./File Reference Directory/File Reference.txt"))) {
			new File("./File Reference Directory").mkdir();
			File temp = new File("./File Reference Directory/File Reference.txt");
			FileWriter writer = new FileWriter(temp, true);
		}
		HashMap<File, String> hm;
		SearchEngine window = new SearchEngine();
		FileCreator fc = new FileCreator();
		/*
		Makes itTastesLikeKevinBacon equal to the File arraylist created in FileCreator.ArrayListCreator
		The if statement is to handle the initial program startup where our File Reference.txt hasn't been created yet
		 */
		ArrayList<File> itTastesLikeKevinBacon;
		//File f = new File("./File Reference Directory/File Reference.txt");
		itTastesLikeKevinBacon = fc.ArrayListCreator();
		hm = fc.HashMapper(itTastesLikeKevinBacon);


		window.frame.setVisible(true);
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

		/* Menu Bar
		 *
		 *
		 */


		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		/* File Menu containing Maintenance and Exit Menu Options */

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem maintenanceItem = new JMenuItem("Maintenance");
		//ActionListener to activate Maintenance
		maintenanceItem.addActionListener(new MaintenanceGraphical());
		fileMenu.add(maintenanceItem);


		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new Exit());
		fileMenu.add(exitItem);



		/* Help Menu Bar containing View Help and About Menu Options */

		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);


		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new AboutMenuListener());
		helpMenu.add(aboutItem);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		/* Search Results Panel */


		JPanel resultPanel = new JPanel();
		frame.getContentPane().add(resultPanel);

		JTextArea textArea = new JTextArea("", 18, 70);
		textArea.setEditable(false);
		textArea.setRows(15);
		resultPanel.add(textArea);

		JTextArea resultArea = new JTextArea();
		resultArea.setEditable(false);
		resultPanel.add(resultArea);

		/* Top Bar */

		JPanel searchBarPanel = new JPanel();
		frame.getContentPane().add(searchBarPanel, BorderLayout.NORTH);

		JLabel searchLabel = new JLabel("Search Terms");
		searchBarPanel.add(searchLabel);

		JTextField searchField = new JTextField(" ", 28);
		searchBarPanel.add(searchField);

		JButton searchButton = new JButton("Search");
		searchBarPanel.add(searchButton);

		/* Low Bar */

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
<<<<<<< HEAD

		allSearchTermButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allSearchTerms();
			}
		});

		anySearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anySearchTerms();
			}
		});

		exactPhraseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exactPhrase();
			}
		});

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = "Search string from field when implemented";
				search(search);
			}
		});
=======
		
		allSearchTermButton.addActionListener( new ActionListener()
		{
		 public void actionPerformed (ActionEvent e)
		 {
			 allSearchTerms();
		 }
		 }); 
		
		anySearchButton.addActionListener( new ActionListener()
		{
		 public void actionPerformed (ActionEvent e)
		 {
			 anySearchTerms();
		 }
		 }); 
		
		exactPhraseButton.addActionListener( new ActionListener()
		{
		 public void actionPerformed (ActionEvent e)
		 {
			 exactPhrase();
		 }
		 }); 
		
		searchButton.addActionListener( new ActionListener()
		{
		 public void actionPerformed (ActionEvent e)
		 {
			 String search = "Search string from field when implemented";
			 search(search);
		 }
		 });
>>>>>>> BrannonPart2
	}

	@Override
	public void allSearchTerms() {
		// TODO Auto-generated method stub
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

	//ActionListeners for drop down menu buttons
	class MaintenanceGraphical implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new MaintenanceGUI();
		}
	}

	class Exit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class AboutMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, " Created by Jordan Hart, Brannon Centeno, Kish Moore and Alexis Herrera");
		}
	}

	class ViewHelpMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(null, "Need to create help menu");
		}
	}



}
