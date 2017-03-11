package hr.fer.oop.lab6.common.impl;

import java.util.Random;

import hr.fer.oop.lab6.common.iface.Generator;
import hr.fer.oop.lab6.common.iface.InputMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomStringGenerator.
 */
public class RandomStringGenerator implements Generator 
{
	
	/** The max. */
	private int min, max;
	
	/** The random. */
	private Random random = new Random ();
	
	/**
	 * Instantiates a new random string generator.
	 */
	public RandomStringGenerator()
	{
		this(20,30);
	}
	
	/**
	 * Instantiates a new random string generator.
	 *
	 * @param min the min
	 * @param max the max
	 */
	public RandomStringGenerator(int min, int max) 
	{
		this.max = max;
		this.min = min;
	}
	
	/* (non-Javadoc)
	 * @see hr.fer.oop.lab6.common.iface.Generator#generateMessage()
	 */
	@Override
	public synchronized InputMessage generateMessage() 
	{
		int bytesLenght = Math.abs(random.nextInt() % (max - min + 1) + min);
		byte[] bytes = new byte[bytesLenght];
		random.nextBytes(bytes);
		return new InputMessageImpl(bytes);
	}

}
