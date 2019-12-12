package Ex1;

public class ComplexFunction implements complex_function {
	function right;
	function left;
	Operation op;
	public ComplexFunction(function left)
	{
		if(left==null)
		{
			throw new RuntimeException("left function cannot be null");
		}
		this.left=left;
		this.op=null;
	}
	public ComplexFunction()
	{
		this.left=null;
		this.right=null;
		this.op=null;
	}
	public ComplexFunction(String op, function left,function right)
	{
		if(right!=null) 
		{
			function rt = right.copy();
			this.right = rt;	
		}

		function lft = left.copy();
		this.left=lft;
		if(op==null)
		{
			throw new RuntimeException("invalid operation");
		}

		switch (op.toLowerCase()) {
		case "plus":   this.op=Operation.Plus;
		break;
		case "times":  this.op=Operation.Times;
		break;
		case "mul":  this.op=Operation.Times;
		break;
		case "div":  this.op=Operation.Divid;
		break;
		case "divid":  this.op=Operation.Divid;
		break;
		case "max":	   this.op=Operation.Max;
		break;
		case "min":	   this.op=Operation.Min;
		break;
		case "comp":    this.op=Operation.Comp;	
		break;
		case "none":	this.op=Operation.None;
		break;
		default:    this.op=Operation.Error;
		break;

		}
	}
	@Override
	public boolean equals (Object x) 
	{
		if(x instanceof Polynom )
		{
			Polynom a=(Polynom)x;
			int count = 0;
			for (int i = 1; i <= 10; i++) {
				if(this.f(i)==a.f(i))          
				{
					count++;
				}
				if (count>=8) {
					return true;
				}
			}
		}
		if(x instanceof Monom)
		{
			Monom b=(Monom)x;
			int count = 0;
			for (int i = 1; i <= 10; i++) {
				if(this.f(i)==b.f(i))          
				{
					count++;
				}
				if (count>=8) {
					return true;
				}
			}
		}
		if(x instanceof ComplexFunction)
		{
			int count = 0;
			ComplexFunction c=(ComplexFunction)x;
			for (int i = 1; i <= 10; i++) {
				if(this.f(i)==c.f(i))          
				{
					count++;
				}
				if (count>=8) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public double f(double x) {
		if(this.right==null) {
			return this.left.f(x);
		}
		switch (this.op.toString().toLowerCase()) {
		case "plus":   return right.f(x)+left.f(x);
		case "times":  return right.f(x)*left.f(x);
		case "divid":  return left.f(x) / right.f(x);
		case "max":	   
			if(right.f(x)>left.f(x)) 
			{
				return right.f(x);
			}
			else {
				return left.f(x); 
			}
		case "min":	   //this.op=Operation.Min;
			if(right.f(x)<left.f(x)) 
			{
				return right.f(x);
			}
			else {
				return left.f(x); 
			}

		case "comp":   
			if(right!=null) {
				return left.f(right.f(x));
			}
			else 
			{
				left.f(x);     
			}
		case "none":	return left.f(x);
		default:    return left.f(x);   
		}
	}
	@Override
	public String toString() 
	{
		String k = "";
		if(this.right==null) 
		{
			if(this.left==null) {
				return "Empty function!";
			}
			return this.left.toString();
		}
		k = checkOp();
		String temp = k+"("+this.left.toString()+","+this.right.toString()+")";
		return temp;
	}
	private String checkOp() {

		if(this.op==Operation.Plus) 
		{
			return "plus";
		}
		if(this.op==Operation.Times) 
		{
			return "mul";
		}
		if(this.op==Operation.Divid) 
		{
			return "div";
		}
		if(this.op==Operation.Max) 
		{
			return "max";
		}
		if(this.op==Operation.Min) 
		{
			return "min";
		}
		if(this.op==Operation.Comp) 
		{
			return "comp";
		}
		if(this.op==Operation.None) 
		{
			return "none";
		}
		if(this.op==Operation.Error) 
		{
			return "error";
		}
		return "error";

	}

	@Override

	public function initFromString(String s) 
	{
		String op = "";
		int firstBrackt = s.indexOf('(');

		boolean ans =countBrackets(s);
		if(ans == false) { throw new RuntimeException("invalid input"); }
		else {
			int last = s.lastIndexOf(',');
			if(firstBrackt!=-1) 
			{
				last=findIndex(s,firstBrackt); 	
				op = s.substring(0, firstBrackt);
				String tempRight = s.substring(last+1,s.length()-1);
				String tempLeft = s.substring(firstBrackt+1,last);
				function right = initFromString(tempRight);
				function left = initFromString(tempLeft);
				function x = new  ComplexFunction(op,left,right);
				return x;
			}
			else 
			{
				//function left = new ComplexFunction(new Polynom(s));
				function left = new Polynom(s);
				return left;
			}
		}
	}
	private boolean countBrackets(String s)
	{
		int open =0;
		int close =0;	
		int index = 0;	
		while(index<s.length())
		{
			if(s.charAt(index)=='(') 
			{
				open++;
			}
			if(s.charAt(index)==')') 
			{
				close++;
			}
			index++;
		}
		if(open==close)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	private int findIndex(String s,int firstBrackt) 
	{
		int counterBrackt = 1;
		int counter2 = 0;
		int i = firstBrackt+1;
		while( i<s.length() && counterBrackt!=counter2 ) 
		{
			if(s.charAt(i)=='(') 
			{
				counterBrackt++;
			}
			if (s.charAt(i)==',') 
			{
				counter2++;
			}
			i++;
		}
		return i-1;
	}
	@Override
	public function copy() {
		function temp = new ComplexFunction(this.checkOp() , this.left , this.right); 
		return temp;
	}

	@Override
	public void plus(function f1) {

		function f2 = f1.copy();
		if(this.right!=null) 
		{	
			function temp = new ComplexFunction(this.checkOp(),this.left,this.right);
			this.left=temp.copy();
		}
		this.right =f2.copy();
		this.op=Operation.Plus;
	}

	@Override
	public void mul(function f1) {
		function f2 = f1.copy();
		if(this.right!=null) 
		{	
			function temp = new ComplexFunction(this.checkOp(),this.left,this.right);
			this.left=temp.copy();
		}
		this.right =f2.copy();
		this.op=Operation.Times;
	}

	@Override
	public void div(function f1) {
		function f2 = f1.copy();
		if(this.right!=null) 
		{	
			function temp = new ComplexFunction(this.checkOp(),this.left,this.right);
			this.left=temp.copy();
		}
		this.right =f2.copy();
		this.op=Operation.Divid;
	}

	@Override
	public void max(function f1) {
		function f2 = f1.copy();
		if(this.right!=null) 
		{	
			function temp = new ComplexFunction(this.checkOp(),this.left,this.right);
			this.left=temp.copy();
		}
		this.right =f2.copy();
		this.op=Operation.Max;

	}

	@Override
	public void min(function f1) {
		function f2 = f1.copy();
		if(this.right!=null) 
		{	
			function temp = new ComplexFunction(this.checkOp(),this.left,this.right);
			this.left=temp.copy();
		}
		this.right =f2.copy();
		this.op=Operation.Min;

	}

	
	@Override
	public void comp(function f1) {      
		function f2 = f1.copy();
		if(this.right!=null) 
		{	
			function temp = new ComplexFunction(this.checkOp(),this.left,this.right);
			this.left=temp.copy();
		}
		this.right =f2.copy();
		this.op=Operation.Comp;
	}

	@Override
	public function left() {
		return this.left;
	}

	@Override
	public function right() {
		if(this.right!=null) 
		{
			return this.right;
		}
		return null;
	}

	@Override
	public Operation getOp() {
		return this.op;
	}

}
