package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Polynom_able;
import Ex1.function;

class PolynomTestJunit {

	@Test
	void testPolynom() {
		Polynom p1 = new Polynom();
		Polynom ans = new Polynom("0.0");
		assertEquals(ans,p1);
		Polynom p2 = new Polynom("x+9");
		Polynom ans2 = new Polynom("1.0x+9.0");
		assertEquals(ans2,p2);
		Polynom p3 = new Polynom("2x^2+3x+1");    
		Polynom ans3 = new Polynom("2.0x^2+3.0x+1.0");
		assertEquals(ans3,p3);
		Polynom p4 = new Polynom("5-5x-3.2x^2");  
		Polynom ans4 = new Polynom("-3.2x^2-5.0x+5.0");
		assertEquals(ans4,p4);
		Polynom p5 = new Polynom("x^5+6");    
		Polynom ans5 = new Polynom("1.0x^5+6.0");
		assertEquals(ans5,p5);
	}

	// @Test
	// void testPolynomString() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// void testF() {
	// Polynom p1 = new Polynom("5+3x^2+5x");
	// double x = 1;
	// Polynom ans = new Polynom("13");
	// assertEquals(ans,p1.f(x));
	// }

	@Test
	void testAddPolynom_able() {
		Polynom p1 = new Polynom("0");
		Polynom p2 = new Polynom("5+3x^2+5x");
		Polynom ans = new Polynom("3.0x^2+5.0x+5.0");
		p1.add(p2);
		assertEquals(ans,p1);

		Polynom p3 = new Polynom("7x+4");
		Polynom p4 = new Polynom("5+3x^2+5x");
		Polynom ans2 = new Polynom("3.0x^2+12.0x+9.0");
		p3.add(p4);
		assertEquals(ans2,p3);

		Polynom p5 = new Polynom("7x^3+4");
		Polynom p6 = new Polynom("5+3x^2+5x");
		Polynom ans3 = new Polynom("7.0x^3+3.0x^2+5.0x+9.0");
		p5.add(p6);
		assertEquals(ans3,p5);
	}

	@Test
	void testAddMonom()
	{
		String[] monoms1 = {"5","-5x","-3.2x^2"};
		String[] monoms2 = {"5","-5x","-3.2x^2"};
		Polynom p1 = new Polynom("2x+2");
		Polynom p2 = new Polynom("5+3x+7x^2+3x^3");
		Polynom ans = new Polynom("-3.2x^2-3.0x+7.0");
		Polynom ans2 = new Polynom("3.0x^3+3.8x^2-2.0x+10.0");
		for (int i = 0; i < monoms1.length; i++)
		{
			Monom x = new Monom(monoms1[i]);
			Monom x2 = new Monom(monoms2[i]);
			p1.add(x);
			p2.add(x2);
		}
		assertEquals(ans,p1);
		assertEquals(ans2,p2);
	}

	@Test
	void testSubstract()
	{
		Polynom p1 = new Polynom("5+3x^2+5x");
		Polynom p2 = new Polynom("5+3x^2+5x");
		Polynom ans = new Polynom("0");
		p1.substract(p2);
		assertEquals(ans,p1);

		Polynom p3 = new Polynom("5+3x^2+5x");
		Polynom p4 = new Polynom("7+5x+8x^2");
		Polynom ans2 = new Polynom("-5.0x^2-2.0");
		p3.substract(p4);
		assertEquals(ans2,p3);

	}

	@Test
	void testMultiplyPolynom_able()
	{
		Polynom p1 = new Polynom("7x+5x^2+5x^2");
		Polynom p2 = new Polynom("0");
		Polynom ans = new Polynom("0");
		p1.multiply(p2);
		assertEquals(ans,p1);

		Polynom p3 = new Polynom("4x+2x^2+1x^2+5x^3");
		Polynom p4 = new Polynom("2+5x");
		Polynom ans2 = new Polynom("25.0x^4+25.0x^3+26.0x^2+8.0x");
		p3.multiply(p4);
		assertEquals(ans2,p3);

	}

	@Test
	void testEqualsObject()
	{
		Polynom p1 = new Polynom("2x^2");
		Polynom p2 = new Polynom("2x^2+1");
		assertEquals(false,p1.equals(p2));

		Polynom p3 = new Polynom("2x^2+5x+3");
		Polynom p4 = new Polynom("2x^2+5x+3");
		assertEquals(true,p3.equals(p4));
	}

	@Test
	void testRoot()
	{
		Polynom p1 = new Polynom("x");
		double ans = -0.01953125;
		assertEquals(ans,p1.root(10, -5, 0.01));

	}

	@Test
	void testCopy()
	{
		Polynom p1 = new Polynom("5+7x+2x^2");
		Polynom p2 = new Polynom("3x^2+5x+6");
		Polynom_able p3=(Polynom_able) p1.copy();
		Polynom_able p4=(Polynom_able) p2.copy();
		assertEquals(p1.toString(),p3.toString());
		assertEquals(p2.toString(),p4.toString());
	}

	@Test
	void testDerivative()
	{
		Polynom p1 = new Polynom("-3x-3.2x^2+5+6x");//-5x-3.2x^2
		Polynom p2 = new Polynom();
		Polynom p3 = new Polynom("5+7x^7+5x+7x^3");
		Polynom p4 = new Polynom();
		for (int i = 0; i < p1.allMonoms.size(); i++)
		{

			p2.add(p1.allMonoms.get(i).derivative());
			p4.add(p3.allMonoms.get(i).derivative());
		}
		Polynom ans = new Polynom("-6.4x+3.0");
		assertEquals(ans,p2);

		Polynom ans2 = new Polynom("49.0x^6+21.0x^2+5.0");
		assertEquals(ans2,p4);
	}

	@Test
	void testArea() {
		Polynom p1 = new Polynom("x^3-6x-2");
		double ans = 1.3091222721983706;
		assertEquals(ans,p1.area(2, 3, 0.001));

		Polynom p2 = new Polynom("x^2-10");
		double ans2 = 1250.6495398498512;
		assertEquals(ans2,p2.area(-10, 15, 0.001));

		Polynom p3 = new Polynom("9-x^2");
		p3.area(3, 10, 0.001);
		double ans3 = 0.0;
		assertEquals(ans3,p3.area(3, 10, 0.001));
	}


	@Test
	void testInitFromString() {
		String p1 = new String("3x+5");
		function fx = new Polynom();
		function ans = new Polynom("3x+5");
		assertEquals(ans,fx.initFromString(p1));
	}


}
