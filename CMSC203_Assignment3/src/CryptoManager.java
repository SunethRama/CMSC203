/*
 * Class: CMSC203-34473-MW-SP24
 * Instructor: Dr. Monshi
 * Description: This program encrypts and decrypts a string using caesar cipher and bellaso cipher
 * Due: 3/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Suneth Ramawickrama
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (int i=0 ; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE ) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		String encryptedText=""; // this variable will store the encrypted string
		int encryptedChar; // this variable will be used to encrypt each character of the plainText variable
		
		if (isStringInBounds(plainText)) {
			
			for (int i=0 ; i < plainText.length();i++) {
	
				encryptedChar = (plainText.charAt(i) + key);  // adds the key to each character of the plainText string
				
				while (encryptedChar > UPPER_RANGE) {
					encryptedChar = (encryptedChar - RANGE); // if the character is out of range subtract RANGE from it
				}
				
				encryptedText = encryptedText + (char)(encryptedChar); // build the encrypted string
			}
			
			return encryptedText;
				
		}
		else {
			return("The selected string is not in bounds, Try again.");
		}
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		int encryptedChar; // this variable will be used to encrypt each character of the plainText variable
		String strKey = bellasoStr; // this variable will be used to build the string key
		String encryptedText = ""; // this variable will hold the encrypted text
		int keyLen; // this variable will be used to extend the string key to the length of the plainText
		
		if (plainText.length() > bellasoStr.length()) { 
												
			// if the length of the plainText is greater than the string key, we have to repeat the key to the length of the plainText
			
			keyLen = plainText.length() - bellasoStr.length();
		
			for (int i=0 ; i < keyLen ; i++) {
				strKey = strKey + strKey.charAt(i); // for every less character, we add the corresponding character of strKey to the strKey
			}
		}
		
		else {
			
			// if the key is longer than the text we can append each character of plainText to the strKey to build the key
			
			for (int i=0 ; i < plainText.length();i++) {
				strKey = strKey + plainText.charAt(i);
			}
		}
		
		for (int i=0 ; i < plainText.length();i++) {
			encryptedChar = plainText.charAt(i)+ strKey.charAt(i); // add the key to each character
			
			while (encryptedChar > UPPER_RANGE) {
				encryptedChar = encryptedChar - RANGE; // if the value is out of range subtract RANGE of each character
			}
			
			encryptedText  = encryptedText  + (char) encryptedChar; // build the encrypted text
		}
		
		return encryptedText ;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		String decryptedText="";
		int decryptedChar; // this variable will be used to decrypts the each character of the encrypted text
		for (int i=0 ; i<encryptedText.length(); i++) {
			
			decryptedChar = encryptedText.charAt(i)-key; // subtract key from each character
			while (decryptedChar < LOWER_RANGE) {
				decryptedChar = decryptedChar + RANGE; // if the value is out of range subtract RANGE from the character
			}
			decryptedText = decryptedText + (char)decryptedChar; // build the decrypted text
		}
		return decryptedText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		
		String strKey = bellasoStr; // this variable will be used to build the string key
		String decryptedText = ""; // this variable will hold the decrypted text
		int keyLen; // this variable will hold the difference of length between ecryptedText and string key
		int decryptedChar; // this variable will used to decrypt the each character of the ecryptedText
		
		if (encryptedText.length() > bellasoStr.length()) {
			// if the length of the encryptedText is greater than the string key, we have to repeat the key to the length of the encryptedText
			keyLen = encryptedText.length() - bellasoStr.length();
		
			for (int i=0 ; i < keyLen ; i++) {
				strKey = strKey + strKey.charAt(i); // for every less character, we add the corresponding character of strKey to the strKey
			}
		}
		
		else {
			// if the key is longer than the text we can append each character of encryptedText to the strKey to build the key
			for (int i=0 ; i < encryptedText.length();i++) {
				strKey = strKey + encryptedText.charAt(i);
			}
		}
		
		for (int i=0 ; i < encryptedText.length(); i++) {
			
			decryptedChar = encryptedText.charAt(i) - strKey.charAt(i); // subtract key from each character
			while (decryptedChar < LOWER_RANGE) {
				decryptedChar = decryptedChar + RANGE; // if the key is out of range we add the RANGE to the character
			}
			decryptedText  = decryptedText  + (char)decryptedChar; // build the decrypted text
		}
		
		return decryptedText ;
			
	}
	
}
