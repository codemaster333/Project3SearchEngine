import java.awt.*;
import java.awt.event.*;


public class Main extends Frame {
	
	public Main (){
		
		
		setTitle("Search Engine");
		setSize ( 600 , 400);
		setBackground(Color.white);
		setLocation (500,500);
		addWindowListener( new WindowAdapter()
		{
			public void windowClosing( WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		//layout
		
		setLayout ( new BorderLayout() );
		//creates new pannel
		Panel top = new Panel();
		//add panel to north of layout
		add(top, BorderLayout.PAGE_START);
		Label searchTxt = new Label("Search Terms");
		TextField search = new TextField("",28);
		Button searchBtn = new Button("Search");
		
		top.add(searchTxt);
		top.add (search);
		top.add(searchBtn);
		// create new text area
		TextArea searchResult = new TextArea("",30, 30, TextArea.SCROLLBARS_NONE);
		searchResult.setEditable(false);
		add(searchResult, BorderLayout.CENTER);
		
		// Bar underneath the Search Textbox
		Panel middle = new Panel();
		add (middle, BorderLayout.PAGE_END);
		Label searchType = new Label ("Search Type: ");
		
		//AWT does not allow for radio buttons so checkboxes are used
		CheckboxGroup choices = new CheckboxGroup();
		Checkbox searchTerms = new Checkbox("Search Terms", choices, true);
		Checkbox anySearch = new Checkbox("Any Search Terms", choices, true);
		Checkbox exactPhrase = new Checkbox("Exact Phrase", choices, true);
		
		middle.add(searchType);
		middle.add(searchTerms);
		middle.add(anySearch);
		middle.add(exactPhrase);
		
		
		// Menu Bar
		
		MenuBar menu = new MenuBar();
		setMenuBar(menu);
		
		// Menu Choices
		Menu fileMenu = new Menu("File");
		Menu helpMenu = new Menu ("Help");
		
		
		
		// File Menu
			menu.add(fileMenu);
			MenuItem maint = new MenuItem("Maintenance"); //Creates Menu Item for Maintenance
			MenuItem exit = new MenuItem("Exit");
			
			fileMenu.add(maint); 
			fileMenu.add(exit);
			
		// Help Menu
			menu.add(helpMenu);
			MenuItem viewHelp = new MenuItem("View Help");
			MenuItem about = new MenuItem("About");
			
			helpMenu.add(viewHelp);
			helpMenu.add(about);
			
		// Action Listeners for File and Help Commands
			maint.addActionListener( new ActionListener()
			{
				public void actionPerformed (ActionEvent e)
				{
					Frame maintenance = new Main("maintenance");
				
				}
			}); 
		
		
		   viewHelp.addActionListener (new ActionListener()
		   {
				public void actionPerformed (ActionEvent e)
				{
				    Frame help = new Main("Help");
				}
			});
			
			
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Main();
		frame.setVisible( true );
	}
	
	// Maintenance Window

	public Main ( String maintenance){
		setTitle("Search Engine");
		setSize ( 600 , 400);
		setBackground(Color.white);
		//setLocation ( 600, 600);
		addWindowListener( new WindowAdapter()
		{
			public void windowClosing( WindowEvent e)
			{
				dispose(); //Closes current window without closing whole program
			}
		});
		

		
		//layout
		
		
		setLayout ( new BorderLayout() );
		Panel top = new Panel();
		//add panel to north of layout
		add(top, BorderLayout.NORTH);
		Panel flowNorth = new Panel();
		top.add(flowNorth, BorderLayout.NORTH);
		Label searchMaintenance = new Label("Search Engine- Index");
		flowNorth.add(searchMaintenance);
		Panel flowCenter = new Panel();
		add(flowCenter, BorderLayout.CENTER);
		Button addFile = new Button("Add file");
		flowCenter.add(addFile);
		Button rebuild = new Button("Rebuild Out of date");
		flowCenter.add(rebuild);
		Button remove = new Button("Remove Selected Files");
		flowCenter.add(remove);
		TextArea maint = new TextArea("",20,10,TextArea.SCROLLBARS_NONE); //Find better way to increase size then adding more rows and columns
		maint.setEditable(false);
		add(maint, BorderLayout.SOUTH);
		
		
		
		setVisible(true);

	}
	
	
		// Help Information Frame
		
		public Main (String help)
		{
			setTitle("Help");
			setSize ( 600 , 400);
			setBackground(Color.white);
			//setLocation ( 600, 600);
			addWindowListener( new WindowAdapter()
			{
				public void windowClosing( WindowEvent e)
				{
					dispose(); //Closes current window without closing whole program
				}
			});
		}
}
