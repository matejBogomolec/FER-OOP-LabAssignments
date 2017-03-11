package hr.fer.oop.lab2.prob3;
import java.lang.Math;
public class Roots 
{
	public static void main (String args[])
	{
		double rootre, rootim, i=0;
		double real = Double.parseDouble(args[0]);
		double imaginary = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		double absolute = Math.sqrt(Math.pow(real, 2)+Math.pow(imaginary, 2));
		double phi;
		if(Math.abs(real) < 1E-6) phi=Math.atan(imaginary/real)+(Math.PI/2);
		else phi = Math.atan(imaginary/real);
		double rootabs = Math.pow(absolute,1.0/n);
		System.out.println("You requested calculation of " + n + ". roots. Solutions are:");
		for(i = 0; i < n ; i++)
		{

			rootre = rootabs*Math.cos((phi+2*i*Math.PI)/n);
			rootim = rootabs*Math.sin((phi+2*i*Math.PI)/n);
			if(rootim < 1E-6) System.out.format("%.0f) %.2f %.2fi \n", i+1, rootre, rootim);
			else  System.out.format("%.0f) %.2f +%.2fi \n", i+1, rootre, rootim);
		}
	}
}
