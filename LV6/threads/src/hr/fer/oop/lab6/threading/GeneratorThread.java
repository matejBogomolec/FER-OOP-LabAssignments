package hr.fer.oop.lab6.threading;

import java.util.concurrent.BlockingQueue;

import hr.fer.oop.lab6.common.iface.Generator;
import hr.fer.oop.lab6.common.iface.InputMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class GeneratorThread.
 */
public class GeneratorThread extends Thread 
{
	
	/** The generator. */
	private Generator generator;
	
	/** The input queue. */
	private BlockingQueue<InputMessage> inputQueue;
	
	/**
	 * Instantiates a new generator thread.
	 *
	 * @param component the component
	 * @param queue the queue
	 */
	public GeneratorThread(Generator component, BlockingQueue<InputMessage> queue)
	{
		this.generator = component;
		this.inputQueue = queue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	 public void run()
	 {
		while(true)
		{
			synchronized(GeneratorThread.class)
			{
				try 
				{
					inputQueue.put(generator.generateMessage());
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	 }
}
