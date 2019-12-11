package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Monom;

class MonomTestJuint {

//	@Test
//	void testMonomMonom() 
//	{
//		fail("Not yet implemented");
//	}

	@Test
	void testDerivative() {
		Monom monoms1 = new Monom(3,2);
		Monom monoms2 = new Monom(6,1);
		assertEquals(monoms2,monoms1.derivative());

		Monom monoms3 = new Monom(6,3);
		Monom monoms4 = new Monom(18,2);
		assertEquals(monoms4,monoms3.derivative());
		
		Monom monoms5 = new Monom(6,1);
		Monom monoms6 = new Monom(6,0);
		assertEquals(monoms6,monoms5.derivative());
		
		Monom monoms7 = new Monom(6,0);
		Monom monoms8 = new Monom(0,0);
		assertEquals(monoms8,monoms7.derivative());
	}

//	@Test
//	void testF() {
//		fail("Not yet implemented");
//	}

	@Test
	void testMonomString() {
		String[] somemonoms2 = {"5x","5","5x^2","8.1x","0","x^3"};
		String[] somemonoms3 = {"5.0x","5.0","5.0x^2","8.1x","0.0","x^3"};
		for (int i = 0; i < somemonoms2.length; i++)
		{
			Monom monom2 = new Monom(somemonoms2[i]);
			Monom monom3 = new Monom(somemonoms3[i]);
			assertEquals(monom3,monom2);
		}
	}

	@Test
	void testAdd() {
		Monom monoms1 = new Monom(2,2);
		Monom monoms2 = new Monom(monoms1);
		Monom monoms3 = new Monom(-2,2);
		monoms2.add(monoms3);
		assertEquals(Monom.ZERO,monoms2);
		
		Monom monoms4 = new Monom(6,3);
		Monom monoms5 = new Monom(monoms4);
		Monom monoms6 = new Monom(-1,3);
		monoms5.add(monoms6);
		Monom monoms7 = new Monom(5.0,3);
		assertEquals(monoms7,monoms5);
	}

	@Test
	void testMultipy() {
		Monom monoms1 = new Monom(0,3);
		Monom monoms2 = new Monom(monoms1);
		Monom monoms3 = new Monom(-2,5);
		monoms2.multipy(monoms3);
		assertEquals(Monom.ZERO,monoms2);

		Monom monoms4 = new Monom(6,3);
		Monom monoms5 = new Monom(monoms4);
		Monom monoms6 = new Monom(-1,3);
		monoms5.multipy(monoms6);
		Monom monoms7 = new Monom(-6.0,6);
		assertEquals(monoms7,monoms5);
	}

	@Test
	void testEqualsMonom() {
		
		Monom monoms1 = new Monom(2.00000001,2);
		Monom monoms2 = new Monom(monoms1);
		Monom monoms3 = new Monom(2,2);
		assertEquals(true,monoms2.equals(monoms3));

		Monom monoms4 = new Monom(6,3);
		Monom monoms5 = new Monom(monoms4);
		Monom monoms6 = new Monom(6,3);
		assertEquals(true,monoms5.equals(monoms6));
		
		Monom monoms7 = new Monom(6,3);
		Monom monoms8 = new Monom(monoms7);
		Monom monoms9 = new Monom(5,3);
		assertEquals(false,monoms8.equals(monoms9));
	}
//
//	@Test
//	void testInitFromString() {
//		fail("Not yet implemented");
//	}

}
