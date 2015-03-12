package popCultureReference;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import popCultureReference.SearchEngine.Exit;
/**
 * Created by brannon on 2/21/15.
 * Edited/added by Jordan on 2/26/15
 */



interface MaintanceInterface {

	  
    void addFile();

    void rebuildData();

    void removeFile();

}



public class MaintenanceGUI implements MaintanceInterface {
	private JFrame frame;
	/*
Put the GUI components of the maintenance window here.
We could probably put this in SearchEngine.java, but I thought
it'd be nicer to add all the components without seeing all that code.
	 */
	MaintenanceGUI(){
		initialize();

	}
	/* Action Listeners */
	class AboutMenuListener implements ActionListener{public void actionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(null, " Created by Jordan Hart, Brannon Centeno, Kish Moore and Alexis Herrera");
	}
	}
	class ViewHelpMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Need to create help menu");
		}
	}
	private void initialize(){
		//table data initialization 
		
		String[] columnNames = {"1","2"};
		
		Object[][] data = {{"File Name", "Status"}};
		
		//actual window code
		frame = new JFrame();
		frame.setTitle("Maintenance");
		frame.setBounds(100, 100, 600, 400);
		//frame.setResizable(false);
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
		
		
		frame.setLayout( new BorderLayout() );
		 JPanel top = new JPanel();
		 //add panel to north of layout
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
		 JTable maint = new JTable(data, columnNames);	
		 frame.add(maint, BorderLayout.CENTER);
		
		
		
		 frame.setVisible(true);
		 
		 addFile.addActionListener( new ActionListener()
			{
			 public void actionPerformed (ActionEvent e)
			 {
				 addFile();
			 }
			 });
		 
		 
		 rebuild.addActionListener( new ActionListener()
			{
			 public void actionPerformed (ActionEvent e)
			 {
				 rebuildData();
			 }
			 });
		 
		 remove.addActionListener( new ActionListener()
			{
			 public void actionPerformed (ActionEvent e)
			 {
				 removeFile();
			 }
			 });
		}
	
	@Override
	public void addFile() {
		// TODO Auto-generated method stub
		//Activate filehandling!
      FileHandling fileReader = new FileHandling();



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

