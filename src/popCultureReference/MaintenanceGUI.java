package popCultureReference;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;






interface MaintanceInterface {

	  
    void addFile();

    void rebuildData();

    void removeFile();

}

public class MaintenanceGUI implements MaintanceInterface {

	private JFrame frame;


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

		//JList
		final DefaultListModel model = new DefaultListModel();
		JPanel top = new JPanel();
		JList list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		FileCreator fc = new FileCreator();
		int iterator = 0;
		File[] file = new File[fc.ArrayListCreator().size()];
		file = fc.ArrayListCreator().toArray(file);

		for(File x: file) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			model.addElement("Name: " + x.getName() +"\n Path: "+x.getAbsolutePath()+"\n Last Modified: "+ sdf.format(x.lastModified()));
			iterator++;
		}

		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension (600,350));
		top.add(listScroller);

		frame.add(top, BorderLayout.CENTER);

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



}
