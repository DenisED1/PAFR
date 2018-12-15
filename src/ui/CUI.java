package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.RichRailCommand;
import parser.RichRailLexer;
import parser.RichRailParser;

public class CUI extends JFrame implements ActionListener {

	private JTextField txtCommand;
	private JTextArea output;
	private JTextArea input;
	private JButton command;
	private JLabel lblOutput;
	private JLabel lblCommand;
	private JScrollPane inputScroll;
	private JScrollPane outputScroll;
	
	private static Logger logger = new Logger();

	public CUI() {

		setLayout(null);
		input = new JTextArea();
		inputScroll = new JScrollPane(input);
		inputScroll.setBounds(10, 10, 300, 300);
		input.setEditable(false);
		add(inputScroll);

		lblOutput = new JLabel("Output: ");
		lblOutput.setBounds(320, 100, 100, 100);
		add(lblOutput);

		output = new JTextArea();
		outputScroll = new JScrollPane(output);
		outputScroll.setBounds(370, 10, 300, 300);
		output.setEditable(false);
		output.setBackground(Color.BLACK);
		output.setForeground(Color.WHITE);
		add(outputScroll);

		lblCommand = new JLabel("Command: ");
		lblCommand.setBounds(10, 280, 100, 100);
		add(lblCommand);

		txtCommand = new JTextField(5);
		txtCommand.setBounds(75, 320, 235, 20);
		add(txtCommand);

		command = new JButton("Execute");
		command.setBounds(320, 320, 100, 20);
		command.addActionListener(this);
		add(command);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == command) {
			input.append(txtCommand.getText() + "\n");
			logger.print("input: " + txtCommand.getText());
			toParser(txtCommand.getText());
		}
	}

	public static void main(String[] args) {
		CUI me = new CUI();
		me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		me.setVisible(true);
		me.setSize(700, 400);
		me.setLocationRelativeTo(null);
		me.setTitle("RichRail");
		
		logger.createLogFile();
	}

	private void toParser(String command) {
		CharStream is = CharStreams.fromString(command);

		RichRailLexer lexer = new RichRailLexer(is);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create a parser that feeds off the tokens buffer
		RichRailParser parser = new RichRailParser(tokens);

		ParserRuleContext commandContext = parser.command();

		ParseTreeWalker walker = new ParseTreeWalker();
		OutputPrinter printer = new TextAreaPrinter(output);
		RichRailCommand listener = new RichRailCommand(printer);

		walker.walk(listener, commandContext);
	}

}