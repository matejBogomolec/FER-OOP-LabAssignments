package hr.fer.oop.lab2.zad1;
import java.util.Scanner;
/**
 * 
 * @author Matej Bogomolec
 * Program od korisnika traži dimenzije pojedine stranica trokute sve dok se ne upiše pozitivna vrijednost
 * te ispisuje opseg i površinu zadanog trokuta ili upozorava korisnika na pogrešan upis dimenzija
 * (zadane dimenzije stranica ne mogu stvorit trokut)
 * pretpostavlja se da je upis tipa double
 */
public class Triangle 
{
	/**
	 * 
	 * @param x = 1. stranica trokuta
	 * @param y = 2. stranica trokuta
	 * @param z = 3. stranica trokuta
	 * @return vraća true ako zadane stranice odgovaraju trokutu, a false ako ne
	 */
	public static boolean checkDim(double x, double y, double z)
	{
		if ((y + z) <= x)return false;
		else if((x + y) <= z) return false;
		else if((x + z) <= y) return false;
		else return true;
	}
	/**
	 * 
	 * @param args = prazni sring (nema argumenata)
	 */
	public static void main(String args[])
	{
		/**
		 * a,b,c = dimenzije trokuta
		 * surf = površina trokuta
		 * per = opseg trokuta
		 */
		Scanner scan = new Scanner(System.in);
		double a, b, c, surf, per;
		/**
		 * kontinuirani upis stranica trokuta sve dok njihov iznos bude veći od 0
		 */
		do
		{
			System.out.print("\nPlease provide first side of the triangle: ");
			a = scan.nextDouble();
			if(a < 1E-6)  System.out.println("The side must not be negative or zero.");
		} while (a < 1E-6);
		do
		{
			System.out.print("\nPlease provide second side of the triangle: ");
			b = scan.nextDouble();
			if(b < 1E-6)  System.out.println("The side must not be negative or zero.");
		} while (b < 1E-6);
		do
		{
			System.out.print("\nPlease provide third side of the triangle: ");
			c = scan.nextDouble();
			if(c < 1E-6)  System.out.println("The side must not be negative or zero.");
		} while (c < 1E-6);
		/**
		 * provjera upisanih dimenzija te ispis površine i opsega trokuta
		 */
		if(checkDim(a,b,c))
		{
			/**
			 * s = poluopseg zadanog trokuta
			 */
			double s = (a+b+c)/2.0;
			per = a+b+c;
			surf = Math.sqrt(s*((s-a)*(s-b)*(s-c)));
			System.out.format("The area of the triangle is %.2f and it's perimiter is %.2f \n", surf, per);
		}
		else System.out.println("Input sides can not make a triangle \n");
		scan.close();
	}
}
