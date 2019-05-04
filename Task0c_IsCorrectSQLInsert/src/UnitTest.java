import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class UnitTest {

	@Test
	public void testFindIntegersTrue1() {
		assertTrue(IsCorrectSQLInsert.checkLine("INSERT INTO table_1 (a,b,c) VALUES (val,'val','1.2')"));
	}
	
	@Test
	public void testFindIntegersTrue2() {
		assertTrue(IsCorrectSQLInsert.checkLine("insert into table_1 (a,b,c) values (val,'val','1.2')"));
	}
	
	@Test
	public void testFindIntegersFalse1() {
		assertFalse(IsCorrectSQLInsert.checkLine("INSERT INTO table1 (a, b, c) VALUES (val, 'val', '1.2')"));
	}
	
	@Test
	public void testFindIntegersFalse2() {
		assertFalse(IsCorrectSQLInsert.checkLine("INSERT INTO 1table (a,b,c) VALUES (val,'val','1.2')"));
	}
	
	@Test
	public void testFindIntegersFalse3() {
		assertFalse(IsCorrectSQLInsert.checkLine("INSERT INTO table (a,b,c) VALUES (val,'val',\"1.2\")"));
	}

}
