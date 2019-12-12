package Ex1;


import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

import Ex1.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 *
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	public ArrayList<Monom> allMonoms;
	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		allMonoms = new ArrayList<Monom>();
		allMonoms.add(new Monom(Monom.ZERO));
	}
	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {
		if(s.length()==0)
		{
			
			Monom m = new Monom(0,0); 
			allMonoms = new ArrayList<Monom>();
			allMonoms.add(m);
		
//			throw new RuntimeException("Your string is empty or null");
		}
		else
		{
			s = s.replaceAll("\\s", "");	
		int i = 0;
		boolean check = false;
		boolean firstRun=false;
		allMonoms = new ArrayList<Monom>();
		String temp = "";
		if(s.charAt(0)=='-')
		{
			temp = "-" ;
			i++;
		}
		while(i<s.length()) {
			if(s.charAt(i)!='+' &&  s.charAt(i)!='-')
			{
				temp = temp.concat(s.charAt(i)+"");
				check = true;
			}
			//+0.1x^5 -1.2999999999999998x +5.0
			if ((s.charAt(i)=='+' ||  s.charAt(i)=='-')  )  
			{

				allMonoms.add(new Monom(temp));
				temp = "";
				if( s.charAt(i)=='-') {
					temp = '-' + temp;
				}

			}
			i++;
		}
		
		if(!temp.equals("")) {
			allMonoms.add(new Monom(temp));
		}
		Comparator<Monom>sortMonom = new Monom_Comperator();
		allMonoms.sort(sortMonom);
		}
	}
	@Override
	public double f(double x) {
		double sum=0;
		for(int i=0;i<allMonoms.size();i++)
		{
			sum += allMonoms.get(i).get_coefficient()*Math.pow(x,allMonoms.get(i).get_power());
		}
		return sum;
	}
	@Override
	public void add(Polynom_able p1) {
		// TODO Auto-generated method stub
		boolean check = false;
		Iterator<Monom> itr = p1.iteretor();
		while(itr.hasNext()) {
			check = false;
			Monom m= itr.next();
			for (Monom monom : allMonoms) {
				if(m.get_power()==monom.get_power()) {
					monom.add(m);
					check = true;
				}
			}
			if (!check) {
				allMonoms.add(m);
			}
		}
		remove_Zeros();
		Comparator<Monom>sortMonom = new Monom_Comperator();
		allMonoms.sort(sortMonom);
	}
	@Override
	public void add(Monom m1) {
		boolean check = false;
		for (Monom monom : allMonoms) {
			if(m1.get_power()==monom.get_power()) {
				monom.add(m1);
				check = true;
			}
		}
		if (!check) {
			Monom m2 = new Monom(m1);
			allMonoms.add(m2);
		}
		remove_Zeros();

		Comparator<Monom>sortMonom = new Monom_Comperator();
		allMonoms.sort(sortMonom);
	}
	@Override
	public void substract(Polynom_able p1) {
		if(this.equals(p1)) {
			this.allMonoms=new ArrayList<Monom>();
			this.allMonoms.add(new Monom("0"));           
		}
		else
		{
			Monom minu= Monom.MINUS1;
			p1.multiply(minu);
			this.add(p1);
		}
	}
	public void multiply(Polynom_able p1) {
		Iterator<Monom> itr = p1.iteretor();
		Polynom temp = new Polynom();
		Monom t = new Monom("0");
		while(itr.hasNext())
		{
			Monom m= itr.next();
			for (Monom monom : allMonoms)

			{
				Monom temp2 = new Monom(monom);
				temp2.multipy(m);
				temp.add(temp2);
			}
		}
		for (int i = 0; i <temp.allMonoms.size(); i++) {
			if(temp.allMonoms.get(i).equals(t)) 
			{
				temp.allMonoms.remove(i);
			}
		}
		allMonoms=temp.allMonoms;
		if(allMonoms.size()==0)
		{
			Monom m = new Monom(0,0);
			allMonoms.add(m);
		}
	remove_Zeros();
		Comparator<Monom>sortMonom = new Monom_Comperator();
		allMonoms.sort(sortMonom);
	}
	@Override
	public boolean equals(Object p1) {
		if(p1 instanceof ComplexFunction)
		{
			return p1.equals(this);
		}
		if(p1 instanceof Monom)
		{
			function t = new Polynom(p1.toString());
			
			return this.equals(t);
		}
		if(p1 instanceof Polynom_able)
		{
			Polynom_able p2 = (Polynom_able) p1;
			Iterator<Monom> itrP1 = p2.iteretor();
			int count = 0;
			Iterator<Monom> itrMonom = allMonoms.iterator();
			while(itrP1.hasNext())
			{
				Monom mP1 = itrP1.next();
				count ++;
				if(!itrMonom.hasNext())
				{
					return false;
				}
				Monom mMonom = itrMonom.next();
				if(!mP1.equals(mMonom))
				{
					return false;
				}
			}
			if(count != allMonoms.size())
			{
				return false;
			}
			return true;
		}
		else
			return false;
	}
	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		return allMonoms.get(0).get_coefficient() == 0;
	}
	@Override
	public double root(double x0, double x1, double eps) {
		double temp;
		double rootFinal=0;
		if(f(x0)*f(x1)<=0)
		{
			if(f(x0)<f(x1))
			{
				temp = x0;
				x0 = x1;
				x1 = temp;
			}
			while(Math.abs(f(((x0+x1)/2)))>eps)
			{
				if((f((x0+x1)/2))>0)
				{
					x0=(x0+x1)/2;
					rootFinal=x0;
				}
				else
				{
					x1=(x0+x1)/2;
					rootFinal=x1;
				}
			}
		}
		else
		{
			throw new RuntimeException("Error");
		}
		return rootFinal;
	}
	@Override
	public function copy() {
		if(this.allMonoms.size()>0) {
			Polynom_able a1=new Polynom(this.allMonoms.get(0).toString());
			for(int i=1;i<this.allMonoms.size();i++) {
				Monom copymonom=new Monom(this.allMonoms.get(i).toString());
				a1.add(copymonom);
			}
			return a1;
		}
		else return null;
	}
	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		Polynom_able der =new Polynom();
		for(Monom monom:allMonoms)
		{
			Monom m=monom.derivative();
			der.add(m);
		}

		return der;
	}
	@Override
	public String toString ()
	{
		String s = "";
		String m = "";
		int count = 0;
		for (Monom monom : allMonoms) 
		{
			count++;
			boolean goodmonom = true;
			if(monom.get_coefficient()==0) 	
			{
				s="0";	    goodmonom=false;	
			}
			if(monom.get_power()==0&&goodmonom==true)   	
			{
				s= "" + monom.get_coefficient();	goodmonom=false;
			}
			if(monom.get_power()==1&&goodmonom==true)	
			{
				s= monom.get_coefficient()+"x"; goodmonom=false;
			}
			if(goodmonom==true) 
			{					
				s = monom.get_coefficient()+"x"+"^"+monom.get_power();
			}
			if(s.charAt(0)=='-')
			{
				m = m + s;
			}
			else
			{
				if (count>1) 
				{
					m = m + "+" + s;
				}
				else 	m = m + s;
			}
		}
		return m;
	}
	@Override
	public double area(double x0, double x1, double eps) {
		double sum = 0;
		while(x0<x1)
		{
			if(f(x0)>0)
			{
				sum += eps*f(x0);
			}
			x0+=eps;
		}
		return Math.abs(sum);
	}
	@Override
	public Iterator<Monom> iteretor() {
		// TODO Auto-generated method stub
		return allMonoms.iterator();
	}
	@Override
	public void multiply(Monom m1) {
		
		for (int i = 0; i < allMonoms.size(); i++) {
			
		this.allMonoms.get(i).multipy(m1);                               
		}
		Comparator<Monom>sortMonom = new Monom_Comperator();
		
		if(allMonoms.size()==0)
		{
			Monom m = new Monom(0,0);
			allMonoms.add(m);
		}
		remove_Zeros();
		allMonoms.sort(sortMonom);
	}
	//private method to deal with spare zeros in the polynom
	private void remove_Zeros() {
		// TODO Auto-generated method stub
		for (int i = 0; i < allMonoms.size(); i++) {
			if(allMonoms.size()==1 && allMonoms.get(0).isZero()==true)
			{
				
			}
			else if(allMonoms.get(i).isZero())
			{
				allMonoms.remove(i);
				i = i-1;
			}
		}
	}
	@Override
	public function initFromString(String s) {
		function fx = new Polynom(s);
		return fx;		
	}
}