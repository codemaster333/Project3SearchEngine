package popCultureReference;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

interface MaintanceInterface {
	void addFile(DefaultTableModel foo);

	void rebuildData();

	void removeFile();
	
	String readFile();
	
	void writeFile(String name, String path); 
	
}

public class MaintenanceGUI extends AbstractTableModel implements MaintanceInterface {
	private JFrame frame;

	/*
	 * Put the GUI components of the maintenance window here. We could probably
	 * put this in SearchEngine.java, but I thought it'd be nicer to add all the
	 * components without seeing all that code.
	 */
	MaintenanceGUI() {
		initialize();
	}

	/* Action Listeners */
	class AboutMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane
					.showMessageDialog(null,
							" Created by Jordan Hart, Brannon Centeno, Kish Moore and Alexis Herrera");
		}
	}

	class ViewHelpMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Need to create help menu");
		}
	}

	private void initialize() {
		// table data initialization
		String[] columnNames = { "1", "2" };
		Object[][] data = { { "File Name", "Status" } };
		// actual window code
		frame = new JFrame();
		frame.setTitle("Maintenance");
		frame.setBounds(100, 100, 600, 400);
		// frame.setResizable(false);
		JMenuBar maintBar = new JMenuBar();
		frame.setJMenuBar(maintBar);
		JMenu maintFile = new JMenu("File");
		maintBar.add(maintFile);
		JMenuItem maintExit = new JMenuItem("Exit");
		maintExit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.hide();
			}
		});
		maintFile.add(maintExit);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Operations for file handling
		frame.setLayout(new BorderLayout());
		JPanel top = new JPanel();
		// add panel to north of layout
		frame.add(top, BorderLayout.NORTH);
		JLabel searchMaintence = new JLabel("Search Engine- Index");
		top.add(searchMaintence);
		top.setLayout(new FlowLayout());
		JPanel flowCenter = new JPanel();
		frame.add(flowCenter, BorderLayout.SOUTH);
		JButton addFile = new JButton("Add file");
		flowCenter.add(addFile);
		JButton rebuild = new JButton("Rebuild Out of date");
		flowCenter.add(rebuild);
		JButton remove = new JButton("Remove Selected Files");
		flowCenter.add(remove);
		JTable maint = new JTable();
		
		
		// Use the DefaultTableModel to make editing table easy
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
		maint.setModel(tableModel);
		frame.add(maint, BorderLayout.CENTER);
		frame.setVisible(true);
		addFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFile(tableModel);
			}
		});
		rebuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rebuildData();
			}
		});
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFile();
			}
		});
	}

	@Override
	public void addFile(DefaultTableModel tableModel) {
		// JFileChooser brings up the dialog box and only filters text files
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Text Files", "txt");
		chooser.setFileFilter(filter);
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File chosenFile = chooser.getSelectedFile();
			Object[] newRowData = { chosenFile.getName(), chosenFile.getPath() }; // Store
																					// data
																					// in
																					// format
																					// that
																					// can
																					// be
																					// passed
																					// into
																					// tableModel
			writeFile(chosenFile.getName(), chosenFile.getPath());
			tableModel.addRow(newRowData); // adds the data to table
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

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
return 0;	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return null;
	}  // use abstract table model for index
	
	public void readFile(String filename){
		
	}
public void writeFile( String name, String path){	
	String data = name + ',' + path;
	File SearchEngineData = new File("SearchEngineData.txt"); // creates text file in project folder
	try{
		
		SearchEngineData.createNewFile(); //Someone needs to impliment the write functionality and read
		
		
		
			}
			
			
 catch (FileNotFoundException e) {
	 	writeFile(name, path);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

@Override
public String readFile() {
	// TODO Auto-generated method stub
	return null;
}





	
	
}
