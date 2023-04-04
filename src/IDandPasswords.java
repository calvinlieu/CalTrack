import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	IDandPasswords() {
		
		loginInfo.put("Demo", "password");
		loginInfo.put("Calvin", "password1");
		loginInfo.put("Achronix", "password2");
	}
	
	protected HashMap getLoginInfo() {
		return loginInfo;
	}

}
