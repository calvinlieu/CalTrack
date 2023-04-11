package LoginScreen;
import WelcomePage.WelcomePage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class LoginScreen{
	
	static Text userNameField;
	static Text passWordField;
	static Button loginButton;
	static Button resetButton;
	static Label userNameLabel;
	static Label passWordLabel;
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
		shell.setModified(false);
		
		userNameLabel = new Label(shell, SWT.NONE);
		userNameLabel.setBounds(50, 292, 75, 25);
		userNameLabel.setText("Username: ");
		
		passWordLabel = new Label(shell, SWT.NONE);
		passWordLabel.setBounds(50, 323, 75, 25);
		passWordLabel.setText("Password: ");
			
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
                    shell.dispose();

                    Display display = Display.getDefault();
                    WelcomePage welcomePage = new WelcomePage();
                    Shell welcomeShell = new Shell(display);
                    welcomePage.createContents(welcomeShell);
               
                 
                    welcomeShell.pack();
                    welcomeShell.open();
         
                } else {
                	Shell shell1 = new Shell();
                    MessageBox messageBox = new MessageBox(shell1, SWT.ICON_ERROR | SWT.OK);
                    messageBox.setMessage("Error logging in.");
                    messageBox.open();
                    return;
                }
            }
		});
		
        loginButton.setBounds(90, 354, 100, 25);
        loginButton.setText("Log In");
		
        resetButton = new Button(shell, SWT.NONE);
        resetButton.setBounds(225, 354, 100, 25);
        resetButton.setText("Clear");
        resetButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                userNameField.setText("");
                passWordField.setText("");
               
            }
		});
        

	}

	

}