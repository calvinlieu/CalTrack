import java.io.IOException;


import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class WelcomePage {
	
//	private static Label welcomeLabel;
	Shell shlTest;
	public Shell shell;
	
	public WelcomePage() {
        // create the shell object
        Display display = Display.getDefault();
        shlTest = new Shell(display);
        shlTest.setMinimumSize(new Point(500, 300));
        shlTest.setMaximumSize(new Point(500, 300));
        shlTest.setModified(false);
    }
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WelcomePage window = new WelcomePage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
        createContents(shlTest);
        shlTest.open();
        shlTest.layout();
        Display display = Display.getDefault();
        
        
        while (!shlTest.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

	/**
	 * Create contents of the window.
	 * @param welcomeShell 
	 */
	public void createContents(Shell shell) {
		
		shell.setSize(500, 500);
		shell.setText("CalTrack");
		
		 Composite composite = new Composite(shell, SWT.NONE);
	     composite.setBounds(0, 0, 484, 241);
	     
	     Label lblWelcomeToCaltrack = new Label(composite, SWT.NONE);
	     lblWelcomeToCaltrack.setBounds(105, 30, 283, 38);
	     lblWelcomeToCaltrack.setFont(SWTResourceManager.getFont("MV Boli", 20, SWT.NORMAL));
	     lblWelcomeToCaltrack.setText("Welcome to CalTrack!");
	     
	     Button btnNewButton = new Button(composite, SWT.PUSH);
	     btnNewButton.addSelectionListener(new SelectionAdapter() {
	     	@Override
	     	public void widgetSelected(SelectionEvent e) {
	            Display display = Display.getDefault();
	            Shell bmiShell = new Shell(display);
	            bmiShell.setText("BMI Calculator");
	            bmiShell.setSize(420, 420);
	            BMICalc bmiCalc = new BMICalc(display);
	            bmiCalc.createContents(bmiShell);
	           
	            
	        }
	     });
	     btnNewButton.setBounds(10, 141, 220, 88);
	     btnNewButton.setText("BMI Calculator");
	     
	     Button openTrackerButton = new Button(composite, SWT.PUSH);
	     openTrackerButton.setBounds(254, 141, 220, 88);
	     openTrackerButton.setText("Calorie Tracker");
	     openTrackerButton.addSelectionListener(new SelectionAdapter() {
	         @Override
	         public void widgetSelected(SelectionEvent event) {
	        	 Display display = Display.getDefault();
		            Shell calorieShell = new Shell(display);
		            calorieShell.setText("Calorie Tracker");
		            CalorieTrack calorieTrack = new CalorieTrack(display);
		            calorieTrack.createContents();
	         }
	     });
		
		
        
        shell.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
        
        Menu menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);

        MenuItem fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
        fileMenuHeader.setText("&File");

        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        fileMenuHeader.setMenu(fileMenu);

        MenuItem exitMenuItem = new MenuItem(fileMenu, SWT.PUSH);
        exitMenuItem.setText("&Logout");

        exitMenuItem.addListener(SWT.Selection, event -> {
        	LoginScreen loginScreen = new LoginScreen();
            shell.dispose();
            loginScreen.open();
        });
        
        Monitor primaryMonitor = shell.getDisplay().getPrimaryMonitor();
        Rectangle bounds = primaryMonitor.getBounds();
        int x = bounds.x + (bounds.width - shell.getSize().x) / 2;
        int y = bounds.y + (bounds.height - shell.getSize().y) / 2;
        shell.setLocation(x, y);
        
        
        shell.pack();
        shell.open();
        
    }
}