package popCultureReference;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
	private JList list;
	private ArrayList<File> readContent = new ArrayList<File>();
	private int index = 0;

	MaintenanceGUI(){
		System.out.println("Maintenance Initialized");

		initialize();
	}




	private void initialize(){
		//table data initialization
		frame = new JFrame();
		frame.setTitle("Maintenance");
		frame.setBounds(100, 100, 600, 400);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		JPanel center = new JPanel();
		/*list = new JList();
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));

		list.addListSelectionListener(

				new ListSelectionListener(){

					public void valueChanged(ListSelectionEvent e) {

						getContentPane().setBackground(colors[list.getSelectedIndex()]);

					}


				}

		);*/







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
	
	@Override
	public void addFile(){

		FileCreator fc = new FileCreator();
		JFileChooser chooser = new JFileChooser();
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){

			File chosenFile = chooser.getSelectedFile();
			try {
				fc.FileWriterAwesome(chosenFile);
			} catch (IOException e) {
				e.printStackTrace();
			}


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




}
