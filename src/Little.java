// Generated from Little.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Little extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, FLOATLITERAL=2, INTLITERAL=3, STRINGLITERAL=4, OPERATOR=5, 
		IDENTIFIER=6, COMMENT=7, WHITESPACE=8, ERROR=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "CHAR", "ALNUM", "KEYWORD", "FLOATLITERAL", "INTLITERAL", "STRINGLITERAL", 
			"OPERATOR", "IDENTIFIER", "COMMENT", "WHITESPACE", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD", "FLOATLITERAL", "INTLITERAL", "STRINGLITERAL", "OPERATOR", 
			"IDENTIFIER", "COMMENT", "WHITESPACE", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public Little(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Little.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 11:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.exit(-1);
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\u00d4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\5\4\"\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5\u0081\n\5\3\6\6\6\u0084\n\6\r\6\16\6\u0085\3\6\3\6\7\6"+
		"\u008a\n\6\f\6\16\6\u008d\13\6\3\6\7\6\u0090\n\6\f\6\16\6\u0093\13\6\3"+
		"\6\3\6\6\6\u0097\n\6\r\6\16\6\u0098\5\6\u009b\n\6\3\7\6\7\u009e\n\7\r"+
		"\7\16\7\u009f\3\b\3\b\7\b\u00a4\n\b\f\b\16\b\u00a7\13\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00b5\n\t\3\n\3\n\7\n\u00b9\n\n"+
		"\f\n\16\n\u00bc\13\n\3\13\3\13\3\13\3\13\7\13\u00c2\n\13\f\13\16\13\u00c5"+
		"\13\13\3\13\3\13\3\13\3\13\3\f\6\f\u00cc\n\f\r\f\16\f\u00cd\3\f\3\f\3"+
		"\r\3\r\3\r\2\2\16\3\2\5\2\7\2\t\3\13\4\r\5\17\6\21\7\23\b\25\t\27\n\31"+
		"\13\3\2\t\3\2\62;\4\2C\\c|\3\2$$\6\2,-//\61\61??\6\2*+..=>@@\3\2\f\f\5"+
		"\2\13\f\17\17\"\"\2\u00f1\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\3\33\3\2\2\2\5\35\3\2\2\2\7!\3\2\2\2\t\u0080\3\2\2\2\13\u009a\3\2\2"+
		"\2\r\u009d\3\2\2\2\17\u00a1\3\2\2\2\21\u00b4\3\2\2\2\23\u00b6\3\2\2\2"+
		"\25\u00bd\3\2\2\2\27\u00cb\3\2\2\2\31\u00d1\3\2\2\2\33\34\t\2\2\2\34\4"+
		"\3\2\2\2\35\36\t\3\2\2\36\6\3\2\2\2\37\"\5\3\2\2 \"\5\5\3\2!\37\3\2\2"+
		"\2! \3\2\2\2\"\b\3\2\2\2#$\7R\2\2$%\7T\2\2%&\7Q\2\2&\'\7I\2\2\'(\7T\2"+
		"\2()\7C\2\2)\u0081\7O\2\2*+\7D\2\2+,\7G\2\2,-\7I\2\2-.\7K\2\2.\u0081\7"+
		"P\2\2/\60\7G\2\2\60\61\7P\2\2\61\u0081\7F\2\2\62\63\7H\2\2\63\64\7W\2"+
		"\2\64\65\7P\2\2\65\66\7E\2\2\66\67\7V\2\2\678\7K\2\289\7Q\2\29\u0081\7"+
		"P\2\2:;\7T\2\2;<\7G\2\2<=\7C\2\2=\u0081\7F\2\2>?\7Y\2\2?@\7T\2\2@A\7K"+
		"\2\2AB\7V\2\2B\u0081\7G\2\2CD\7K\2\2D\u0081\7H\2\2EF\7G\2\2FG\7N\2\2G"+
		"H\7U\2\2H\u0081\7G\2\2IJ\7G\2\2JK\7P\2\2KL\7F\2\2LM\7K\2\2M\u0081\7H\2"+
		"\2NO\7Y\2\2OP\7J\2\2PQ\7K\2\2QR\7N\2\2R\u0081\7G\2\2ST\7G\2\2TU\7P\2\2"+
		"UV\7F\2\2VW\7Y\2\2WX\7J\2\2XY\7K\2\2YZ\7N\2\2Z\u0081\7G\2\2[\\\7E\2\2"+
		"\\]\7Q\2\2]^\7P\2\2^_\7V\2\2_`\7K\2\2`a\7P\2\2ab\7W\2\2b\u0081\7G\2\2"+
		"cd\7D\2\2de\7T\2\2ef\7G\2\2fg\7C\2\2g\u0081\7M\2\2hi\7T\2\2ij\7G\2\2j"+
		"k\7V\2\2kl\7W\2\2lm\7T\2\2m\u0081\7P\2\2no\7K\2\2op\7P\2\2p\u0081\7V\2"+
		"\2qr\7X\2\2rs\7Q\2\2st\7K\2\2t\u0081\7F\2\2uv\7U\2\2vw\7V\2\2wx\7T\2\2"+
		"xy\7K\2\2yz\7P\2\2z\u0081\7I\2\2{|\7H\2\2|}\7N\2\2}~\7Q\2\2~\177\7C\2"+
		"\2\177\u0081\7V\2\2\u0080#\3\2\2\2\u0080*\3\2\2\2\u0080/\3\2\2\2\u0080"+
		"\62\3\2\2\2\u0080:\3\2\2\2\u0080>\3\2\2\2\u0080C\3\2\2\2\u0080E\3\2\2"+
		"\2\u0080I\3\2\2\2\u0080N\3\2\2\2\u0080S\3\2\2\2\u0080[\3\2\2\2\u0080c"+
		"\3\2\2\2\u0080h\3\2\2\2\u0080n\3\2\2\2\u0080q\3\2\2\2\u0080u\3\2\2\2\u0080"+
		"{\3\2\2\2\u0081\n\3\2\2\2\u0082\u0084\5\3\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u008b\7\60\2\2\u0088\u008a\5\3\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u009b\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008e\u0090\5\3\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0096\7\60\2\2\u0095\u0097\5\3\2\2\u0096"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\3\2\2\2\u009a\u0083\3\2\2\2\u009a\u0091\3\2\2\2\u009b"+
		"\f\3\2\2\2\u009c\u009e\5\3\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2"+
		"\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\16\3\2\2\2\u00a1\u00a5"+
		"\7$\2\2\u00a2\u00a4\n\4\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a8\u00a9\7$\2\2\u00a9\20\3\2\2\2\u00aa\u00ab\7<\2\2\u00ab\u00b5"+
		"\7?\2\2\u00ac\u00b5\t\5\2\2\u00ad\u00ae\7#\2\2\u00ae\u00b5\7?\2\2\u00af"+
		"\u00b5\t\6\2\2\u00b0\u00b1\7>\2\2\u00b1\u00b5\7?\2\2\u00b2\u00b3\7@\2"+
		"\2\u00b3\u00b5\7?\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00ad"+
		"\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\22\3\2\2\2\u00b6\u00ba\5\5\3\2\u00b7\u00b9\5\7\4\2\u00b8\u00b7\3\2\2"+
		"\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\24"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7/\2\2\u00be\u00bf\7/\2\2\u00bf"+
		"\u00c3\3\2\2\2\u00c0\u00c2\n\7\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c7\7\f\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b\13"+
		"\2\2\u00c9\26\3\2\2\2\u00ca\u00cc\t\b\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d0\b\f\2\2\u00d0\30\3\2\2\2\u00d1\u00d2\13\2\2\2\u00d2\u00d3\b\r\3"+
		"\2\u00d3\32\3\2\2\2\20\2!\u0080\u0085\u008b\u0091\u0098\u009a\u009f\u00a5"+
		"\u00b4\u00ba\u00c3\u00cd\4\b\2\2\3\r\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}