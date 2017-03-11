package hr.fer.oop.lab6.console;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import hr.fer.oop.lab6.common.iface.InputMessage;
import hr.fer.oop.lab6.common.iface.OutputMessage;
import hr.fer.oop.lab6.common.impl.MD5Digester;
import hr.fer.oop.lab6.common.impl.RandomStringGenerator;
import hr.fer.oop.lab6.threading.ConsumerThread;
import hr.fer.oop.lab6.threading.GeneratorThread;
import hr.fer.oop.lab6.threading.ProcessingThread;

// TODO: Auto-generated Javadoc
/**
 * The Class ParallelHashSearch.
 */
public class ParallelHashSearch {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) 
	{
		 BlockingQueue<InputMessage> inputQueue = new LinkedBlockingQueue<InputMessage>(7);
		 BlockingQueue<OutputMessage> outputQueue = new LinkedBlockingQueue<OutputMessage>(7);
		 GeneratorThread generator = new GeneratorThread(new RandomStringGenerator(), inputQueue);
		 ConsumerThread consumer = new ConsumerThread(new SuffixCheck(new byte[] { (byte)0xFE, (byte)0xFF }, System.out), outputQueue);
		 ProcessingThread procesor1 = new ProcessingThread(new MD5Digester(), inputQueue, outputQueue);
		 ProcessingThread procesor2 = new ProcessingThread(new MD5Digester(), inputQueue, outputQueue);
		 generator.start();
		 consumer.start();
		 procesor1.start();
		 procesor2.start();
		 while(true) { }
		 
	}

}
