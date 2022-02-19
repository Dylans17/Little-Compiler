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
public class LittleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		KEYWORD=32, FLOATLITERAL=33, INTLITERAL=34, STRINGLITERAL=35, OPERATOR=36, 
		IDENTIFIER=37, COMMENT=38, WHITESPACE=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "DIGIT", "CHAR", 
			"ALNUM", "KEYWORD", "FLOATLITERAL", "INTLITERAL", "STRINGLITERAL", "OPERATOR", 
			"IDENTIFIER", "COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PROGRAM'", "'BEGIN'", "'END'", "'STRING'", "':='", "';'", "'FLOAT'", 
			"'INT'", "'VOID'", "','", "'FUNCTION'", "'('", "')'", "'READ'", "'WRITE'", 
			"'RETURN'", "'+'", "'-'", "'*'", "'/'", "'IF'", "'ENDIF'", "'ELSE'", 
			"'<'", "'>'", "'='", "'!='", "'<='", "'>='", "'WHILE'", "'ENDWHILE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "KEYWORD", "FLOATLITERAL", 
			"INTLITERAL", "STRINGLITERAL", "OPERATOR", "IDENTIFIER", "COMMENT", "WHITESPACE"
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


	public LittleLexer(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u018f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\5#\u00e0\n#\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u013f\n$\3%\6%"+
		"\u0142\n%\r%\16%\u0143\3%\3%\7%\u0148\n%\f%\16%\u014b\13%\3%\7%\u014e"+
		"\n%\f%\16%\u0151\13%\3%\3%\6%\u0155\n%\r%\16%\u0156\5%\u0159\n%\3&\6&"+
		"\u015c\n&\r&\16&\u015d\3\'\3\'\7\'\u0162\n\'\f\'\16\'\u0165\13\'\3\'\3"+
		"\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0173\n(\3)\3)\7)\u0177\n)\f)\16)"+
		"\u017a\13)\3*\3*\3*\3*\7*\u0180\n*\f*\16*\u0183\13*\3*\3*\3*\3*\3+\6+"+
		"\u018a\n+\r+\16+\u018b\3+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\2C\2E\2G\"I#K$M%O&Q\'S(U)\3\2\t"+
		"\3\2\62;\4\2C\\c|\3\2$$\6\2,-//\61\61??\6\2*+..=>@@\3\2\f\f\5\2\13\f\17"+
		"\17\"\"\2\u01ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2"+
		"\2\5_\3\2\2\2\7e\3\2\2\2\ti\3\2\2\2\13p\3\2\2\2\rs\3\2\2\2\17u\3\2\2\2"+
		"\21{\3\2\2\2\23\177\3\2\2\2\25\u0084\3\2\2\2\27\u0086\3\2\2\2\31\u008f"+
		"\3\2\2\2\33\u0091\3\2\2\2\35\u0093\3\2\2\2\37\u0098\3\2\2\2!\u009e\3\2"+
		"\2\2#\u00a5\3\2\2\2%\u00a7\3\2\2\2\'\u00a9\3\2\2\2)\u00ab\3\2\2\2+\u00ad"+
		"\3\2\2\2-\u00b0\3\2\2\2/\u00b6\3\2\2\2\61\u00bb\3\2\2\2\63\u00bd\3\2\2"+
		"\2\65\u00bf\3\2\2\2\67\u00c1\3\2\2\29\u00c4\3\2\2\2;\u00c7\3\2\2\2=\u00ca"+
		"\3\2\2\2?\u00d0\3\2\2\2A\u00d9\3\2\2\2C\u00db\3\2\2\2E\u00df\3\2\2\2G"+
		"\u013e\3\2\2\2I\u0158\3\2\2\2K\u015b\3\2\2\2M\u015f\3\2\2\2O\u0172\3\2"+
		"\2\2Q\u0174\3\2\2\2S\u017b\3\2\2\2U\u0189\3\2\2\2WX\7R\2\2XY\7T\2\2YZ"+
		"\7Q\2\2Z[\7I\2\2[\\\7T\2\2\\]\7C\2\2]^\7O\2\2^\4\3\2\2\2_`\7D\2\2`a\7"+
		"G\2\2ab\7I\2\2bc\7K\2\2cd\7P\2\2d\6\3\2\2\2ef\7G\2\2fg\7P\2\2gh\7F\2\2"+
		"h\b\3\2\2\2ij\7U\2\2jk\7V\2\2kl\7T\2\2lm\7K\2\2mn\7P\2\2no\7I\2\2o\n\3"+
		"\2\2\2pq\7<\2\2qr\7?\2\2r\f\3\2\2\2st\7=\2\2t\16\3\2\2\2uv\7H\2\2vw\7"+
		"N\2\2wx\7Q\2\2xy\7C\2\2yz\7V\2\2z\20\3\2\2\2{|\7K\2\2|}\7P\2\2}~\7V\2"+
		"\2~\22\3\2\2\2\177\u0080\7X\2\2\u0080\u0081\7Q\2\2\u0081\u0082\7K\2\2"+
		"\u0082\u0083\7F\2\2\u0083\24\3\2\2\2\u0084\u0085\7.\2\2\u0085\26\3\2\2"+
		"\2\u0086\u0087\7H\2\2\u0087\u0088\7W\2\2\u0088\u0089\7P\2\2\u0089\u008a"+
		"\7E\2\2\u008a\u008b\7V\2\2\u008b\u008c\7K\2\2\u008c\u008d\7Q\2\2\u008d"+
		"\u008e\7P\2\2\u008e\30\3\2\2\2\u008f\u0090\7*\2\2\u0090\32\3\2\2\2\u0091"+
		"\u0092\7+\2\2\u0092\34\3\2\2\2\u0093\u0094\7T\2\2\u0094\u0095\7G\2\2\u0095"+
		"\u0096\7C\2\2\u0096\u0097\7F\2\2\u0097\36\3\2\2\2\u0098\u0099\7Y\2\2\u0099"+
		"\u009a\7T\2\2\u009a\u009b\7K\2\2\u009b\u009c\7V\2\2\u009c\u009d\7G\2\2"+
		"\u009d \3\2\2\2\u009e\u009f\7T\2\2\u009f\u00a0\7G\2\2\u00a0\u00a1\7V\2"+
		"\2\u00a1\u00a2\7W\2\2\u00a2\u00a3\7T\2\2\u00a3\u00a4\7P\2\2\u00a4\"\3"+
		"\2\2\2\u00a5\u00a6\7-\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7/\2\2\u00a8&\3\2"+
		"\2\2\u00a9\u00aa\7,\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac*\3\2"+
		"\2\2\u00ad\u00ae\7K\2\2\u00ae\u00af\7H\2\2\u00af,\3\2\2\2\u00b0\u00b1"+
		"\7G\2\2\u00b1\u00b2\7P\2\2\u00b2\u00b3\7F\2\2\u00b3\u00b4\7K\2\2\u00b4"+
		"\u00b5\7H\2\2\u00b5.\3\2\2\2\u00b6\u00b7\7G\2\2\u00b7\u00b8\7N\2\2\u00b8"+
		"\u00b9\7U\2\2\u00b9\u00ba\7G\2\2\u00ba\60\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc"+
		"\62\3\2\2\2\u00bd\u00be\7@\2\2\u00be\64\3\2\2\2\u00bf\u00c0\7?\2\2\u00c0"+
		"\66\3\2\2\2\u00c1\u00c2\7#\2\2\u00c2\u00c3\7?\2\2\u00c38\3\2\2\2\u00c4"+
		"\u00c5\7>\2\2\u00c5\u00c6\7?\2\2\u00c6:\3\2\2\2\u00c7\u00c8\7@\2\2\u00c8"+
		"\u00c9\7?\2\2\u00c9<\3\2\2\2\u00ca\u00cb\7Y\2\2\u00cb\u00cc\7J\2\2\u00cc"+
		"\u00cd\7K\2\2\u00cd\u00ce\7N\2\2\u00ce\u00cf\7G\2\2\u00cf>\3\2\2\2\u00d0"+
		"\u00d1\7G\2\2\u00d1\u00d2\7P\2\2\u00d2\u00d3\7F\2\2\u00d3\u00d4\7Y\2\2"+
		"\u00d4\u00d5\7J\2\2\u00d5\u00d6\7K\2\2\u00d6\u00d7\7N\2\2\u00d7\u00d8"+
		"\7G\2\2\u00d8@\3\2\2\2\u00d9\u00da\t\2\2\2\u00daB\3\2\2\2\u00db\u00dc"+
		"\t\3\2\2\u00dcD\3\2\2\2\u00dd\u00e0\5A!\2\u00de\u00e0\5C\"\2\u00df\u00dd"+
		"\3\2\2\2\u00df\u00de\3\2\2\2\u00e0F\3\2\2\2\u00e1\u00e2\7R\2\2\u00e2\u00e3"+
		"\7T\2\2\u00e3\u00e4\7Q\2\2\u00e4\u00e5\7I\2\2\u00e5\u00e6\7T\2\2\u00e6"+
		"\u00e7\7C\2\2\u00e7\u013f\7O\2\2\u00e8\u00e9\7D\2\2\u00e9\u00ea\7G\2\2"+
		"\u00ea\u00eb\7I\2\2\u00eb\u00ec\7K\2\2\u00ec\u013f\7P\2\2\u00ed\u00ee"+
		"\7G\2\2\u00ee\u00ef\7P\2\2\u00ef\u013f\7F\2\2\u00f0\u00f1\7H\2\2\u00f1"+
		"\u00f2\7W\2\2\u00f2\u00f3\7P\2\2\u00f3\u00f4\7E\2\2\u00f4\u00f5\7V\2\2"+
		"\u00f5\u00f6\7K\2\2\u00f6\u00f7\7Q\2\2\u00f7\u013f\7P\2\2\u00f8\u00f9"+
		"\7T\2\2\u00f9\u00fa\7G\2\2\u00fa\u00fb\7C\2\2\u00fb\u013f\7F\2\2\u00fc"+
		"\u00fd\7Y\2\2\u00fd\u00fe\7T\2\2\u00fe\u00ff\7K\2\2\u00ff\u0100\7V\2\2"+
		"\u0100\u013f\7G\2\2\u0101\u0102\7K\2\2\u0102\u013f\7H\2\2\u0103\u0104"+
		"\7G\2\2\u0104\u0105\7N\2\2\u0105\u0106\7U\2\2\u0106\u013f\7G\2\2\u0107"+
		"\u0108\7G\2\2\u0108\u0109\7P\2\2\u0109\u010a\7F\2\2\u010a\u010b\7K\2\2"+
		"\u010b\u013f\7H\2\2\u010c\u010d\7Y\2\2\u010d\u010e\7J\2\2\u010e\u010f"+
		"\7K\2\2\u010f\u0110\7N\2\2\u0110\u013f\7G\2\2\u0111\u0112\7G\2\2\u0112"+
		"\u0113\7P\2\2\u0113\u0114\7F\2\2\u0114\u0115\7Y\2\2\u0115\u0116\7J\2\2"+
		"\u0116\u0117\7K\2\2\u0117\u0118\7N\2\2\u0118\u013f\7G\2\2\u0119\u011a"+
		"\7E\2\2\u011a\u011b\7Q\2\2\u011b\u011c\7P\2\2\u011c\u011d\7V\2\2\u011d"+
		"\u011e\7K\2\2\u011e\u011f\7P\2\2\u011f\u0120\7W\2\2\u0120\u013f\7G\2\2"+
		"\u0121\u0122\7D\2\2\u0122\u0123\7T\2\2\u0123\u0124\7G\2\2\u0124\u0125"+
		"\7C\2\2\u0125\u013f\7M\2\2\u0126\u0127\7T\2\2\u0127\u0128\7G\2\2\u0128"+
		"\u0129\7V\2\2\u0129\u012a\7W\2\2\u012a\u012b\7T\2\2\u012b\u013f\7P\2\2"+
		"\u012c\u012d\7K\2\2\u012d\u012e\7P\2\2\u012e\u013f\7V\2\2\u012f\u0130"+
		"\7X\2\2\u0130\u0131\7Q\2\2\u0131\u0132\7K\2\2\u0132\u013f\7F\2\2\u0133"+
		"\u0134\7U\2\2\u0134\u0135\7V\2\2\u0135\u0136\7T\2\2\u0136\u0137\7K\2\2"+
		"\u0137\u0138\7P\2\2\u0138\u013f\7I\2\2\u0139\u013a\7H\2\2\u013a\u013b"+
		"\7N\2\2\u013b\u013c\7Q\2\2\u013c\u013d\7C\2\2\u013d\u013f\7V\2\2\u013e"+
		"\u00e1\3\2\2\2\u013e\u00e8\3\2\2\2\u013e\u00ed\3\2\2\2\u013e\u00f0\3\2"+
		"\2\2\u013e\u00f8\3\2\2\2\u013e\u00fc\3\2\2\2\u013e\u0101\3\2\2\2\u013e"+
		"\u0103\3\2\2\2\u013e\u0107\3\2\2\2\u013e\u010c\3\2\2\2\u013e\u0111\3\2"+
		"\2\2\u013e\u0119\3\2\2\2\u013e\u0121\3\2\2\2\u013e\u0126\3\2\2\2\u013e"+
		"\u012c\3\2\2\2\u013e\u012f\3\2\2\2\u013e\u0133\3\2\2\2\u013e\u0139\3\2"+
		"\2\2\u013fH\3\2\2\2\u0140\u0142\5A!\2\u0141\u0140\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0149\7\60\2\2\u0146\u0148\5A!\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0159\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014e\5A!\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2"+
		"\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0152\u0154\7\60\2\2\u0153\u0155\5A!\2\u0154\u0153\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2"+
		"\2\2\u0158\u0141\3\2\2\2\u0158\u014f\3\2\2\2\u0159J\3\2\2\2\u015a\u015c"+
		"\5A!\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015eL\3\2\2\2\u015f\u0163\7$\2\2\u0160\u0162\n\4\2\2\u0161"+
		"\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2"+
		"\2\2\u0164\u0166\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0167\7$\2\2\u0167"+
		"N\3\2\2\2\u0168\u0169\7<\2\2\u0169\u0173\7?\2\2\u016a\u0173\t\5\2\2\u016b"+
		"\u016c\7#\2\2\u016c\u0173\7?\2\2\u016d\u0173\t\6\2\2\u016e\u016f\7>\2"+
		"\2\u016f\u0173\7?\2\2\u0170\u0171\7@\2\2\u0171\u0173\7?\2\2\u0172\u0168"+
		"\3\2\2\2\u0172\u016a\3\2\2\2\u0172\u016b\3\2\2\2\u0172\u016d\3\2\2\2\u0172"+
		"\u016e\3\2\2\2\u0172\u0170\3\2\2\2\u0173P\3\2\2\2\u0174\u0178\5C\"\2\u0175"+
		"\u0177\5E#\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2"+
		"\2\u0178\u0179\3\2\2\2\u0179R\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c"+
		"\7/\2\2\u017c\u017d\7/\2\2\u017d\u0181\3\2\2\2\u017e\u0180\n\7\2\2\u017f"+
		"\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2"+
		"\2\2\u0182\u0184\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0185\7\f\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0187\b*\2\2\u0187T\3\2\2\2\u0188\u018a\t\b\2\2\u0189"+
		"\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u018d\3\2\2\2\u018d\u018e\b+\2\2\u018eV\3\2\2\2\20\2\u00df"+
		"\u013e\u0143\u0149\u014f\u0156\u0158\u015d\u0163\u0172\u0178\u0181\u018b"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}