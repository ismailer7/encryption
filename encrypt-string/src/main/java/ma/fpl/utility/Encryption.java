package ma.fpl.utility;

public class Encryption {
	
	public static String encrypt(final String string, final int n) {
		try {
			if (string.isEmpty()) {
				return "";
			}
			StringBuilder encrypted = new StringBuilder(string);
			
			if (n > 0) {
				int count = 0;
				while(count < n) {
					encrypted = singleEncryption(encrypted);
					count ++;
				}
				return encrypted.toString();
			} else {
				return string;
			}
			
		} catch(Exception e) {
			return null;
		}
	
	}
	
	public static StringBuilder singleEncryption(StringBuilder string) {
		StringBuilder encrypted = new StringBuilder();
		for (int i = 1; i < string.length(); i += 2) {
			encrypted.append(string.charAt(i));
		}
		for (int i = 0; i < string.length(); i += 2) {
			encrypted.append(string.charAt(i));
		}
		return encrypted;
	}
	
	public static String decrypt(final String cryptedString, final int n) {
		try {
			if (cryptedString.isEmpty()) {
				return "";
			}
			StringBuilder decrypted = new StringBuilder(cryptedString);
			
			if (n > 0) {
				int count = 0;
				while (count < n) {
					decrypted = singleDecryption(decrypted);
					count ++;
				}
				return decrypted.toString();
			} else {
				return cryptedString;
			}
		}catch(Exception e) {
			return null;
		}	
	}

	public static StringBuilder singleDecryption(StringBuilder string) {
		StringBuilder decrypted = new StringBuilder(getEmptyString(string));
		for(int i = 0, k = 1; i < string.length() / 2; i++, k += 2) {
			decrypted.setCharAt(k, string.charAt(i));
		}
		for(int i = string.length() / 2, k = 0; i < string.length(); i++, k += 2) {
			decrypted.setCharAt(k, string.charAt(i));
		}
		return decrypted;
	}
	
	public static String getEmptyString(StringBuilder string) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			s.append(" ");
		}
		return s.toString();
	}
}
