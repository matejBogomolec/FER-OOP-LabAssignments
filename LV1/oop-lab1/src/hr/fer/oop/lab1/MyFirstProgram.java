/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab1;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
/**
 *
 * @author Matej Bogomolec
 */
public class MyFirstProgram 
{
   public static void main(String[] args) 
   {
        System.out.println("Moj prvi program!");
        for (int i = 0; i < args.length; i++) 
        {
            int argN = i + 1;
            System.out.println("" + argN + ". argument programa = " + args[i]);
        }
        cluelessMethod(args);
        calculateStatistics(args);
   }
   public static void cluelessMethod(String[] args) 
   {
        String result = "";
        int step = 0;
        for (int i = 0; i < args.length; i++) 
        {
            step++;
            String arg = args[i];
            int argLength = arg.length();
            String upperCase = arg.toUpperCase();
            result += " " + arg;
        }  
        System.out.println("Argumenti programa su: " + result);
    }
   public static void calculateStatistics(String[] args) 
   {
	   DescriptiveStatistics statistics = new DescriptiveStatistics();
	   for (int i = 0; i < args.length; i++)
	   {
		   String arg = args[i];
		   int argLength = arg.length();
		   statistics.addValue(argLength);
	   }
	   System.out.println("Prosječna duljina znakova argumenata: "+ statistics.getMean());
	   System.out.println("MIN:" + statistics.getMin() + " MAX:" + statistics.getMax());
   }
   
}
