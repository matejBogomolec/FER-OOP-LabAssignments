package hr.fer.oop.lab6.threading;

import java.util.concurrent.BlockingQueue;

import hr.fer.oop.lab6.common.iface.Consumer;
import hr.fer.oop.lab6.common.iface.OutputMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsumerThread.
 */
public class ConsumerThread extends Thread 
{
	
	/** The component. */
	private Consumer component;
	
	/** The output queue. */
	private BlockingQueue<OutputMessage> outputQueue;
	
	/**
	 * Instantiates a new consumer thread.
	 *
	 * @param component the component
	 * @param output the output
	 */
	public ConsumerThread(Consumer component, BlockingQueue<OutputMessage> output) 
	{
		this.component = component;
		this.outputQueue = output;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
    public void run() {
        while(true) {
            OutputMessage output = null;

            try {
                synchronized(ConsumerThread.class) {
                    output = outputQueue.take();
                }
            } catch (InterruptedException e) 
            {
            	e.printStackTrace();
            }
            if(output != null) {
                component.evaluate(output);
            }
        }
    }
}
