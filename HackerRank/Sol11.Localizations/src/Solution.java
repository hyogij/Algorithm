import java.util.HashMap;

public class Solution {
	private static HashMap<HashMap<String, String>, String> localizations = null;

	public static void main(String[] args) {
		localizations = new HashMap<HashMap<String, String>, String>();
		setString("EN", "Greeting", "Hello1");
		setString("EN", "Goodbye", "See ya");
//		setString("EN", "Greeting", "Hello2");
		setString("FR", "Greeting", "Hello");

		System.out.println("getString " + getString("FR", "Greeting"));
		System.out.println("getString " + getString("EN", "Greeting"));
	}

	public static void setString(String lan, String token, String content) {
		HashMap<String, String> key = new HashMap<String, String>();
		key.put(lan, token);
		// Updates content string if key is already existed
		localizations.put(key, content);
	}

	public static String getString(String lan, String token) {
		HashMap<String, String> key = new HashMap<String, String>();
		key.put(lan, token);

		if (localizations.containsKey(key) == true) {
			return localizations.get(key);
		}

		return "";
	}
}
