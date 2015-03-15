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
      addFileReader();



   }
   @Override
   public void rebuildData() {
      // TODO Auto-generated method stub

   }
   @Override
   public void removeFile() {
      // TODO Auto-generated method stub

   }

   public void addFileReader(){
      StringBuilder sb = new StringBuilder();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files Only", "txt");
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileFilter(filter);
      if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

        //get the file
         File file = fileChooser.getSelectedFile();

         //create a scanner for the file
         //IO Exception handled in method declaration
         try{
            Scanner input = new Scanner(file);
            //read text from file
            //record text in index
            int position = 0;
            String word = "CurrentWord";
            writeFile ( word, position );
            while(input.hasNext()){
/* Suggest changing this to word by word because we need to record the words for the index.              sb.append(input.nextLine()); */
            word = input.next();
            writeFile ( word, position );
            position ++;
            }
               sb.append("\n");

            input.close();


         }catch(Exception e){
            System.out.println("Error");
         }





      }
      else{
         sb.append("No file was selected");
      }

      System.out.println(sb);
      



   }
}

public static void writeFile ( String word, int position )
{
	// Sort the new word relative to the words already in the file; if it's exactly the same as one, 
	// record its new position after those instances of the word as given at
	// http://wpollock.com/AJava/Proj-B-SearchEngine-UI.htm . If it's new, record it in its proper
	// alphabetic position.
}
