import static org.junit.jupiter.api.Assertions.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.junit.jupiter.api.Test;


class WelcomePageTest {

	
	//Test to see if the WelcomePage object can be created without throwing an error.
	@Test
	public void testWelcomePageCreation() {
	    WelcomePage welcomePage = new WelcomePage();
	    assertNotNull(welcomePage);
	}
	
	
	
	//Test that the createContents() method creates a valid menu bar with the correct menu items.
	@Test
	public void testCreateContents() {
	    WelcomePage welcomePage = new WelcomePage();
	    Shell shell = welcomePage.shell;
	    welcomePage.createContents(shell);
	    Menu menuBar = shell.getMenuBar();
	    assertNotNull(menuBar);
	    MenuItem[] items = menuBar.getItems();
	    assertEquals(1, items.length);
	    assertEquals("&File", items[0].getText());
	    Menu submenu = items[0].getMenu();
	    assertNotNull(submenu);
	    MenuItem[] subitems = submenu.getItems();
	    assertEquals(1, subitems.length);
	    assertEquals("&Logout", subitems[0].getText());
	}
	

}
