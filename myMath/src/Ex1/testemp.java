package Ex1;

public class testemp {

	public static void main(String[] args) {
		Monom a = new Monom(2,2);
		Monom b = new Monom(3,3);
		ComplexFunction c = new ComplexFunction("plus",a,b);
		//ComplexFunction d = new ComplexFunction("Times",a,b);
		//ComplexFunction c = new ComplexFunction("plus",a,b);
		//System.out.println(d);
		System.out.println(c);
		//System.out.println(c.getOp());
		c.mul(b);
		System.out.println(c);
		c.div(b);
		System.out.println(c);
		c.max(b);
		System.out.println(c);
		c.min(b);
		System.out.println(c);
		c.comp(b);
		System.out.println(c);
		//System.out.println(c.f(4));
		ComplexFunction d = new ComplexFunction();
		//System.out.println(d);     // to check and fix case that both op them null 
		function x = d.initFromString("mul(plus(2.0x^2,3.0x^3),3.0x^3)");
		System.out.println(x);
		function y = c.initFromString(c.toString());
		System.out.println(y);
		// check copy - if there is different address
		
		

	}

}
