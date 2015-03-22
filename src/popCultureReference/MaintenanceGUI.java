package popCultureReference;
import com.sun.scenario.animation.shared.FiniteClipEnvelope;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

import javax.swing.table.DefaultTableModel;




interface MaintanceInterface {

	  
    void addFile();

    void rebuildData();

    void removeFile();

}

public class MaintenanceGUI implements MaintanceInterface {

	private JFrame frame;
	private ArrayList<File> readContent = new ArrayList<File>();
	private int index = 0;
	private JList list;
	private static String [] namer;
	JTable jt;

	MaintenanceGUI(){
		System.out.println("Maintenance Initialized");
		try {initialize();} catch (IOException e) {e.printStackTrace();}
	}




	private void initialize() throws IOException {
		//table data initialization
		frame = new JFrame();
		frame.setTitle("Maintenance");
		frame.setBounds(100, 100, 600, 400);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());


/*
		FileCreator fc1 = new FileCreator();
		ArrayList<File> data = fc1.ArrayListCreator();

		int iterator = 0;

		for(File x: data){
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			File file = data.get(iterator);
			this.namer[iterator] = file.getName() + " " + file.getAbsolutePath()+ " " + sdf.format(file.lastModified());
			iterator++;
		}
		*/


			//South Buttons
		JPanel bottom = new JPanel();
			JButton addFileButton = new JButton("Add File");
			JButton deleteFileButton = new JButton("Delete File");
			JButton rebuildFileButton = new JButton("Rebuild File");
			bottom.add(addFileButton);
			bottom.add(deleteFileButton);
			bottom.add(rebuildFileButton);
			frame.add(bottom, BorderLayout.SOUTH);

		//South Button ActionListeners
		addFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addFile();
			}
		});

		deleteFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		rebuildFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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
	public void addFile(){
		/*

		 */
		FileCreator fc = new FileCreator();
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files Only", "txt");
		chooser.setFileFilter(filter);
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){

			File chosenFile = chooser.getSelectedFile();
			try {fc.FileWriterAwesome(chosenFile);} catch (IOException e) {e.printStackTrace();}
		}
   }

   @Override
   public void rebuildData() {
      // TODO Auto-generated method stub

   }
   @Override
   public void removeFile() {
      // TODO Auto-generated method stub

   }

	public void myJTable(){



	}






}
