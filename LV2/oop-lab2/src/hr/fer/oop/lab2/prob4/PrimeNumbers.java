package hr.fer.oop.lab2.prob4;

public class PrimeNumbers
{
	public static int nextprime(int x)
	{
		boolean isprime=true;
		do
		{
			for (int i = 2; i < x; i++)
			{
				if (x % i == 0)
				{
					isprime=false;
					break;
				}
				isprime=true;
			}
			if(!isprime) x++;
		} while(!isprime);
		return x;
	}
	public static void main (String args[])
	{
		int prime=1;
		int  n= Integer.parseInt(args[0]);
		System.out.println("You requested calculation of first " + n + " prime numbers. Here they are:");
		for(int i = 0; i < n; i++)
		{
			prime=nextprime(prime+1);
			System.out.println(i+1 + ". " + prime);
		}
	}

}
