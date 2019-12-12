
package Ex1Testing;
import Ex1.*;
/**
 *

 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Monom;
import Ex1.Polynom;

///**Monom a = new Monom(2,2);
//Monom b = new Monom(3,3);
//ComplexFunction c = new ComplexFunction("plus",a,b);
////ComplexFunction d = new ComplexFunction("Times",a,b);
////ComplexFunction c = new ComplexFunction("plus",a,b);
////System.out.println(d);
//System.out.println(c);
////System.out.println(c.getOp());
//c.mul(b);
//System.out.println(c);
//c.div(b);
//System.out.println(c);
//c.max(b);
//System.out.println(c);
//c.min(b);
//System.out.println(c);
//c.comp(b);
//System.out.println(c);**/
////System.out.println(c.f(4));
//ComplexFunction d = new ComplexFunction();
////System.out.println(d);     // to check and fix case that both op them null
//function x = d.initFromString("mul(plus(2.0x^2,3.0x^3),3.0x^3)");
//function x2 = d.initFromString("mul(plus(2.0x^2,3.0x^3),3.0x^3)");
//System.out.println(x);
////function y = c.initFromString(c.toString());
////System.out.println(y);
////check copy - if there is different address

class ComplexFunctionTest {
	public static final double EPS = 0.00001;
	@Test
	void plustest() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction p1 = new ComplexFunction("plus", m1,m2);
		double x = 1 ;
		double ans = 5.0;
		assertEquals(ans,p1.f(x));
	}
	@Test
	void multest() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction p1 = new ComplexFunction("mul", m1,m2);
		double x = 1 ;
		double ans = 6.0;
		assertEquals(ans,p1.f(x));
	}
	@Test
	void divtest() {
		Monom m1 = new Monom(3,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction p1 = new ComplexFunction("div", m1,m2);
		double x = 1 ;
		double ans = 1.0;
		assertEquals(ans,p1.f(x));
	}
	@Test
	void maxtest() {
		Monom m1 = new Monom(2,1);
		Monom m2 = new Monom(3,1);
		ComplexFunction p1 = new ComplexFunction("max", m1,m2);
		// ComplexFunction s1 = new ComplexFunction();
		// function p1 = m1.initFromString("plus(2.0x^2,3.0x^3)");
		// function p2 = s1.initFromString("max(2.0x,3.0x)");
		double x = 1 ;
		double ans = 3.0;
		assertEquals(ans,p1.f(x));
	}

	@Test
	void mintest() {
		Monom m1 = new Monom(2,1);
		Monom m2 = new Monom(3,1);
		ComplexFunction p1 = new ComplexFunction("min", m1,m2);
		double x = 1 ;
		double ans = 2.0;
		assertEquals(ans,p1.f(x));
	}
	@Test
	void lefttest() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction p1 = new ComplexFunction("plus",m1,m2);
		String ans ="2.0x^2";
		assertEquals(ans,p1.left().toString());
	}
	@Test
	void righttest() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction p1 = new ComplexFunction("plus",m1,m2);
		String ans ="3.0x^3";
		assertEquals(ans,p1.right().toString());
	}
	@Test
	void getoptest() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction p1 = new ComplexFunction("plus",m1,m2);
		Operation ans =Operation.Plus;
		assertEquals(ans,p1.getOp());
	}
	@Test
	void initFromStringtest() {
		Monom f1 = new Monom(2,2);
		Monom f2 = new Monom(3,3);
		ComplexFunction m1 = new ComplexFunction();
		ComplexFunction m2 = new ComplexFunction("plus",f1,f2);
		function ans = m1.initFromString("plus(2.0x^2,3.0x^3)");
		ComplexFunction ans2 = (ComplexFunction)ans;
		assertEquals(ans2.toString(),m2.toString());
	}

	@Test
	void test() {
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction cf = new ComplexFunction("plus", m1,m2);
		cf.mul(m2);
		Polynom p = new Polynom();
		p.add(m1);
		p.add(m2);
		p.multiply(m2);
		double v = 4.0;
		double dp = p.f(v);
		double dcf = cf.f(v);
		double dd = Math.abs(dp-dcf);
		if(dd>EPS) {
			fail("ERR: should got the same value from: "+p+"should be: "+dp+"  and "+cf+"should be "+dcf);

		}
	}

	@Test
	void testOfString() {
		Polynom p1 = new Polynom();
		p1.add( new Monom(2,2));
		Polynom p2 = new Polynom();
		p2.add(new Monom(3,3));
		Monom m1 = new Monom(2,2);
		Monom m2 = new Monom(3,3);
		ComplexFunction cf = new ComplexFunction("plus", m1,m2);
		ComplexFunction cf3 = new ComplexFunction("plus", p1,p2);
		//System.out.println(cf);
		cf.mul(m2);
		cf3.mul(m2);
		String s = cf.toString();
		function cf2 = cf.initFromString(s);
		if(!cf.equals(cf2)) {
			fail("ERR: "+cf+" should be equals to "+cf2);
		}
		if(!cf.equals(cf3)) {
			fail("ERR: "+cf+" should be equals to "+cf3);
		}
	}
	@Test
	void testComplexFunction() {
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x-1","x-2", "x-3", "x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p3 = new Polynom(s3[0]);
		for(int i=1;i<s3.length;i++) {
			p3.multiply(new Polynom(s3[i]));
		}

		ComplexFunction cf = new ComplexFunction("plus",p1,p2);
		ComplexFunction cf4 = new ComplexFunction("div", new Monom("x"),p3);
		cf.div(p1);
		String s = cf.toString();
		function cf5 = cf4.initFromString(s);
		if(!cf.equals(cf5)) {
			fail("ERR: "+cf+" should be equals to "+cf5);
		}
		int size=10;
		for(int i=0;i<size;i++) {
			double x = Math.random();
			double d = cf.f(x);
			double d5 = cf5.f(x);
			assertEquals(d,d5,EPS);
		}
	}

}