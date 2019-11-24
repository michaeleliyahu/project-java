package Ex1;
import java.util.ArrayList;
/**
 * This class represents a simple (naive) tester for the Monom class, 
 * Note: <br>
 * (i) The class is NOT a JUNIT - (i.e., educational reasons) - should be changed to a proper JUnit in Ex1. <br>
 * (ii) This tester should be extend in order to test ALL the methods and functionality of the Monom class.  <br>
 * (iii) Expected output:  <br>

****test1 : multiply function****
monom1:0    monom2:-2.0x^5    results:0
monom1:6.0x^3    monom2:-1.0x^3    results:-6.0x^6

****test2 : add function****
monom1:2.0x^2    monom2:-2.0x^2    results:0
monom1:6.0x^3    monom2:-1.0x^3    results:5.0x^3

****test3 : equals function****
monom1:2.00000001x^2    monom2:2.0x^2    results:true
monom1:6.0x^3    monom2:6.0x^3    results:true

****test4 : monom function****
monom1:1.0x^3
monom2:0.1
monom3:3.0x
monom4:5.0
monom5:2.5x^4
monom6:2.4x^2

 */
public class MonomTest {
	public static void main(String[] args){
		testMultiply();
		testAdd();
		testEquals();
		testMonom();


	}
	//test for Multiply
	public static void testMultiply() {
		Monom monoms1 = new Monom(0,3);
		Monom monoms2 = new Monom(monoms1);
		Monom monoms3 = new Monom(-2,5);
		monoms2.multipy(monoms3);
		System.out.println();
		System.out.println("****test1 : multiply function****");
		System.out.println("monom1:"+ monoms1 + "    monom2:"+ monoms3 +"    results:" + monoms2);
		Monom monoms4 = new Monom(6,3);
		Monom monoms5 = new Monom(monoms4);
		Monom monoms6 = new Monom(-1,3);
		monoms5.multipy(monoms6);
		System.out.println("monom1:"+ monoms4 + "    monom2:"+ monoms6 +"    results:" + monoms5);
	}
	//test for add
	public static void testAdd() {
		Monom monoms1 = new Monom(2,2);
		Monom monoms2 = new Monom(monoms1);
		Monom monoms3 = new Monom(-2,2);
		monoms2.add(monoms3);
		System.out.println();
		System.out.println("****test2 : add function****");
		System.out.println("monom1:"+ monoms1 + "    monom2:"+ monoms3 +"    results:" + monoms2);
		Monom monoms4 = new Monom(6,3);
		Monom monoms5 = new Monom(monoms4);
		Monom monoms6 = new Monom(-1,3);
		monoms5.add(monoms6);
		System.out.println("monom1:"+ monoms4 + "    monom2:"+ monoms6 +"    results:" + monoms5);
	}
	//test for equals
	public static void testEquals() {
		Monom monoms1 = new Monom(2.00000001,2);
		Monom monoms2 = new Monom(monoms1);
		Monom monoms3 = new Monom(2,2);

		System.out.println();
		System.out.println("****test3 : equals function****");
		System.out.println("monom1:"+ monoms1 + "    monom2:"+ monoms3 +"    results:" + monoms2.equals(monoms3));
		Monom monoms4 = new Monom(6,3);
		Monom monoms5 = new Monom(monoms4);
		Monom monoms6 = new Monom(6,3);

		System.out.println("monom1:"+ monoms4 + "           monom2:"+ monoms6 +"    results:" + monoms5.equals(monoms6));
	}
	//test for monom
	public static void testMonom() {
		Monom monom1= new Monom("x^3");
		Monom monom2= new Monom("0.1");
		Monom monom3= new Monom("3x");
		Monom monom4= new Monom("5");
		Monom monom5= new Monom("2.5x^4");
		Monom monom6 = new Monom("2.4x^2");	

		System.out.println();
		System.out.println("****test4 : monom function****");
		System.out.println("monom1:" + monom1);
		System.out.println("monom2:" + monom2);
		System.out.println("monom3:" + monom3);
		System.out.println("monom4:" + monom4);
		System.out.println("monom5:" + monom5);
		System.out.println("monom6:" + monom6);

		System.out.println();
		System.out.println("****Invalid input****");
		String[] somemonoms = {".5x","5x^","5x^.","8x.","","5d"};
		for (int i = 0; i < somemonoms.length; i++)
		{
			try
			{
				Monom monom = new Monom(somemonoms[i]);
				System.out.println(monom);
			}
			catch (Exception e) {
				System.err.println(i+") "+somemonoms[i] + "   wrong monom");
			}
		}
	}

}