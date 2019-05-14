package hr.fer.oop.lab5.third;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import hr.fer.oop.lab5.first.MyByteWriter;

/**
 * This class extends MyByteWriter. It wrappes the given input stream to a buffered 
 * input stream to increase efficiency and it also creates a new file output stream that is then
 * wrapped by the mask stream to mask the read data and writes that data to the mask stream.
 * 
 * @author Luka
 *
 */

public class MyCriptByteWriter extends MyByteWriter {
	
	OutputStream os=null;
	BufferedInputStream bis=null;
	
	/**
	 * Constructs a new file output stream and a new buffered input stream using
	 * the given input stream and path
	 * 
	 * @param is input stream used to create buffered input stream
	 * @param path path used to create file output stream
	 * @throws FileNotFoundException
	 */
	
	public MyCriptByteWriter(InputStream is, Path path) throws FileNotFoundException {
		super(is, path);
		os=new FileOutputStream(path.toString());
		bis=new BufferedInputStream(is);
	}	
	
	/**
	 * This method uses a buffer of bytes to read the data from the buffered input stream.
	 * It then writes that data to the mask stream which actually xores all the bytes from 
	 * buffer to create a masked file.
	 */
	
	@Override
	public void run() throws IOException {
		int numByte=bis.available();
		byte[] buff=new byte[numByte];
		MaskStream ms=new MaskStream(os, (byte) 50);
		while(true) {
			int r=bis.read(buff);
			if(r<1) break;
			try {
				ms.write(buff);
			} finally {
				ms.close();
			}
		}
	}
}
