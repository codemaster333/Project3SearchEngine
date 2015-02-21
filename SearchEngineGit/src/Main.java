/* Search Engine created by Group Pop Culture Reference
 *
 * Comprising of Jordan Hart, Brannon Centeno, Kish Moore
 * and Alexis Herrera.
 *
 * This program takes in text files and allows users to 
 * search for terms in said files
 *
 */


package popculture;

import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Button;
import java.awt.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Checkbox;

public class SearchEngine {

	private JFrame searchGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEngine window = new SearchEngine();
					window.searchGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		searchGUI = new JFrame();
		searchGUI.setTitle("Search Engine");
		searchGUI.setBounds(100, 100, 600, 400);
		searchGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchGUI.getContentPane().setLayout(new BorderLayout(0, 0));
		
		/* Menu Bar
		 * 
		 * 
		 */
		
		
		JMenuBar menuBar = new JMenuBar();
		searchGUI.setJMenuBar(menuBar);
		
		/* File Menu containing Maintenance and Exit Menu Options */
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem maintenanceItem = new JMenuItem("Maintenance");
		fileMenu.add(maintenanceItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		/* Help Menu Bar containing View Help and About Menu Options */
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem viewHelpItem = new JMenuItem("View Help");
		helpMenu.add(viewHelpItem);
		
		JMenuItem aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		
		/*
		 * 
		 */
		
		/* Search Results Panel */
		
		Panel resultPanel = new Panel();
		searchGUI.getContentPane().add(resultPanel);
		
			TextArea resultArea = new TextArea("",18, 90, TextArea.SCROLLBARS_NONE);
			resultArea.setForeground(Color.WHITE);
			resultArea.setEditable(false);
			resultPanel.add(resultArea);
		
		/* Top Bar */
		
		JPanel searchBarPanel = new JPanel();
		searchGUI.getContentPane().add(searchBarPanel, BorderLayout.NORTH);
		
			Label searchLabel = new Label("Search Terms");
			searchBarPanel.add(searchLabel);
		
			TextField searchField = new TextField(" ", 28);
			searchBarPanel.add(searchField);
		
			Button searchButton = new Button("Search");
			searchBarPanel.add(searchButton);
		
		/* Low Bar */
		
		JPanel searchTypePanel = new JPanel();
		searchGUI.getContentPane().add(searchTypePanel, BorderLayout.SOUTH);
		
			Label searchType = new Label("Search Type:");
			searchType.setAlignment(Label.CENTER);
			searchTypePanel.add(searchType);
		
			//AWT does not allow for radio buttons so checkboxes are used
			CheckboxGroup choices = new CheckboxGroup();
			Checkbox searchTerms = new Checkbox("Search Terms", choices, false);
			Checkbox anySearch = new Checkbox("Any Search Terms", choices, false);
			Checkbox exactPhrase = new Checkbox("Exact Phrase", choices, false);
		
			searchTypePanel.add(searchType);
			searchTypePanel.add(searchTerms);
			searchTypePanel.add(anySearch);
			searchTypePanel.add(exactPhrase);

	}

}
