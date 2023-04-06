import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class LoginScreen{
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	
	static Text userNameField;
	private static Text passWordField;
	private static Button loginButton;
	private static Button resetButton;
	private static Label userNameLabel;
	private static Label passWordLabel;
	private static Label messageLabel;
	
	

	protected Shell shell;


	public Object userPasswordField;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginScreen window = new LoginScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		Image image = new Image(display, "src/image.png");
		Label label = new Label(shell, SWT.NONE);
		label.setImage(image);
		label.setBounds(0, 0, 415,275);
		
        shell.setMinimumSize(new Point(420, 450));
        shell.setMaximumSize(new Point(420, 450));
		shell.setModified(false);
		shell.pack();
		shell.open();
		shell.layout();
		
		Monitor primaryMonitor = shell.getDisplay().getPrimaryMonitor();
	    Rectangle bounds = primaryMonitor.getBounds();
	    int x = bounds.x + (bounds.width - shell.getSize().x) / 2;
	    int y = bounds.y + (bounds.height - shell.getSize().y) / 2;
	    shell.setLocation(x, y);
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	boolean login(String username, String password) {
	    // Check if the entered username and password are valid
	    if (username.equals("Demo") && password.equals("password")) {
	        return true;
	    } else if (username.equals("Calvin") && password.equals("password1")) {
	        return true;
	    } else {
	    	return false;
	    }
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(500, 500);
		shell.setText("CalTrack");
		
		userNameLabel = new Label(shell, SWT.NONE);
		userNameLabel.setBounds(50, 292, 75, 25);
		userNameLabel.setText("Username: ");
		
		passWordLabel = new Label(shell, SWT.NONE);
		passWordLabel.setBounds(50, 323, 75, 25);
		passWordLabel.setText("Password: ");
		
		messageLabel = new Label(shell, SWT.NONE);
		messageLabel.setBounds(90, 385, 134, 36);
		
		userNameField = new Text(shell, SWT.BORDER);
		userNameField.setBounds(125,  289, 200, 25);
		
		passWordField = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		passWordField.setBounds(125, 323, 200, 25);
		
		loginButton = new Button(shell, SWT.NONE);
		loginButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                String userId = userNameField.getText();
                String password = passWordField.getText();

                boolean loginSuccessful = login(userId, password);

                if (loginSuccessful) {
                	messageLabel.setText("Login successful");
                    shell.dispose();

                    Display display = Display.getDefault();
                    WelcomePage welcomePage = new WelcomePage();
                    Shell welcomeShell = new Shell(display);
                    welcomePage.createContents(welcomeShell);
                    
                    welcomeShell.pack();
                    welcomeShell.open();
         
                } else {
                    messageLabel.setText("Login failed");
                }
            }
		});
		
        loginButton.setBounds(90, 354, 100, 25);
        loginButton.setText("Log In");
		
        resetButton = new Button(shell, SWT.NONE);
        resetButton.setBounds(225, 354, 100, 25);
        resetButton.setText("Reset");
        resetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                userNameField.setText("");
                passWordField.setText("");
               
            }
		});
        

	}

	

}