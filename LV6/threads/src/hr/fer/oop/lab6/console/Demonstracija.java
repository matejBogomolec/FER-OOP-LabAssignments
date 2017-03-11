package hr.fer.oop.lab6.console;

import hr.fer.oop.lab6.common.iface.Consumer;
import hr.fer.oop.lab6.common.iface.Generator;
import hr.fer.oop.lab6.common.iface.InputMessage;
import hr.fer.oop.lab6.common.iface.OutputMessage;
import hr.fer.oop.lab6.common.iface.Processor;
import hr.fer.oop.lab6.common.impl.MD5Digester;
import hr.fer.oop.lab6.common.impl.RandomStringGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class Demonstracija.
 */
public class Demonstracija
{
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) 
	{
		Generator g = new RandomStringGenerator();
		Processor p = new MD5Digester();
		Consumer c = new SuffixCheck(new byte[] { (byte)0xFE, (byte)0xFF },
		System.out);
		while(true) 
		{
			InputMessage msg1 = g.generateMessage();
			OutputMessage msg2 = p.process(msg1);
			c.evaluate(msg2);
		}
	}
}
