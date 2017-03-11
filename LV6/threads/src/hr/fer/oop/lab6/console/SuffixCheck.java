package hr.fer.oop.lab6.console;

import java.io.IOException;
import java.io.PrintStream;

import hr.fer.oop.lab6.common.iface.Consumer;
import hr.fer.oop.lab6.common.iface.OutputMessage;
import hr.fer.oop.lab6.common.impl.Converter;

// TODO: Auto-generated Javadoc
/**
 * The Class SuffixCheck.
 */
public class SuffixCheck implements Consumer
{
	
	/** The pattern. */
	private byte[] pattern;
	
	/** The output. */
	private PrintStream output;
	
	/**
	 * Instantiates a new suffix check.
	 *
	 * @param pattern the pattern
	 * @param out the out
	 */
	public SuffixCheck(byte[] pattern, PrintStream out)
	{
		this.pattern = pattern;
		this.output = out;
	}

	/* (non-Javadoc)
	 * @see hr.fer.oop.lab6.common.iface.Consumer#evaluate(hr.fer.oop.lab6.common.iface.OutputMessage)
	 */
	@Override
	public void evaluate(OutputMessage out) 
	{
		out.reset();
		byte[] sazetak = null;
		byte[] message = null;
		try {
			sazetak = Converter.inputStreamToBytes(out.getOutput());
			message = Converter.inputStreamToBytes(out.getInputMessage().getStream());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		if (sazetak != null && sazetak.length >= pattern.length)
		{
			boolean match = true;
			for (int i = 0; i < pattern.length; i++)
			{
				if(pattern[pattern.length - i - 1] != sazetak[sazetak.length - i - 1])
				{
					match = false;
					break;
				}
			}
			if(match)
			{
				this.output.println(Converter.bytesToHexString(message) + 
						"=>" + Converter.bytesToHexString(sazetak));
			}
		}
		
	}

}
