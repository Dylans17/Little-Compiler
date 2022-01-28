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
		IDENTIFIER=6, COMMENT=7, WHITESPACE=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "CHAR", "ALNUM", "KEYWORD", "FLOATLITERAL", "INTLITERAL", "STRINGLITERAL", 
			"OPERATOR", "IDENTIFIER", "COMMENT", "WHITESPACE"
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
			"IDENTIFIER", "COMMENT", "WHITESPACE"
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00cf\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\5\4 \n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\177\n\5\3\6\6\6\u0082\n\6\r\6\16\6\u0083\3\6\3\6\7\6\u0088\n\6\f\6"+
		"\16\6\u008b\13\6\3\6\7\6\u008e\n\6\f\6\16\6\u0091\13\6\3\6\3\6\6\6\u0095"+
		"\n\6\r\6\16\6\u0096\5\6\u0099\n\6\3\7\6\7\u009c\n\7\r\7\16\7\u009d\3\b"+
		"\3\b\7\b\u00a2\n\b\f\b\16\b\u00a5\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u00b3\n\t\3\n\3\n\7\n\u00b7\n\n\f\n\16\n\u00ba\13"+
		"\n\3\13\3\13\3\13\3\13\7\13\u00c0\n\13\f\13\16\13\u00c3\13\13\3\13\3\13"+
		"\3\13\3\13\3\f\6\f\u00ca\n\f\r\f\16\f\u00cb\3\f\3\f\2\2\r\3\2\5\2\7\2"+
		"\t\3\13\4\r\5\17\6\21\7\23\b\25\t\27\n\3\2\t\3\2\62;\4\2C\\c|\3\2$$\6"+
		"\2,-//\61\61??\6\2*+..=>@@\3\2\f\f\5\2\13\f\17\17\"\"\2\u00ec\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\37\3\2\2\2\t~\3\2"+
		"\2\2\13\u0098\3\2\2\2\r\u009b\3\2\2\2\17\u009f\3\2\2\2\21\u00b2\3\2\2"+
		"\2\23\u00b4\3\2\2\2\25\u00bb\3\2\2\2\27\u00c9\3\2\2\2\31\32\t\2\2\2\32"+
		"\4\3\2\2\2\33\34\t\3\2\2\34\6\3\2\2\2\35 \5\3\2\2\36 \5\5\3\2\37\35\3"+
		"\2\2\2\37\36\3\2\2\2 \b\3\2\2\2!\"\7R\2\2\"#\7T\2\2#$\7Q\2\2$%\7I\2\2"+
		"%&\7T\2\2&\'\7C\2\2\'\177\7O\2\2()\7D\2\2)*\7G\2\2*+\7I\2\2+,\7K\2\2,"+
		"\177\7P\2\2-.\7G\2\2./\7P\2\2/\177\7F\2\2\60\61\7H\2\2\61\62\7W\2\2\62"+
		"\63\7P\2\2\63\64\7E\2\2\64\65\7V\2\2\65\66\7K\2\2\66\67\7Q\2\2\67\177"+
		"\7P\2\289\7T\2\29:\7G\2\2:;\7C\2\2;\177\7F\2\2<=\7Y\2\2=>\7T\2\2>?\7K"+
		"\2\2?@\7V\2\2@\177\7G\2\2AB\7K\2\2B\177\7H\2\2CD\7G\2\2DE\7N\2\2EF\7U"+
		"\2\2F\177\7G\2\2GH\7G\2\2HI\7P\2\2IJ\7F\2\2JK\7K\2\2K\177\7H\2\2LM\7Y"+
		"\2\2MN\7J\2\2NO\7K\2\2OP\7N\2\2P\177\7G\2\2QR\7G\2\2RS\7P\2\2ST\7F\2\2"+
		"TU\7Y\2\2UV\7J\2\2VW\7K\2\2WX\7N\2\2X\177\7G\2\2YZ\7E\2\2Z[\7Q\2\2[\\"+
		"\7P\2\2\\]\7V\2\2]^\7K\2\2^_\7P\2\2_`\7W\2\2`\177\7G\2\2ab\7D\2\2bc\7"+
		"T\2\2cd\7G\2\2de\7C\2\2e\177\7M\2\2fg\7T\2\2gh\7G\2\2hi\7V\2\2ij\7W\2"+
		"\2jk\7T\2\2k\177\7P\2\2lm\7K\2\2mn\7P\2\2n\177\7V\2\2op\7X\2\2pq\7Q\2"+
		"\2qr\7K\2\2r\177\7F\2\2st\7U\2\2tu\7V\2\2uv\7T\2\2vw\7K\2\2wx\7P\2\2x"+
		"\177\7I\2\2yz\7H\2\2z{\7N\2\2{|\7Q\2\2|}\7C\2\2}\177\7V\2\2~!\3\2\2\2"+
		"~(\3\2\2\2~-\3\2\2\2~\60\3\2\2\2~8\3\2\2\2~<\3\2\2\2~A\3\2\2\2~C\3\2\2"+
		"\2~G\3\2\2\2~L\3\2\2\2~Q\3\2\2\2~Y\3\2\2\2~a\3\2\2\2~f\3\2\2\2~l\3\2\2"+
		"\2~o\3\2\2\2~s\3\2\2\2~y\3\2\2\2\177\n\3\2\2\2\u0080\u0082\5\3\2\2\u0081"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\u0089\13\2\2\2\u0086\u0088\5\3\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u0099\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\5\3\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\13\2\2\2\u0093"+
		"\u0095\5\3\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0081\3\2\2\2\u0098"+
		"\u008f\3\2\2\2\u0099\f\3\2\2\2\u009a\u009c\5\3\2\2\u009b\u009a\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\16"+
		"\3\2\2\2\u009f\u00a3\7$\2\2\u00a0\u00a2\n\4\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7$\2\2\u00a7\20\3\2\2\2\u00a8\u00a9"+
		"\7<\2\2\u00a9\u00b3\7?\2\2\u00aa\u00b3\t\5\2\2\u00ab\u00ac\7#\2\2\u00ac"+
		"\u00b3\7?\2\2\u00ad\u00b3\t\6\2\2\u00ae\u00af\7>\2\2\u00af\u00b3\7?\2"+
		"\2\u00b0\u00b1\7@\2\2\u00b1\u00b3\7?\2\2\u00b2\u00a8\3\2\2\2\u00b2\u00aa"+
		"\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\22\3\2\2\2\u00b4\u00b8\5\5\3\2\u00b5\u00b7\5\7\4"+
		"\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\24\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7/\2\2\u00bc"+
		"\u00bd\7/\2\2\u00bd\u00c1\3\2\2\2\u00be\u00c0\n\7\2\2\u00bf\u00be\3\2"+
		"\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7\f\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c7\b\13\2\2\u00c7\26\3\2\2\2\u00c8\u00ca\t\b\2\2\u00c9\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\b\f\2\2\u00ce\30\3\2\2\2\20\2\37~\u0083\u0089"+
		"\u008f\u0096\u0098\u009d\u00a3\u00b2\u00b8\u00c1\u00cb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}