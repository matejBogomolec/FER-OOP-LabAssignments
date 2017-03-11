package hr.fer.oop.lab6.common.impl;

import java.io.IOException;
import java.io.InputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class Converter.
 */
public class Converter 
{

	/**
	 * Input stream to bytes.
	 *
	 * @param stream the stream
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static synchronized byte[] inputStreamToBytes(InputStream stream) throws IOException 
	{
		 byte[] bytes = new byte[stream.available()];
		 stream.read(bytes, 0, bytes.length);
		return bytes;
	}
	
	/**
	 * Bytes to hex string.
	 *
	 * @param bytes the bytes
	 * @return the string
	 */
	public static synchronized String bytesToHexString(byte[] bytes)
	{
		StringBuilder hexString = new StringBuilder();
		for( int i = 0; i < bytes.length; i++)
		{
			if ((0xFF & bytes[i]) < 0x10)
			{
				hexString.append("0" + Integer.toHexString((0xFF & bytes[i])).toUpperCase());
			}
			else  hexString.append(Integer.toHexString(0xFF & bytes[i]).toUpperCase());
		}
		return hexString.toString();
	}

}
