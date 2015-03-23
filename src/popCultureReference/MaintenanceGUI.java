package popCultureReference;
import com.sun.scenario.animation.shared.FiniteClipEnvelope;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder;
import sun.java2d.pipe.SpanShapeRenderer;

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


			//South Buttons
		JPanel bottom = new JPanel();
			JButton addFileButton = new JButton("Add File");
			JButton deleteFileButton = new JButton("Delete File");
			JButton rebuildFileButton = new JButton("Rebuild File");
			bottom.add(addFileButton);
			bottom.add(deleteFileButton);
			bottom.add(rebuildFileButton);
			frame.add(bottom, BorderLayout.SOUTH);

		//JList
		final DefaultListModel model = new DefaultListModel();

		JPanel top = new JPanel();
		//JList list = new JList(readContent.toArray());
		JList list = new JList(model);
		FileCreator fc = new FileCreator();
		int iterator = 0;
		File[] file = new File[fc.ArrayListCreator().size()];
		file = fc.ArrayListCreator().toArray(file);
		for(File x: file) {


			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			model.addElement("Name: " + x.getName() +"\n Path: "+x.getAbsolutePath()+"\n Last Modified: "+ sdf.format(x.lastModified()));
			 iterator++;//This is how you add stuff to JList. Remove is
			//model.removeElementAt(model.getSize() - 1);

		}
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension (600,350));
		top.add(listScroller);

		class MutableList extends JList{
			MutableList(){
				super(new DefaultListModel());
			}
			DefaultListModel getContents(){
				return (DefaultListModel)getModel();
			}
		}


		frame.add(top, BorderLayout.CENTER);


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
