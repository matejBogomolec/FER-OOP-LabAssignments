package hr.fer.oop.lab6.common.impl;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import hr.fer.oop.lab6.common.iface.InputMessage;
import hr.fer.oop.lab6.common.iface.OutputMessage;
import hr.fer.oop.lab6.common.iface.Processor;

// TODO: Auto-generated Javadoc
/**
 * The Class MD5Digester.
 */
public class MD5Digester implements Processor
{

	/* (non-Javadoc)
	 * @see hr.fer.oop.lab6.common.iface.Processor#process(hr.fer.oop.lab6.common.iface.InputMessage)
	 */
	@Override
	public synchronized OutputMessage process(InputMessage input) 
	{
		MessageDigest digester = null;
		try 
		{
			digester = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		byte[] bytes = null;
		 try 
		 {
			bytes = Converter.inputStreamToBytes(input.getStream());
		} catch (IOException e) 
		 {
			e.printStackTrace();
		}
		 OutputMessage output = null;
		 if(bytes != null && bytes.length != 0)
		 {
			 digester.update(bytes);
			 byte[] hash = digester.digest();
			 output = new OutputMessageImpl(input, hash);
		 }
		 else System.out.println("Invalid bytes lenght is  invalid!");
		 return output;
	}

}
