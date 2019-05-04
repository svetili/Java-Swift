package tests;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import person.Main;

public class UnitTest {

	@Test
	public void testPersonInputTrue1() {
		assertTrue(Main.checkLine("Petar;Georgiev;Petrov;M;9.9.1975;184;Bulgaria;Sofia;Triaditsa;1000;Dondukov;2;;;M;SU;4.10.2005;15.5.2017;5.76"));
	}
	
	@Test
	public void testPersonInputTrue2() {
		assertTrue(Main.checkLine("Ivan;Petrov;Ivanov;M;28.2.2003;177;Bulgaria;Varna;Chaika;9006;Srebarna;6;3;5;S;SOU Chintulov;16.9.2015;22.5.2020"));
	}
	
	@Test
	public void testPersonInputFalse1() {
		assertFalse(Main.checkLine("Petar;Petrov;M;9.9.1975;184;Bulgaria;Sofia;Triaditsa;1000;Dondukov;2;;;M;SU;4.10.2005;15.5.2017;5.76"));
	}
	
	@Test
	public void testPersonInputFalse2() {
		assertFalse(Main.checkLine("Petar;Petrov;pan196;M;9.9.1975;184;Bulgaria;Sofia;Triaditsa;1000;Dondukov;2;;;M;SU;4.10.2005;15.5.2017;5.76"));
	}
	
	@Test
	public void testPersonInputFalse3() {
		assertFalse(Main.checkLine("Petar;Atanasov;Petrov;M;9.9.1975;184;Bulgaria;Sofia;Triaditsa;1000;Dondukov;2;;M;SU;4.10.2005;15.5.2017;5.76"));
	}

}
