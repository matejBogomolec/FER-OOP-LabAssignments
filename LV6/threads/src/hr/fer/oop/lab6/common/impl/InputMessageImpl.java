package hr.fer.oop.lab6.common.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import hr.fer.oop.lab6.common.iface.InputMessage;

// TODO: Auto-generated Javadoc
/**
 * The Class InputMessageImpl.
 */
public class InputMessageImpl implements InputMessage
{
	
	/** The input. */
	private InputStream input;
	
	/**
	 * Instantiates a new input message impl.
	 *
	 * @param bytes the bytes
	 */
	public InputMessageImpl(byte[] bytes) 
	{
		input = new ByteArrayInputStream(bytes);
	}
	
	/* (non-Javadoc)
	 * @see hr.fer.oop.lab6.common.iface.InputMessage#getStream()
	 */
	@Override
	public InputStream getStream() 
	{
		return input;
	}

}
