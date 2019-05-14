package hr.fer.oop.lab5.third;

import java.io.IOException;
import java.io.OutputStream;

/**
 * This class is used to mask the given output stream by xoring
 * the bytes with the given key.
 * 
 * @author Luka
 *
 */

public class MaskStream extends OutputStream {
	
	private OutputStream os=null;
	private byte key;
	
	/**
	 * Constructor for the new MaskStream
	 * @param os output stream
	 * @param key byte key
	 */
	
	public MaskStream(OutputStream os, byte key) {
		this.os=os;
		this.key=key;
	}
	
	/**
	 * {@inheritDoc}
	 * Overrides the standard write to xor the bytes with the
	 * given key and write that xored byte to the output stream.
	 */

	@Override
	public void write(int arg) throws IOException {
		byte xoredByte=(byte)(key ^ arg);
		os.write(xoredByte);
	}
	
	
}
