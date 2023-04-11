import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import LoginScreen.LoginScreen;

public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(450, 300);
		shell.setText("CalTrack");
		
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.open();
		
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
