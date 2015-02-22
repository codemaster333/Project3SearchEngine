package popCultureReference;

import javax.swing.*;

/**
 * Created by brannon on 2/21/15.
 */



public class MaintenanceGUI {

    private JFrame frame;

/*


 Put the GUI components of the maintenance window here.
 We could probably put this in SearchEngine.java, but I thought
 it'd be nicer to add all the components without seeing all that code.

  */
    MaintenanceGUI(){
        System.out.println("Hello World");
        initialize();
    }

    private void initialize(){
        frame = new JFrame();
        frame.setTitle("Maintenance");
        frame.setBounds(100, 100, 600, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
