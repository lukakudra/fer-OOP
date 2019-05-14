package hr.fer.oop.lab6.prvi;

import java.io.OutputStream;

/**
 * The class CustomOutputStream
 */

import javax.swing.JTextArea;

public class CustomOutputStream extends OutputStream {
	
	private JTextArea textArea;
	
	/**
	 * This constructor instantiates a new CustomOutputStream
	 * @param textArea textArea
	 */
	
	public CustomOutputStream(JTextArea textArea) {
		this.textArea=textArea;
	}
	
	public void write(int x) {
		//redirects data to the text area
		textArea.append(String.valueOf((char)x));
		//scrolls the text area to the end of data
		textArea.setCaretPosition(textArea.getDocument().getLength());
		
	}
}
