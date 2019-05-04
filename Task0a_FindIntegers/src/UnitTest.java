import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class UnitTest {

	@Test
	public void testFindIntegersTrue1() {
		assertTrue(FindIntegers.checkLine("12ab ;/"));
	}
	
	@Test
	public void testFindIntegersTrue2() {
		assertTrue(FindIntegers.checkLine("12ab ;/1,2"));
	}
	
	@Test
	public void testFindIntegersFalse() {
		assertFalse(FindIntegers.checkLine("ab ;/"));
	}

}
