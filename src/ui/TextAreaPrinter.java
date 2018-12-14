package ui;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class TextAreaPrinter implements OutputPrinter{

	private JTextArea textarea;
	
	public TextAreaPrinter(JTextArea textarea) {
		this.textarea = textarea;
	}
	
	@Override
	public void print(String value) {
			textarea.append(value + "\n");
	}
}
