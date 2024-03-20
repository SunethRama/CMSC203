
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestPublic {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("JAVA"));
		assertTrue(CryptoManager.isStringInBounds("\"JAVA IS FUN\""));
		assertFalse(CryptoManager.isStringInBounds("java"));
		assertFalse(CryptoManager.isStringInBounds("{JAVA"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bye", 3));
		assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
		assertEquals("!\"#", CryptoManager.caesarEncryption("ABC", 96));
		assertEquals("1.558", CryptoManager.caesarEncryption("HELLO", 105));
		assertEquals("UFTUJOH", CryptoManager.caesarEncryption("TESTING", 1));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
	}
	
	@Test
	public void testCaesarDecryption() {
		assertEquals("ABC",CryptoManager.caesarDecryption("DEF", 3));
		assertEquals("ABC",CryptoManager.caesarDecryption("!\"#", 96));
	}
	

	@Test
	public void testEncryptBellaso() {
		assertEquals("WN#\\N &", CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		 assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
		 assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));

	}

}
