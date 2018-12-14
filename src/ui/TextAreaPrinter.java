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
		try {
			textarea.getDocument().insertString(0, value + "\n", null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
