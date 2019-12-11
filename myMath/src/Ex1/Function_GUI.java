package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Function_GUI implements functions 
{
	ArrayList<function> arrF = new ArrayList<function>();
	@Override
	public boolean add(function arg0) {
		return arrF.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		return arrF.addAll(arg0);
	}

	@Override
	public void clear() {
		arrF.clear();		
	}

	@Override
	public boolean contains(Object arg0) {
		return arrF.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return arrF.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return arrF.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		Iterator<function> itr2 = arrF.iterator();
		return itr2;
	}

	@Override
	public boolean remove(Object arg0) {
		return arrF.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return arrF.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return arrF.retainAll(arg0);
	}

	@Override
	public int size() {
		return arrF.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return arrF.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return arrF.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException {
		{
			String line = "";
			try 
			{
				BufferedReader br = new BufferedReader(new FileReader(file));
				line = br.readLine();
				while (line!= null) 
				{
					line = line.substring(line.indexOf("f(x)=")+"f(x)=".length());
					line=line.replaceAll("\\s", "");
					ComplexFunction t = new ComplexFunction();
					arrF.add(t.initFromString(line));
					line = br.readLine();
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("could not read file");
			}
		}

	}
	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		double[] x =new double [resolution+1];
		double[][] y=new double[arrF.size()][resolution+1];

		StdDraw.setPenColor(Color.LIGHT_GRAY);	

		//vertical lines
		for (double i = rx.get_min() ; i <Math.abs(rx.get_max())+Math.abs(rx.get_min()); i++) 
		{
			StdDraw.line(rx.get_min()+i, ry.get_min(),rx.get_min()+i, ry.get_max());//vertical
		}

		//horizontal lines
		for (double i = ry.get_min() ; i <Math.abs(ry.get_max())+Math.abs(ry.get_min()); i++) 
		{
			StdDraw.line(rx.get_min(), ry.get_min()+i , rx.get_max(), ry.get_min()+i);//  
		}

		////////x axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min() ,0 , rx.get_max(),0);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 14));
		for (double i = rx.get_min(); i <=Math.abs(ry.get_max())+Math.abs(ry.get_min()); i++) {
			if(i == rx.get_min()) {
				StdDraw.text(i+0.3,-0.2 , Double.toString(i));
			}
			else 
			{
			StdDraw.text(i,-0.2 , Double.toString(i));
			}
		
		}
		////////y axis
		StdDraw.line(0,ry.get_min() , 0,ry.get_max());
		for (double i = ry.get_min(); i <=Math.abs(ry.get_max())+Math.abs(ry.get_min()); i++) {
			if(i == ry.get_min()) {
				StdDraw.text(0.3,i+0.2 , Double.toString(i));
			}
			else if(i == ry.get_max()) {
				StdDraw.text(0.3,i-0.2 , Double.toString(i));
			}
			
			else if(i!=0) 
			{
			StdDraw.text(0.3,i , Double.toString(i));
			}
		}
		
		
		//(Math.abs(rx.get_max())+Math.abs(rx.get_min()))/res;
		double x0 = rx.get_min();
		
		for (int i = 0; i < x.length ; i++) {		
			//x[i]=x0-1+(Math.abs(x0)+i)/10	;		
			x[i] = x0;
			x0=x0+(Math.abs(rx.get_max())+Math.abs(rx.get_min()))/resolution;
		}

		
		// make color randoms
		//get f.(x0)
		StdDraw.setPenColor(Color.RED);

		for (int i = 0; i < y.length; i++) 
		{
			for (int j = 0; j < y[i].length; j++) {
				
				y[i][j]= arrF.get(i).f(x[j]);
	
				if(j==0) 
				{
					StdDraw.line(rx.get_min(), ry.get_min(), x[j], y[i][j]);
				}
				else 
				{
					StdDraw.line(x[j-1], y[i][j-1], x[j], y[i][j]);
				}
				
			}	
		}
		

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

}
