package hr.fer.oop.lab6.common.iface;

import java.io.InputStream;

// TODO: Auto-generated Javadoc
/**
 * The Interface OutputMessage.
 */
public interface OutputMessage 
{
	
	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	InputStream getOutput();
	
	/**
	 * Gets the input message.
	 *
	 * @return the input message
	 */
	InputMessage getInputMessage();
	
	/**
	 * Reset.
	 */
	void reset();
}
