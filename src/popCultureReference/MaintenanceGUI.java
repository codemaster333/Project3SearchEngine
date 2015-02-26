package popCultureReference;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import popCultureReference.SearchEngine.Exit;
/**
 * Created by brannon on 2/21/15.
 * Edited/added by Jordan on 2/26/15
 */
public class MaintenanceGUI {
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
		frame = new JFrame();
		frame.setTitle("Maintenance");
		frame.setBounds(100, 100, 600, 400);
		frame.setResizable(false);
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
		 frame.add(flowCenter, BorderLayout.CENTER);
		 JButton addFile = new JButton("Add file");
		 flowCenter.add(addFile);
		 JButton rebuild = new JButton("Rebuild Out of date");
		 flowCenter.add(rebuild);
		 JButton remove = new JButton("Remove Selected Files");
		 flowCenter.add(remove);
		// JTable maint = new JTable( ); //Find better way to increase size then adding more rows and columns
		// top.add(maint, BorderLayout.SOUTH);
		
		
		
		 frame.setVisible(true);
	}
}
