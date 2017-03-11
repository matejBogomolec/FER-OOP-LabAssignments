package hr.fer.oop.lab6.common.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import hr.fer.oop.lab6.common.iface.InputMessage;
import hr.fer.oop.lab6.common.iface.OutputMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class OutputMessageImpl.
 */
public class OutputMessageImpl implements OutputMessage
{
	
	/** The input message. */
	private InputMessage inputMessage;
	
	/** The input stream. */
	private InputStream inputStream;
	
	/**
	 * Instantiates a new output message impl.
	 *
	 * @param inputMessage the input message
	 * @param sazetak the sazetak
	 */
	public OutputMessageImpl(InputMessage inputMessage, byte[] sazetak)
	{
		this.inputMessage = inputMessage;
		this.inputStream = new ByteArrayInputStream(sazetak);
	}
	
	/* (non-Javadoc)
	 * @see hr.fer.oop.lab6.common.iface.OutputMessage#getOutput()
	 */
	@Override
	public InputStream getOutput() 
	{
		return this.inputStream;
	}

	/* (non-Javadoc)
	 * @see hr.fer.oop.lab6.common.iface.OutputMessage#getInputMessage()
	 */
	@Override
	public InputMessage getInputMessage() 
	{
		return this.inputMessage;
	}

	/* (non-Javadoc)
	 * @see hr.fer.oop.lab6.common.iface.OutputMessage#reset()
	 */
	@Override
	public void reset() 
	{
		try 
		{
			inputMessage.getStream().reset();
			inputStream.reset();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
