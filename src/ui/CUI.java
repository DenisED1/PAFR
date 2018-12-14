package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class CUI extends JFrame implements ActionListener {

	private JTextField txtCommand;
	private JTextArea output;
	private JTextArea input;
	private JButton print;
	private JLabel lblOutput;
	private JLabel lblCommand;

	public CUI() {

		setLayout(null);
		input = new JTextArea();
		input.setBounds(10, 10, 300, 300);
		input.setEditable(false);
		add(input);

		lblOutput = new JLabel("Output: ");
		lblOutput.setBounds(320, 100, 100, 100);
		add(lblOutput);

		output = new JTextArea();
		output.setBounds(370, 10, 300, 300);
		output.setEditable(false);
		output.setBackground(Color.BLACK);
		output.setForeground(Color.WHITE);
		add(output);

		lblCommand = new JLabel("Command: ");
		lblCommand.setBounds(10, 280, 100, 100);
		add(lblCommand);

		txtCommand = new JTextField(5);
		txtCommand.setBounds(75, 320, 235, 20);
		add(txtCommand);

		print = new JButton("Execute");
		print.setBounds(320, 320, 100, 20);
		print.addActionListener(this);
		add(print);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == print) {
			try {
				input.getDocument().insertString(0, txtCommand.getText() + "\n", null);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		CUI me = new CUI();
		me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		me.setVisible(true);
		me.setLocation(400, 200);
		me.setSize(700, 400);
		me.setTitle("RichRail");
	}
}