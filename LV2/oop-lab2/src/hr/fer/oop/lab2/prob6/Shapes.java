package hr.fer.oop.lab2.prob6;

public class Shapes 
{
	static void printline (int line)
	{
		switch (line)
		{
			case 0:
			{
				System.out.println("+--------+");
				break;
			}
			case 1:
			{
				System.out.println("\\        /");
				break;
			}
			case 2:
			{
				System.out.println(" \\______/");
				break;
			}
			case 3:
			{
				System.out.println("  ______");
				break;
			}
			case 4:
			{
				System.out.println(" /      \\");
				break;
			}
			default:
			{
				System.out.println("/        \\");
				break;
			}
		}
	}
	public static void main (String args[])
	{
		for (int i = 0; i < 19; i++)
		{
			if (i==0 || i==6 || i==14 || i==18) printline(0);
			else if(i==1 || i==10 || i==12) printline(1);
			else if(i==2 || i==11 || i==13) printline(2);
			else if(i==3 || i==7 || i==15) printline(3);
			else if(i==4 || i==8 || i==16) printline(4);
			else if(i==5 || i==9 || i==17) printline(5);
		}
	}
}
