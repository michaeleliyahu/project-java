package Ex1;

public class ComplexFunction implements complex_function {
	function right;
	function left;
	Operation op;

	ComplexFunction(String op, function left,function right)
	{
		if(this.right!=null) 
		{
			this.right = right;
		}
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

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
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
				this.left = new ComplexFunction(this.op, this.left,this right);
		}
		this.right=f1;
	}

	@Override
	public void mul(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void div(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void max(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void min(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void comp(function f1) {
		// TODO Auto-generated method stub

	}

	@Override
	public function left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation getOp() {
		// TODO Auto-generated method stub
		return null;
	}

}
