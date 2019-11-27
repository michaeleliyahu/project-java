package Ex1;

public class testemp {

	public static void main(String[] args) {
		String t = "plus(plus(x,4),2x)";
		function x = new ComplexFunction(new Monom("2x"));
		function y = x.initFromString(t);
		System.out.println(y);
	}

}
