import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class WelcomePage {
	
//	private static Label welcomeLabel;
	Shell shlTest;
	
	public WelcomePage() {
        // create the shell object
        Display display = Display.getDefault();
        shlTest = new Shell(display);
        shlTest.setMinimumSize(new Point(500, 500));
        shlTest.setMaximumSize(new Point(500, 500));
        shlTest.setModified(true);
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
        shlTest.setSize(500,500);
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
	     composite.setBounds(0, 0, 482, 433);
	     
	     Label lblWelcomeToCaltrack = new Label(composite, SWT.NONE);
	     lblWelcomeToCaltrack.setBounds(99, 42, 283, 38);
	     lblWelcomeToCaltrack.setFont(SWTResourceManager.getFont("MV Boli", 20, SWT.NORMAL));
	     lblWelcomeToCaltrack.setText("Welcome to CalTrack!");
	     
	     Button btnNewButton = new Button(composite, SWT.NONE);
	     btnNewButton.addSelectionListener(new SelectionAdapter() {
	     	@Override
	     	public void widgetSelected(SelectionEvent e) {
	     	
	     	}
	     });
	     btnNewButton.setBounds(56, 184, 170, 88);
	     btnNewButton.setText("BMI Calculator");
		
		
        
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
        
        
    }
}