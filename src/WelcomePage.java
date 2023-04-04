import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class WelcomePage {
	
//	private static Label welcomeLabel;
	private Shell shell;
	
	public WelcomePage() {
        // create the shell object
        Display display = Display.getDefault();
        shell = new Shell(display);
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
        createContents(shell);
        shell.open();
        shell.layout();
        Display display = Display.getDefault();
        while (!shell.isDisposed()) {
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

        shell.setSize(300, 200);
        shell.setText("Welcome");

        Composite composite = new Composite(shell, SWT.NONE);
        composite.setBounds(0, 0, 300, 200);

        Label label = new Label(composite, SWT.NONE);
        label.setText("Welcome to CalTrack");
        label.setBounds(85, 50, 150, 25);

        Button button = new Button(composite, SWT.NONE);
        button.setBounds(100, 100, 100, 25);
        button.setText("Logout");
        button.addListener(SWT.Selection, event -> {
        	LoginScreen loginScreen = new LoginScreen();
            shell.dispose();
            loginScreen.open();
        });

    }

}
