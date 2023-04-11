package LoginScreen;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoginScreenTest {

	private LoginScreen loginScreen;

	@Before
	public void setUp() {
		loginScreen = new LoginScreen();
	}

	@Test
	public void testSuccessfulLogin() {
		assertTrue(loginScreen.login("Demo", "password"));
	}

	@Test
	public void testInvalidPassword() {
		assertFalse(loginScreen.login("Demo", "wrongpassword"));
	}

	@Test
	public void testInvalidLogin() {
		assertFalse(loginScreen.login("NonexistentUser", "password"));
	}
}
