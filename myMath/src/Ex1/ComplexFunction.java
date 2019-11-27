package Ex1;

public class ComplexFunction implements complex_function {
	function right;
	function left;
	Operation op;
	public ComplexFunction(function left)
	{
		this.left=left;
		this.op=null;
	}
	
	public ComplexFunction(String op, function left,function right)
	{
		if(right!=null) 
		{
			this.right = right;
		}
		this.left=left;
		switch (op.toLowerCase()) {
		case "plus":   this.op=Operation.Plus;
		break;
		case "times":  this.op=Operation.Times;
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
	public double f(double x) {
		/*if(this.right!=null) 
		{
			this.right = right;
		}*/
		switch (op.toString().toLowerCase()) {
	case "plus":   return this.right.f(x)+this.left.f(x);
	case "times":  return this.right.f(x)*this.left.f(x);
	case "divid":  return this.right.f(x) / this.left.f(x);
	case "max":	   
      if(this.right.f(x)>this.left.f(x)) 
      {
    	  return this.right.f(x);
      }
      else {
    	  return this.left.f(x); 
      }
	case "min":	   this.op=Operation.Min;
    if(this.right.f(x)<this.left.f(x)) 
    {
  	  return this.right.f(x);
    }
    else {
  	  return this.left.f(x); 
    }

	case "comp":   
		if(this.right!=null) {
			return this.right.f(this.left.f(x));
		}
		else 
		{
			this.left.f(x);      // to check if to throw error
		}
	case "none":	return this.left.f(x);
	default:    return this.right.f(x);       // to fix
		}
	}
	@Override
	public String toString() 
	{
		if(this.right==null) 
		{
			return this.left.toString();
		}
		String temp = this.op.toString()+"("+this.left.toString()+","+this.right.toString()+")";
		return temp;
	}

	@Override
	
	public function initFromString(String s) 
	{
		String temp = "";
		String op = "";
		int firstBrackt = s.indexOf('(');
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
			function left = new ComplexFunction(new Polynom(s));
			return left;
		}
	}
	private int findIndex(String s,int firstBrackt) 
	{
		int counterBrackt = 1;
		int counter2 = 0;
		String temp = "";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void plus(function f1) {
		if(this.right!=null) 
		{
				this.left = new ComplexFunction(this.op.toString(), this.left,this.right);
		}
		this.right=f1;
	}

	@Override
	public void mul(function f1) {
		if(this.right!=null) 
		{
				this.left = new ComplexFunction(this.op.toString(), this.left,this.right);
		}
		this.right=f1;
	}

	@Override
	public void div(function f1) {
		if(this.right!=null) 
		{
				this.left = new ComplexFunction(this.op.toString(), this.left,this.right);
		}
		this.right=f1;
	}

	@Override
	public void max(function f1) {
		if(this.right!=null) 
		{
				this.left = new ComplexFunction(this.op.toString(), this.left,this.right);
		}
		this.right=f1;
	}

	@Override
	public void min(function f1) {
		if(this.right!=null) 
		{
				this.left = new ComplexFunction(this.op.toString(), this.left,this.right);
		}
		this.right=f1;
	}

	@Override
	public void comp(function f1) {
		if(this.right!=null) 
		{
				this.left = new ComplexFunction(this.op.toString(), this.left,this.right);
		}
		this.right=f1;
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
		// TODO Auto-generated method stub
		return null;
	}

}