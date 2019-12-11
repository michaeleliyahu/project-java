package Ex1;

import java.awt.SystemColor;
/*

 ****test1 : area function****
1) polynom: x^3-6x-2     x0=2,x1=3     result:  -0.7494987500008534
2) polynom: x^2-10       x0=-10,x1=15  result:  1208.4858374998503
3) polynom: 9-x^2        x0=3,x1=10    result:  -261.2878345000532

 ****test2 : derivative function****
1) polynom:-3.2x^2-3.0x+6.0x+5.0       results:-6.4x+3.0
2)polynom:7.0x^7+7.0x^3+5.0x+5.0      results:49.0x^6+21.0x^2+5.0

 ****test3 : add monom function****
1) polynom:2.0x+2.0                    add:5,-5x,-3.2x^2      results:-3.2x^2-3.0x+7.0
2) polynom:3.0x^3+7.0x^2+3.0x+5.0      add:5,-5x,-3.2x^2      results:3.0x^3+3.8x^2-2.0x+10.0

 ****test4 : substract function****
1) polynom:3.0x^2+5.0x+5.0      polynom2:3.0x^2+5.0x+5.0        results:0
2) polynom:3.0x^2+5.0x+5.0      polynom2:-8.0x^2-5.0x-7.0       results:-5.0x^2+0-2.0

 ****test5 : multiply function****
1) polynom:5.0x^2+5.0x^2+7.0x            polynom2:0              results:0
2) Polynom5.0x^3+2.0x^2+1.0x^2+4.0x      polynom2:5.0x+2.0       results:25.0x^4+25.0x^3+26.0x^2+8.0x

 ****test6 : add polynom + polynom function****
1) polynom:0                   polynom2:3.0x^2+5.0x+5.0              results:3.0x^2+5.0x+5.0
2) Polynom3.0x^2+5.0x+5.0      polynom2:5.0x^3+7.0x^2+5.0x+3.0       results:5.0x^3+10.0x^2+10.0x+8.0

 ****test7 : creation of polynom and toString functions****
1) polynom:                        result:  0
2) polynom: x+9                    result: 1.0x+9.0
3) polynom: 2x^2+3x+1              result: 2.0x^2+3.0x+1.0
4) polynom: 5-5x-3.2x^2            result: -3.2x^2-5.0x+5.0
5) polynom: x^5+6                  result: 1.0x^5+6.0

 ****test8 : root function****
1) polynom:x     x0=10,x1=-5      result:-0.01953125

 ****test9 : equals function****
1) polynom:2.0x^2              polynom2:2.0x^2+1.0            results:false
2) polynom2.0x^2+5.0x+3.0      polynom2:2.0x^2+5.0x+3.0       results:true

****test10 : copy function****
1) polynom:1.7000000000000002x^2+1.7x+2.0      result(polynom2 after copy): 1.7000000000000002x^2+1.7x+2.0
2) polynom:3.0x^2+5.0x+6.0                     result(polynom2 after copy): 3.0x^2+5.0x+6.0

 */
public class PolynomTest {
	public static void main(String[] args) {

		testArea();
		testDerivative();
		testAddMonom();		
		testSubstract();
		testMultiply();
		testAddPolynom();
		testCreationPolynom();
		testRoot();
		testEquals();
		testCopy();

	}

	// area function
	public static void testArea() {   // area function
		System.out.println();
		System.out.println("****test1 : area function****");
		Polynom p1 = new Polynom("x^3-6x-2");
		System.out.println("polynom: x^3-6x-2     x0=2,x1=3     result:  "+p1.area(2, 3, 0.001));
		Polynom p2 = new Polynom("x^2-10");
		System.out.println("polynom: x^2-10       x0=-10,x1=15  result:  "+p2.area(-10, 15, 0.001));
		Polynom p3 = new Polynom("9-x^2");
		System.out.println("polynom: 9-x^2        x0=3,x1=10    result:  "+p3.area(3, 10, 0.001));

	}
	//test for derivative
	public static void testDerivative() {
		Polynom p1 = new Polynom("-3x-3.2x^2+5+6x");//-5x-3.2x^2
		Polynom p2 = new Polynom();

		for (int i = 0; i < p1.allMonoms.size(); i++) {

			p2.add(p1.allMonoms.get(i).derivative());
		}
		Polynom p3 = new Polynom("5+7x^7+5x+7x^3");
		Polynom p4 = new Polynom();

		for (int i = 0; i < p1.allMonoms.size(); i++) {

			p4.add(p3.allMonoms.get(i).derivative());
		}
		System.out.println();
		System.out.println("****test2 : derivative function****"+"\n" +"polynom:"+p1+"       results:"+ p2);
		System.out.println("polynom:"+p3+"      results:"+ p4);
	}

	//test for add polynom + monom
	public static void testAddMonom() {
		String[] monoms1 = {"5","-5x","-3.2x^2"};

		Polynom p1 = new Polynom("2x+2");
		Polynom p4 = new Polynom("2x+2");
		for (int i = 0; i < monoms1.length; i++) {
			Monom x = new Monom(monoms1[i]);
			p1.add(x);
		}
		System.out.println();
		System.out.println("****test3 : add monom function****"+"\n" +"polynom:"+p4+"                    add:"+monoms1[0]+","+monoms1[1]+","+monoms1[2]+"      results:"+ p1);

		String[] monoms2 = {"5","-5x","-3.2x^2"};

		Polynom p2 = new Polynom("5+3x+7x^2+3x^3");
		Polynom p3 = new Polynom("5+3x+7x^2+3x^3");
		for (int i = 0; i < monoms1.length; i++) {
			Monom x = new Monom(monoms1[i]);
			p2.add(x);
		}
		System.out.println("polynom:"+p3+"      add:"+monoms2[0]+","+monoms2[1]+","+monoms2[2]+"      results:"+ p2);
	}

	//test for substract
	public static void testSubstract() {
		Polynom p1 = new Polynom("5+3x^2+5x");
		Polynom p2 = new Polynom("5+3x^2+5x");
		Polynom p3 = new Polynom("5+3x^2+5x");
		p1.substract(p2);
		Polynom p4 = new Polynom("5+3x^2+5x");
		Polynom p5 = new Polynom("7+5x+8x^2");
		Polynom p6 = new Polynom("5+3x^2+5x");
		p4.substract(p5);
		System.out.println();
		System.out.println("****test4 : substract function****"+"\n"+"polynom:"+p3+"      polynom2:"+p2+"        results:"+p1);    
		System.out.println("polynom:"+p6+"      polynom2:"+p5+"       results:"+p4);    

	}

	//test for multiply
	public static void testMultiply() {
		Polynom p1 = new Polynom("7x+5x^2+5x^2");
		Polynom p2 = new Polynom("0");
		Polynom p3 = new Polynom("7x+5x^2+5x^2");
		p1.multiply(p2);
		Polynom p4 = new Polynom("4x+2x^2+1x^2+5x^3");
		Polynom p5 = new Polynom("2+5x");
		Polynom p6 = new Polynom("4x+2x^2+1x^2+5x^3");
		p4.multiply(p5);
		System.out.println();
		System.out.println("****test5 : multiply function****"+"\n"+"polynom:"+p3+"            polynom2:"+p2+"              results:"+p1);
		System.out.println("Polynom"+p6+"      polynom2:"+p5+"       results:"+p4);
	}

	//add polynom + polynom
	public static void testAddPolynom() {  
		Polynom p1 = new Polynom("0");
		Polynom_able p2 = new Polynom();
		Polynom p3 = new Polynom("5+3x^2+5x");
		p2 = (Polynom_able) p1.copy();
		p1.add(p3);
		System.out.println();
		System.out.println("****test6 : add polynom + polynom function****"+"\n"+"polynom:"+p2+"                   polynom2:"+p3+"              results:"+p1);
		Polynom_able p4 = new Polynom();
		Polynom p5 = new Polynom("7x^2+5x^3+5x+3");
		Polynom p6 = new Polynom("5+3x^2+5x");
		p4 = (Polynom_able) p3.copy();

		p6.add(p5);	
		System.out.println("Polynom"+p4+"      polynom2:"+p5+"       results:"+p6);
	}

	// creation of polynom and toString functions
	public static void testCreationPolynom() {  
		System.out.println();
		System.out.println("****test7 : creation of polynom and toString functions****");
		Polynom p1 = new Polynom();                 //checking polynom function by creation new polynom
		Polynom p2 = new Polynom("x+9");            //checking polynom function by creation new polynom
		Polynom p3 = new Polynom("2x^2+3x+1");      //checking polynom function by creation new polynom
		Polynom p4 = new Polynom("5-5x-3.2x^2");    //checking polynom function by creation new polynom
		Polynom p5 = new Polynom("x^5+6");          //checking polynom function by creation new polynom
		System.out.println("polynom:                        result:  "+p1);                     //checking toString function by printing
		System.out.println("polynom: x+9                    result: "+p2);                     //checking toString function by printing
		System.out.println("polynom: 2x^2+3x+1              result: "+p3);                     //checking toString function by printing
		System.out.println("polynom: 5-5x-3.2x^2            result: "+p4);                     //checking toString function by printing
		System.out.println("polynom: x^5+6                  result: "+p5);                     //checking toString function by printing
	}

	// root function
	public static void testRoot() {  
		Polynom p1 = new Polynom("x");
		System.out.println();
		System.out.println("****test8 : root function****"+"\n"+"polynom:x     x0=10,x1=-5      result:"+p1.root(10, -5, 0.01));
	}

	//test for equals
	public static void testEquals() {  
		Polynom p1 = new Polynom("2x^2");
		Polynom p2 = new Polynom("2x^2+1");
		Polynom p3 = new Polynom("2x^2+5x+3");
		Polynom p4 = new Polynom("2x^2+5x+3");

		System.out.println();
		System.out.println("****test9 : equals function****"+"\n"+"polynom:"+p1+"              polynom2:"+p2+"            results:"+p1.equals(p2));
		System.out.println("polynom"+p3+"      polynom2:"+p4+"       results:"+p3.equals(p4));
	}


	private static void testCopy() {
		System.out.println();
		System.out.println("****test10 : copy function****");
		Polynom p1 = new Polynom();
		String[] monoms1 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}

		Polynom p3 = new Polynom("3x^2+5x+6");
		Polynom_able p4=(Polynom_able) p3.copy();
		Polynom_able p2=(Polynom_able) p1.copy();
		System.out.println("polynom:"+p1.toString()+"      result: "+p2.toString());
		System.out.println("polynom:"+p3.toString()+"                     result: "+p4.toString());
	}
	

}








