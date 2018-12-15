package ui;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class TextAreaPrinter implements OutputPrinter{

	private JTextArea textarea;
	private Logger logger = new Logger();
	
	public TextAreaPrinter(JTextArea textarea) {
		this.textarea = textarea;
	}
	
	@Override
	public void print(String value) {
			textarea.append(value + "\n");
			logger.print("output: " + value);
	}
}
