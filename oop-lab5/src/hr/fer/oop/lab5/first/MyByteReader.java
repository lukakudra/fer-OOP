package hr.fer.oop.lab5.first;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * This class implements FileVisitor that is parameterized with Path to visit all 
 * directories and files from the given subtree. It then finds the txt files from 
 * all directories, reads them into a buffered input stream and then writes them
 * to buffered output stream. Variable level is used to move through the subtree.
 * 
 * @author Luka
 *
 */

public class MyByteReader implements FileVisitor<Path> {
	
	private BufferedOutputStream bos=null;
	int level=0;
	
	/**
	 * Constructor used to create the new buffered output stream 
	 * @param os output stream used to create the new buffered output stream
	 */
	
	public MyByteReader(OutputStream os) {
		bos=new BufferedOutputStream(os);
	}
	
	/**
	 * {@inheritDoc}
	 * Level decreases after every directory visit.
	 */

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		level--;
		return FileVisitResult.CONTINUE;
	}
	
	/**
	 * {@inheritDoc}
	 * Level increases before every directory visit.
	 */

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if (level == 0) {
            System.out.println(dir);
        } else {
            print(level, dir.getFileName().toString(), false);
        }
        level++;
		return FileVisitResult.CONTINUE;
	}
	
	/**
	 * {@inheritDoc}
	 * If the file is a txt file, this method creates the new file input stream and wrappes it into 
	 * a buffered input stream that reads the bytes into array of bytes called buffer. It then writes
	 * the data from that buffer to buffered output stream.
	 */

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(file.toString().endsWith(".txt")) {
			FileInputStream fis=new FileInputStream(file.toString());
			BufferedInputStream bis=new BufferedInputStream(fis);
			int numByte=bis.available();
			while(true) {
				byte[] buff=new byte[numByte];
				int r=bis.read(buff);
				if(r<1) break;
				bos.write(buff);
			}
			bis.close();
		}
		return FileVisitResult.CONTINUE;
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.err.println(exc.getMessage());
		return FileVisitResult.CONTINUE;
	}
	
	/**
	 * This method prints the data about the position in the subtree.
	 * 
	 * @param level level of the subtree
	 * @param name name of the directory
	 * @param isFile boolean variable that checks if the data is a file or not
	 */
	
	private void print(int level, String name, boolean isFile) {
        if (level != 0) {
            System.out.print("|");
        }
        for (int i = 0; i < level - 1; i++) {
            System.out.print(isFile ? " " : "-");
        }
        System.out.println(name);
    }
	
}
