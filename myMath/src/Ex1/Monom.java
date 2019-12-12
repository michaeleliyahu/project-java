
package Ex1;

import java.util.Comparator;

import javax.management.RuntimeErrorException;

import org.w3c.dom.css.Counter;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	public Monom(double a, int b)
	{
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) 
	{
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() 
	{
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() 
	{
		if(this.get_power()==0) {return getNewZeroMonom();
		}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	public double f(double x)
	{
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() 
	{
		return this.get_coefficient() == 0;
	}
	public Monom(String s) 
	{
		s = s.replaceAll("\\s", "");
		
		if(s.length()==0)
		{
			throw new RuntimeException("coefficient not proper ");
		}
		else {
			s=s.replace('X', 'x');
			int xloc = (s.indexOf('x'));
			
			if (xloc==-1)
			{
				this._power=0;
				if(s.length()<=1)
				{
					if(s.length()==0)	this._coefficient=1;
					if(s.length()==1&&s.charAt(0)=='-')	this._coefficient=-1;
					if (s.charAt(0)>='0'&&s.charAt(0)<='9')	this._coefficient=Double.parseDouble(s);
				}
				else
				{
					int i = 0;
					if(s.charAt(i)!= '-'&&(s.charAt(i)<'0'||s.charAt(i)>'9'))
					{
						throw new RuntimeException("coefficient not proper ");
					}
					else
					{
						int count = 0 ;
						int count2 = 0;
						while (i<s.length()) 
						{
							if(s.charAt(i)=='-')
							{
								if(i!=0) 
								{
									throw new RuntimeException("coefficient not proper ");
								}
								count++;
								if((s.length()==1||(s.charAt(i+1)<'0'||s.charAt(i+1)>'9')||count>1))
								{
									throw new RuntimeException("coefficient not proper ");
								}
							}
							if (s.charAt(i)>='0'&&s.charAt(i)<='9')
							{
								if(s.length()-i>1&&s.charAt(i+1)!='.'&&(s.charAt(i+1)<'0'||s.charAt(i+1)>'9'))
								{
									throw new RuntimeException("coefficient not proper ");
								}
							}
							if(s.charAt(i)=='.')
							{
								count2++;
								if(s.length()>1-i&&(s.charAt(i+1)<'0'&&s.charAt(i+1)>'9')||count2>1)
								{
									throw new RuntimeException("coefficient not proper ");
								}
							}
							i++;					
						}
						this._coefficient=Double.parseDouble(s);
					}
				}
			}
			else
			{
				String beforex = s.substring(0, xloc);
				String afterx = s.substring(xloc+1, s.length());

				//beforx
				if(beforex.length()<=1)
				{
					if(beforex.length()==0)	this._coefficient=1;
					if(beforex.length()==1&&beforex.charAt(0)=='-')	this._coefficient=-1;
					if (s.charAt(0)>='0'&&s.charAt(0)<='9')	this._coefficient=Double.parseDouble(beforex);
				}
				else 
				{
					int i = 0;
					if(beforex.charAt(i)!= '-'&&(beforex.charAt(i)<'0'||beforex.charAt(i)>'9')&&beforex.charAt(i)!='x')
					{
						throw new RuntimeException("coefficient not proper ");
					}
					int count = 0 ;
					int count2 = 0;
					while (i<beforex.length()) {
						if(beforex.charAt(i)=='-')
						{
							if(i!=0) 
							{
								throw new RuntimeException("coefficient not proper ");
							}
							count++;
							if((beforex.length()==1||(beforex.charAt(i+1)<'0'||beforex.charAt(i+1)>'9')||count>1))
							{
								throw new RuntimeException("coefficient not proper ");
							}
						}
						if (beforex.charAt(i)>='0'&&beforex.charAt(i)<='9')
						{
							if(beforex.length()-i>1&&beforex.charAt(i+1)!='.'&&(beforex.charAt(i+1)<'0'||beforex.charAt(i+1)>'9'))
							{
								throw new RuntimeException("coefficient not proper ");
							}
						}
						if(beforex.charAt(i)=='.')
						{
							count2++;
							if(beforex.length()>1-i&&(beforex.charAt(i+1)<'0'&&beforex.charAt(i+1)>'9')||count2>1)
							{
								throw new RuntimeException("coefficient not proper ");
							}
						}
						i++;
					}
					this._coefficient=Double.parseDouble(beforex);
				}
				//afterx
				int i = 0 ;
				if (afterx.length()==0)
				{
					this._power=1;
				}
				else
				{
					if (afterx.length()==1||afterx.charAt(i)!='^')
					{
						throw new RuntimeException("power not proper ");
					}
					else
					{
						int f = 1;
						while (f<=afterx.length())
						{
							if (afterx.charAt(i)<'0' && afterx.charAt(i)>'9')
							{
								throw new RuntimeException("power not proper ");				
							}
							f++;
						}
						this._power=Integer.parseInt(afterx.substring(1));
					}
				}
			}
		}
	}
	public void add(Monom m)
	{
		if(this._power==m._power)
		{
			this._coefficient=this._coefficient+m._coefficient;
		}
		else
		{
			throw new RuntimeException("EROR: the power of Monom should be the same ");
		}
	}
	public void multipy(Monom d)
	{

		this._coefficient=this._coefficient*d._coefficient;
		this._power=this._power+d._power;	
	}
	@Override
	public String toString() 
	{
		String ans = "";
		if(this._coefficient==0)
			return "0";
		if(this._power==0)
			return "" + this._coefficient;
		if(this._power==1)
		{
			return this._coefficient+"x";		
		}
		ans = this._coefficient+"x"+"^"+this._power;
		return ans;
	}
	@Override
	public boolean equals (Object m) 
	{
		if(m instanceof Polynom)
		{
			return m.equals(this);
		}
		if(m instanceof ComplexFunction)
		{
			return m.equals(this);
		}
		if(m instanceof Monom)
		{
			Monom m2 = (Monom) m;
			if((Math.abs(this._coefficient-m2._coefficient)<=Monom.EPSILON) && (Math.abs(this._power-m2._power)<=Monom.EPSILON)) {
				return true;
			}
			if(this._coefficient==0&&m2._coefficient==0)
				return true;
			if (this._coefficient==m2._coefficient&&this._power==m2._power)
				return true;
		}
		else
			return false;
		return false;
	}
	//****************** Private Methods and Data *****************


	private void set_coefficient(double a)
	{
		this._coefficient = a;
	}
	private void set_power(int p) 
	{
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;
	@Override
	public function initFromString(String s) {
		function ans = new Monom(s);
		return ans;
	}
	@Override
	public function copy() {
		// TODO Auto-generated method stub
		function f = new Monom(this);
		return f;
	}


}
