package Ex1;

import java.io.IOException;
import java.util.Iterator;

public class TempMain {

	public static void main(String[] args) {
//		Polynom a = new Polynom("x");
//		Polynom b = new Polynom("x^2");
//		Polynom c = new Polynom("3");
//		Polynom d = new Polynom("x^3+5");
//		
//		
//		Polynom e1 = new Polynom(" - 1 . 0 x ^ 4   + 2 . 4 x ^ 2   + 3 . 1 " );
//		Polynom e2 = new Polynom("+0.1x^5 -1.2999999999999998x +5.0");
//		ComplexFunction e = new ComplexFunction("plus",e1,e2);
//		
//		
//		
//		
//		/**
//f(x)= plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0)
//f(x)= plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)
//f(x)= div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)
//f(x)= -1.0x^4 +2.4x^2 +3.1
//f(x)= +0.1x^5 -1.2999999999999998x +5.0
//f(x)= max(max(max(max(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)
//f(x)= min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)
//		 */
//		Function_GUI ans = new Function_GUI();    
//	
//		// check name	
//		ans.add(a); //f(x)=x
//		ans.add(b);//f(x)=x^2
//		ans.add(c);//f(x)=3
////		ans.add(d);//f(x)=x^3+5
//		ans.add(e);//plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0)
//		
//        Iterator<function> itr = ans.iterator();
//        while(itr.hasNext()) {
//        	System.out.println(itr.next().toString());    
//        }
//        
//        int w=1000, h=600, res=200;        
//        double xMin=-10;
//        double xMax=10;
//        double yMin=-5;
//        double yMax=5;
//        Range rx=new Range(xMin,xMax);
//        Range ry=new Range(yMin,yMax);
//        ans.drawFunctions(w, h, rx, ry,res);      
	    Function_GUI read = new Function_GUI(); 
	    try {
			read.initFromFile("text.txt");
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	    for(int i = 0; i<read.arrF.size();i++) {
	    	System.out.println(read.arrF.get(i).toString());
	    }
	    //itr

	}
	      

}
