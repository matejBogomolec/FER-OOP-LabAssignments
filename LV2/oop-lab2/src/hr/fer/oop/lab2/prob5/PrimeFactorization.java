package hr.fer.oop.lab2.prob5;

public class PrimeFactorization 
{
	public static int nextprime(int x)
	{
		boolean isprime=true;
		do
		{
			for (int i=2; i<x; i++)
			{
				if (x%i==0)
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
	public static void main(String args[])
	{
		int n=Integer.parseInt(args[0]);
		int i=1;
		int prime=2;
		System.out.println("You requested decomposition of number " + n +  " into prime factors. Here they are:");
		do
		{
			if(n%prime==0)
			{
				System.out.println(i + ". " + prime);
				n/=prime;
				i++;
			}
			else
			{
				prime=nextprime(prime+1);
			}
			
		} while (n!=1);
	}
}
