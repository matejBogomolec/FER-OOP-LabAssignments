package hr.fer.oop.lab6.threading;

import java.util.concurrent.BlockingQueue;

import hr.fer.oop.lab6.common.iface.InputMessage;
import hr.fer.oop.lab6.common.iface.OutputMessage;
import hr.fer.oop.lab6.common.iface.Processor;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessingThread.
 */
public class ProcessingThread extends Thread 
{
	
	/** The processor. */
	private Processor processor;
	
	/** The input queue. */
	private BlockingQueue<InputMessage> inputQueue;
    
    /** The output queue. */
    private BlockingQueue<OutputMessage> outputQueue;
    
    /**
     * Instantiates a new processing thread.
     *
     * @param component the component
     * @param input the input
     * @param output the output
     */
    public  ProcessingThread(Processor component, BlockingQueue<InputMessage> input, BlockingQueue<OutputMessage> output)
    {
    	this.processor = component;
    	this.inputQueue = input;
    	this.outputQueue = output;
    }
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run()
	 {
		while(true)
		{
			InputMessage input = null;
			synchronized(ProcessingThread.class)
			{
				try 
				{
					input = inputQueue.take();
					outputQueue.put(processor.process(input));
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	 }
}
