import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;

public class LoginScreen{
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	
	private static Text userNameField;
	private static Text passWordField;
	private static Button loginButton;
	private static Button resetButton;
	private static Label userNameLabel;
	private static Label passWordLabel;
	private static Label messageLabel;
	
	

	protected Shell shell;

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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(420, 420);
		shell.setText("CalTrack");
		
		userNameLabel = new Label(shell, SWT.NONE);
		userNameLabel.setBounds(50, 100, 75, 25);
		userNameLabel.setText("Username: ");
		
		passWordLabel = new Label(shell, SWT.NONE);
		passWordLabel.setBounds(50, 150, 72, 25);
		passWordLabel.setText("Password: ");
		
		messageLabel = new Label(shell, SWT.NONE);
		messageLabel.setBounds(125, 250, 250, 36);
		
		userNameField = new Text(shell, SWT.BORDER);
		userNameField.setBounds(125,  100, 200, 25);
		
		passWordField = new Text(shell, SWT.BORDER);
		passWordField.setBounds(125, 150, 200, 25);
		
		loginButton = new Button(shell, SWT.NONE);
		loginButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
        loginButton.setBounds(100, 200, 100, 25);
        loginButton.setText("Log In");
		
        resetButton = new Button(shell, SWT.NONE);
        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setText("Reset");

	}

	public void widgetSelected(SelectionEvent e) {
	    if (e.getSource() == resetButton) {
	        userNameField.setText("");
	        passWordField.setText("");
	    }

	    if (e.getSource() == loginButton) {
	        String userName = userNameField.getText();
	        String passWord = passWordField.getText();

	        if (loginInfo.containsKey(userName)) {
	            if (loginInfo.get(userName).equals(passWord)) {
	                messageLabel.setForeground(new Color(255, 255, 255));
	                messageLabel.setText("Login Successful");
	                shell.dispose();
	                // WelcomePage welcomePage = new WelcomePage(userName);
	            } else {
	                messageLabel.setBackground(new Color(255, 0, 0));
	                messageLabel.setText("Wrong Password");
	            }
	        } else {
	            messageLabel.setForeground(new Color(255, 0, 0));
	            messageLabel.setText("User not found");
	        }
	    }
	}

	


}
