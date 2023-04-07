import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.eclipse.swt.widgets.Display;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomePageTest {
    private WelcomePage welcomePage;

    @BeforeEach
    public void setUp() {
        Display.getDefault().syncExec(() -> {
            welcomePage = new WelcomePage();
            welcomePage.createContents(welcomePage.shlTest);
        });
    }

    @AfterEach
    public void tearDown() {
        if (welcomePage.shlTest != null && !welcomePage.shlTest.isDisposed()) {
            Display.getDefault().syncExec(() -> {
                welcomePage.shlTest.dispose();
            });
        }
    }

    // Test to see if the WelcomePage object can be created without throwing an error.
    @Test
    public void testWelcomePageCreation() {
        WelcomePage welcomePage = new WelcomePage();
        assertNotNull(welcomePage);
    }

    // Test that the createContents() method creates a valid menu bar with the correct menu items.
    @Test
    public void testShellIsInitialized() {
        Display.getDefault().syncExec(() -> {
            assertEquals(Display.getDefault(), welcomePage.shlTest.getDisplay());
            assertEquals("CalTrack", welcomePage.shlTest.getText());
        });
    }
}
