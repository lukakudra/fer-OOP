package hr.fer.oop.lab5.first;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * This class writes the data from the given input stream to the created 
 * file output stream. Input stream is wrapped with buffered input stream 
 * to increase efficiency.
 * 
 * @author Luka
 *
 */

public class MyByteWriter {
	private BufferedInputStream bis;
	private FileOutputStream fos;
	
	
	/**
	 * Constructor for buffered input stream and file output stream
	 * 
	 * @param is input stream used to create buffered input stream
	 * @param path path used to create file output stream
	 * @throws FileNotFoundException
	 */
	
	public MyByteWriter(InputStream is, Path path) throws FileNotFoundException {
		bis=new BufferedInputStream(is);
		fos=new FileOutputStream(path.toString());
	}
	
	/**
	 * This method uses a buffer of bytes to read from the buffered input stream.
	 * Then it writes the data from that buffer of bytes to the file output stream
	 * @throws IOException
	 */
	
	public void run() throws IOException  {
		int numByte=bis.available();
		byte buff[]=new byte[numByte];
		while(true) {
			int r=bis.read(buff);
			if(r<1) break;
			try {
				fos.write(buff);
			} finally {
				fos.close();
			}
		}
	}
			
}
