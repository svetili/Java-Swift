import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testFindIntegersTrue1() {
		assertTrue(FindFunnyCharacters.checkLine("12ab ;/"));
	}
	
	@Test
	public void testFindIntegersTrue2() {
		assertTrue(FindFunnyCharacters.checkLine("12ab "));
	}
	
	@Test
	public void testFindIntegersFalse() {
		assertFalse(FindFunnyCharacters.checkLine("abcABC129~!@#$%^&*()_+-=/\\"));
	}
}
