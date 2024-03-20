/*
 * Class: CMSC203-34473-MW-SP24
 * Instructor: Dr. Monshi
 * Description: This program tests cryptoManager class using JUnit testing
 * Due: 3/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Suneth Ramawickrama
*/


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {

	@Test
	public void testisStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("01+&"));
		assertTrue(CryptoManager.isStringInBounds("- []"));
		assertFalse(CryptoManager.isStringInBounds(" {} "));
		assertFalse(CryptoManager.isStringInBounds("~~~"));
	}
	
	@Test 
	public void testCaesarEncryption() {
		assertEquals("1.558JI18@I*;.IB8>", CryptoManager.caesarEncryption("HELLO! HOW ARE YOU", 105));
		assertEquals("+33(&=)", CryptoManager.caesarEncryption("GOODBYE", 100));
		assertEquals("2,3>4", CryptoManager.caesarEncryption("1+2=3",65));
		assertEquals("9W*Y.<;", CryptoManager.caesarEncryption("#ATCX&%",22));
	}
	
	@Test
	public void testCaesarDecryption() {
		assertEquals("HELLO! HOW ARE YOU",CryptoManager.caesarDecryption("1.558JI18@I*;.IB8>", 105));
		assertEquals("GOODBYE",CryptoManager.caesarDecryption("+33(&=)", 100));
		assertEquals("1+2=3",CryptoManager.caesarDecryption("2,3>4", 65));
		assertEquals("#ATCX&%",CryptoManager.caesarDecryption("9W*Y.<;", 22));
	}
	
	@Test
	public void testEncryptBellaso() {
		assertEquals(")&--@:888;4",CryptoManager.bellasoEncryption("!!!!123,,,,", "HELLO"));
		assertEquals("ZR[WTRZH_\\-F\\OYHTH",CryptoManager.bellasoEncryption("MONTGOMERY COLLEGE", "MC"));
		assertEquals("F VV5C6",CryptoManager.bellasoEncryption("CMSC203", "CS"));
		assertEquals("*/RQSUT#+",CryptoManager.bellasoEncryption("&*LMNOP^%", "DEF"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("!!!!123,,,,",CryptoManager.bellasoDecryption(")&--@:888;4", "HELLO"));
		assertEquals("MONTGOMERY COLLEGE",CryptoManager.bellasoDecryption("ZR[WTRZH_\\-F\\OYHTH", "MC"));
		assertEquals("CMSC203",CryptoManager.bellasoDecryption("F VV5C6", "CS"));
		assertEquals("&*LMNOP^%",CryptoManager.bellasoDecryption("*/RQSUT#+", "DEF"));
	}

}
