package hr.fer.oop.lab5.second;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements FileVisitor that is parameterized with Path to visit all 
 * directories and files from the given subtree. It then finds the txt files from all 
 * directories, reads using buffered reader, finds only articles (their name and price) and 
 * writes them in the collection. Collection that is used is tree set. Variable level is used
 * to move through the subtree.
 * 
 * @author Luka
 *
 */

public class MySecondByteReader implements FileVisitor<Path> {
	
	Set<Artikl> articles;
	int level=0;
	
	/**
	 * Constructor for the set of articles
	 */
	
	public MySecondByteReader() {
		articles = new TreeSet<>();
	}
	
	/**
	 * {@inheritDoc}
	 * Level decreases after every directoy visit.
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
	 * If the file is a txt file, this method creates a buffered reader to read from the given path.
	 * It then gets rid of the header and footer and splits all that is left between white spaces.
	 * These elements that are left are article's names and prices. It then writes those names and prices into 
	 * the newly created Artikl and then writes that Artikl in the collection. 
	 */

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if(file.toString().endsWith("txt")) {
			
			BufferedReader br=new BufferedReader(
				new InputStreamReader(
				new BufferedInputStream(
				new FileInputStream(file.toAbsolutePath().toString())), "UTF-8"));
			
			String line;
			String[] tmp;
			
			while(true) {
				line=br.readLine();
				if(line==null) break;
				
				
				if(line.length()==0 ||
				   line.startsWith(" ") ||
				   line.endsWith("---") ||
				   line.startsWith("Kupac") ||
				   line.startsWith("Račun") ||
				   line.startsWith("UKUPNO") ||
				   line.startsWith("Proizvod") ||
				   line.startsWith("---"))
				   continue;
			
				
				String name="";
				String price="";
				tmp=line.split("\\s+");
				
				price+=tmp[tmp.length-4];
				for(int i=0; i<tmp.length-4; i++) {
					name+=tmp[i]+" ";
				}			
	
				Artikl artikl=new Artikl(name, price);
				articles.add(artikl);
			}
			
			br.close();
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
