package assignment.week1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {
	private CaesarCipher CC;

	@Before
	public void setUp() throws Exception {
		this.CC = new CaesarCipher();
	}

	@After
	public void tearDown() throws Exception {
		this.CC = null;
	}

	@Test
	public void encryptTest() {
		assertEquals("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!", CC.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
		assertEquals("Cfopq Ibdflk", CC.encrypt("First Legion", 23));
		assertEquals("Wzijk Cvxzfe", CC.encrypt("First Legion", 17));
	}
	
	@Test
	public void encryptTwoKeysTest() {
		assertEquals("Czojq Ivdzle", CC.encryptTwoKeys("First Legion", 23, 17));
	}

}
