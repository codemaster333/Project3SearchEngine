import java.awt.*;
import java.awt.event.*;


public class Main extends Frame {
	
	public Main (){
		
		
		setTitle("Search Engine");
		setSize ( 600 , 400);
		setBackground(Color.white);
		//setLocation ( 600, 600);
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
		
		// Bar underneath the Search Textbox, will be used for the Search Type options
		
		
		//menu bar
		
		MenuBar menu = new MenuBar();
		Menu fileMenu = new Menu( "File");
		MenuItem maint = new MenuItem("Maintenance"); //creates menu item
		fileMenu.add(maint); //adds menu item
		MenuItem about = new MenuItem("About");
		fileMenu.add(about);
		menu.add(fileMenu);
		setMenuBar(menu);
		
		maint.addActionListener( new ActionListener()
		{
			public void actionPerformed (ActionEvent e)
			{
				Frame maintence = new Main("maintence");
				
			}
		}); 
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Main();
		frame.setVisible( true );
	}
	
	//Maintence Window

	public Main ( String maintence){
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
		Label searchMaintence = new Label("Search Engine- Index");
		flowNorth.add(searchMaintence);
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
}
