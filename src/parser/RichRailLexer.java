package parser;// Generated from RichRail.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RichRailLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ID=12, NUMBER=13, WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "ID", "NUMBER", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'new'", "'train'", "'wagon'", "'numseats'", "'locomotive'", "'add'", 
		"'to'", "'getnumseats'", "'delete'", "'remove'", "'from'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "NUMBER", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public RichRailLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RichRail.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\7\rl\n\r\f\r\16\ro\13\r\3\16\6\16r\n\16\r\16\16\16s\3\17\6\17w\n\17"+
		"\r\17\16\17x\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\3\2\4\4\2\62;c|\4\2\13\f\"\"\2~\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5#\3\2\2\2\7)\3\2\2\2\t/\3\2"+
		"\2\2\138\3\2\2\2\rC\3\2\2\2\17G\3\2\2\2\21J\3\2\2\2\23V\3\2\2\2\25]\3"+
		"\2\2\2\27d\3\2\2\2\31i\3\2\2\2\33q\3\2\2\2\35v\3\2\2\2\37 \7p\2\2 !\7"+
		"g\2\2!\"\7y\2\2\"\4\3\2\2\2#$\7v\2\2$%\7t\2\2%&\7c\2\2&\'\7k\2\2\'(\7"+
		"p\2\2(\6\3\2\2\2)*\7y\2\2*+\7c\2\2+,\7i\2\2,-\7q\2\2-.\7p\2\2.\b\3\2\2"+
		"\2/\60\7p\2\2\60\61\7w\2\2\61\62\7o\2\2\62\63\7u\2\2\63\64\7g\2\2\64\65"+
		"\7c\2\2\65\66\7v\2\2\66\67\7u\2\2\67\n\3\2\2\289\7n\2\29:\7q\2\2:;\7e"+
		"\2\2;<\7q\2\2<=\7o\2\2=>\7q\2\2>?\7v\2\2?@\7k\2\2@A\7x\2\2AB\7g\2\2B\f"+
		"\3\2\2\2CD\7c\2\2DE\7f\2\2EF\7f\2\2F\16\3\2\2\2GH\7v\2\2HI\7q\2\2I\20"+
		"\3\2\2\2JK\7i\2\2KL\7g\2\2LM\7v\2\2MN\7p\2\2NO\7w\2\2OP\7o\2\2PQ\7u\2"+
		"\2QR\7g\2\2RS\7c\2\2ST\7v\2\2TU\7u\2\2U\22\3\2\2\2VW\7f\2\2WX\7g\2\2X"+
		"Y\7n\2\2YZ\7g\2\2Z[\7v\2\2[\\\7g\2\2\\\24\3\2\2\2]^\7t\2\2^_\7g\2\2_`"+
		"\7o\2\2`a\7q\2\2ab\7x\2\2bc\7g\2\2c\26\3\2\2\2de\7h\2\2ef\7t\2\2fg\7q"+
		"\2\2gh\7o\2\2h\30\3\2\2\2im\4c|\2jl\t\2\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2"+
		"\2\2mn\3\2\2\2n\32\3\2\2\2om\3\2\2\2pr\4\62;\2qp\3\2\2\2rs\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2t\34\3\2\2\2uw\t\3\2\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2x"+
		"y\3\2\2\2yz\3\2\2\2z{\b\17\2\2{\36\3\2\2\2\6\2msx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}