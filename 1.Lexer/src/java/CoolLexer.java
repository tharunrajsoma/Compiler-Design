// Generated from CoolLexer.g4 by ANTLR 4.5
package cool;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, STR_EOF=43, STR_UN=44, WS=45, 
		COMMENT2=46, OPEN_C=47, UNMATCHED_C=48, EOF_T_1=49, NEXT_MODE_1=50, PRE_MODE_1=51, 
		COMMENT_1=52, EOF_T_2=53, EOF_END=54, NEXT_MODE_2=55, PRE_MODE_2=56, COMMENT_2=57;
	public static final int mode1 = 1;
	public static final int mode2 = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "mode1", "mode2"
	};

	public static final String[] ruleNames = {
		"STR_EOF", "STR_UN", "ERROR", "WS", "COMMENT2", "BOOL_CONST", "INT_CONST", 
		"STR_CONST", "LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", 
		"PLUS", "MINUS", "STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", 
		"DOT", "DARROW", "LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", 
		"LET", "LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "TYPEID", "OBJECTID", "OPEN_C", "UNMATCHED_C", "EOF_T_1", "NEXT_MODE_1", 
		"PRE_MODE_1", "COMMENT_1", "EOF_T_2", "EOF_END", "NEXT_MODE_2", "PRE_MODE_2", 
		"COMMENT_2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "STR_EOF", "STR_UN", "WS", "COMMENT2", "OPEN_C", "UNMATCHED_C", 
		"EOF_T_1", "NEXT_MODE_1", "PRE_MODE_1", "COMMENT_1", "EOF_T_2", "EOF_END", 
		"NEXT_MODE_2", "PRE_MODE_2", "COMMENT_2"
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



		/*
			YOU CAN ADD YOUR MEMBER VARIABLES AND METHODS HERE
		*/

		/**
		* Function to report errors.
		* Use this function whenever your lexer encounters any erroneous input
		* DO NOT EDIT THIS FUNCTION
		*/
		public void reportError(String errorString){               //to print error message in error token
			setText(errorString);
			setType(ERROR);
		}
		public void texting(String stringss){                      //For getting the changed string back to text
			setText(stringss);
			setType(STR_CONST);
		}
	        public void process() {                                      //For Invalid character 
	               
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
	                reportError(text);
	      }

		public void processString() {
	               int i=0,j=0;
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText(); 
			char[] ch = text.toCharArray();
			 while(i!=text.length())                      //comparing untill the i becomes text length
			 {

			   int k=(int)ch[i];
	                   if(k==0)                                   //For finding NULL character in a string
	                   {
	                     reportError("String contains null character");
	                     return;
	                   }
			   if(text.charAt(i)=='\\'&&text.charAt(i+1)=='0')        //For converting a "\0" into "0"
			   {
			   StringBuilder buf = new StringBuilder(text);
			   buf= buf.deleteCharAt(i);
			   text= new String(buf);
	                   texting(text);
			   }
			   if(text.charAt(i)=='\\'&&text.charAt(i+1)=='n')    //For converting a two character "\n" into one character "\n"
			   {
			   StringBuilder buf = new StringBuilder(text);
			   buf.setCharAt(i,'\n');
			   buf= buf.deleteCharAt(i+1);
	                   text= new String(buf);
	                   texting(text);
			   }
			   
			   i++;
			 }
	                if(text.length()>1024)                        //If string length is more than 1024
	                {
	                reportError("string constant is too long");
	                return;
	                }
	                texting(text);
		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			STR_EOF_action((RuleContext)_localctx, actionIndex);
			break;
		case 1:
			STR_UN_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 47:
			UNMATCHED_C_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			EOF_T_1_action((RuleContext)_localctx, actionIndex);
			break;
		case 52:
			EOF_T_2_action((RuleContext)_localctx, actionIndex);
			break;
		case 53:
			EOF_END_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STR_EOF_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			reportError("EOFinstringconstant");
			break;
		}
	}
	private void STR_UN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			reportError("Unterminate StringConst");
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			process();
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			processString();
			break;
		}
	}
	private void UNMATCHED_C_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			reportError("Unmatched *) ");
			break;
		}
	}
	private void EOF_T_1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			reportError("EOF in comment");
			break;
		}
	}
	private void EOF_T_2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			reportError("EOF in comment");
			break;
		}
	}
	private void EOF_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			reportError("EOF in comment");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u019d\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\u0083\n\2\f\2\16\2\u0086\13\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u0097\n\3"+
		"\f\3\16\3\u009a\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\6\5\u00a3\n\5\r\5\16"+
		"\5\u00a4\3\5\3\5\3\6\3\6\6\6\u00ab\n\6\r\6\16\6\u00ac\3\6\7\6\u00b0\n"+
		"\6\f\6\16\6\u00b3\13\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u00c2\n\7\3\b\6\b\u00c5\n\b\r\b\16\b\u00c6\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00d4\n\t\f\t\16\t\u00d7\13\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$"+
		"\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3("+
		"\3(\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3.\3.\7.\u0159\n.\f.\16.\u015c\13.\3/\3/\7/\u0160\n/\f/\16/\u0163"+
		"\13/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\38\38\38\38\38\38\39\39\39\39\39\39\3:\3:\3:\3:\6\u0084\u0098\u00b1\u00d5"+
		"\2;\5-\7.\t\3\13/\r\60\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16"+
		"!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33;\34=\35"+
		"?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]\4_\5a\61c\62e\63g\64i\65k\66m\67"+
		"o8q9s:u;\5\2\3\4\32\t\2\"#%.\60;>@B\\^^`\u0080\4\2\13\13^^\b\2##%)@A`"+
		"`bb~~\5\2\13\f\17\17\"\"\3\2\62;\4\2EEee\4\2NNnn\4\2CCcc\4\2UUuu\4\2G"+
		"Ggg\4\2HHhh\4\2KKkk\4\2PPpp\4\2JJjj\4\2TTtt\4\2VVvv\4\2QQqq\4\2RRrr\4"+
		"\2YYyy\4\2XXxx\4\2FFff\3\2C\\\6\2\62;C\\aac|\3\2c|\u01b3\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2"+
		"\2\3g\3\2\2\2\3i\3\2\2\2\3k\3\2\2\2\4m\3\2\2\2\4o\3\2\2\2\4q\3\2\2\2\4"+
		"s\3\2\2\2\4u\3\2\2\2\5w\3\2\2\2\7\u008b\3\2\2\2\t\u009e\3\2\2\2\13\u00a2"+
		"\3\2\2\2\r\u00aa\3\2\2\2\17\u00c1\3\2\2\2\21\u00c4\3\2\2\2\23\u00c8\3"+
		"\2\2\2\25\u00db\3\2\2\2\27\u00dd\3\2\2\2\31\u00df\3\2\2\2\33\u00e1\3\2"+
		"\2\2\35\u00e3\3\2\2\2\37\u00e5\3\2\2\2!\u00e7\3\2\2\2#\u00e9\3\2\2\2%"+
		"\u00eb\3\2\2\2\'\u00ed\3\2\2\2)\u00ef\3\2\2\2+\u00f1\3\2\2\2-\u00f3\3"+
		"\2\2\2/\u00f5\3\2\2\2\61\u00f7\3\2\2\2\63\u00f9\3\2\2\2\65\u00fb\3\2\2"+
		"\2\67\u00fe\3\2\2\29\u0101\3\2\2\2;\u0104\3\2\2\2=\u010a\3\2\2\2?\u010f"+
		"\3\2\2\2A\u0112\3\2\2\2C\u0115\3\2\2\2E\u0118\3\2\2\2G\u0121\3\2\2\2I"+
		"\u0125\3\2\2\2K\u012a\3\2\2\2M\u012f\3\2\2\2O\u0134\3\2\2\2Q\u013a\3\2"+
		"\2\2S\u013f\3\2\2\2U\u0144\3\2\2\2W\u0147\3\2\2\2Y\u014b\3\2\2\2[\u0152"+
		"\3\2\2\2]\u0156\3\2\2\2_\u015d\3\2\2\2a\u0164\3\2\2\2c\u016a\3\2\2\2e"+
		"\u016f\3\2\2\2g\u0173\3\2\2\2i\u0179\3\2\2\2k\u017f\3\2\2\2m\u0183\3\2"+
		"\2\2o\u0187\3\2\2\2q\u018d\3\2\2\2s\u0193\3\2\2\2u\u0199\3\2\2\2w\u0084"+
		"\7$\2\2xy\7^\2\2y\u0083\7$\2\2z{\7^\2\2{\u0083\7\f\2\2|\u0083\t\2\2\2"+
		"}~\7^\2\2~\u0083\7\13\2\2\177\u0080\7^\2\2\u0080\u0083\7p\2\2\u0081\u0083"+
		"\t\3\2\2\u0082x\3\2\2\2\u0082z\3\2\2\2\u0082|\3\2\2\2\u0082}\3\2\2\2\u0082"+
		"\177\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0085\3\2\2"+
		"\2\u0084\u0082\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088"+
		"\7\f\2\2\u0088\u0089\7\2\2\3\u0089\u008a\b\2\2\2\u008a\6\3\2\2\2\u008b"+
		"\u0098\7$\2\2\u008c\u008d\7^\2\2\u008d\u0097\7$\2\2\u008e\u008f\7^\2\2"+
		"\u008f\u0097\7\f\2\2\u0090\u0097\t\2\2\2\u0091\u0092\7^\2\2\u0092\u0097"+
		"\7\13\2\2\u0093\u0094\7^\2\2\u0094\u0097\7p\2\2\u0095\u0097\t\3\2\2\u0096"+
		"\u008c\3\2\2\2\u0096\u008e\3\2\2\2\u0096\u0090\3\2\2\2\u0096\u0091\3\2"+
		"\2\2\u0096\u0093\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009c\7\f\2\2\u009c\u009d\b\3\3\2\u009d\b\3\2\2\2\u009e\u009f"+
		"\t\4\2\2\u009f\u00a0\b\4\4\2\u00a0\n\3\2\2\2\u00a1\u00a3\t\5\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\5\5\2\u00a7\f\3\2\2\2\u00a8\u00a9"+
		"\7/\2\2\u00a9\u00ab\7/\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b1\3\2\2\2\u00ae\u00b0\13"+
		"\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7\f"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\6\5\2\u00b7\16\3\2\2\2\u00b8\u00b9"+
		"\7v\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7w\2\2\u00bb\u00c2\7g\2\2\u00bc"+
		"\u00bd\7h\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7u\2\2"+
		"\u00c0\u00c2\7g\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c2\20\3"+
		"\2\2\2\u00c3\u00c5\t\6\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\22\3\2\2\2\u00c8\u00d5\7$\2\2"+
		"\u00c9\u00ca\7^\2\2\u00ca\u00d4\7$\2\2\u00cb\u00cc\7^\2\2\u00cc\u00d4"+
		"\7\f\2\2\u00cd\u00d4\t\2\2\2\u00ce\u00cf\7^\2\2\u00cf\u00d4\7\13\2\2\u00d0"+
		"\u00d1\7^\2\2\u00d1\u00d4\7p\2\2\u00d2\u00d4\t\3\2\2\u00d3\u00c9\3\2\2"+
		"\2\u00d3\u00cb\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00d0"+
		"\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7$"+
		"\2\2\u00d9\u00da\b\t\6\2\u00da\24\3\2\2\2\u00db\u00dc\7*\2\2\u00dc\26"+
		"\3\2\2\2\u00dd\u00de\7+\2\2\u00de\30\3\2\2\2\u00df\u00e0\7<\2\2\u00e0"+
		"\32\3\2\2\2\u00e1\u00e2\7B\2\2\u00e2\34\3\2\2\2\u00e3\u00e4\7=\2\2\u00e4"+
		"\36\3\2\2\2\u00e5\u00e6\7.\2\2\u00e6 \3\2\2\2\u00e7\u00e8\7-\2\2\u00e8"+
		"\"\3\2\2\2\u00e9\u00ea\7/\2\2\u00ea$\3\2\2\2\u00eb\u00ec\7,\2\2\u00ec"+
		"&\3\2\2\2\u00ed\u00ee\7\61\2\2\u00ee(\3\2\2\2\u00ef\u00f0\7\u0080\2\2"+
		"\u00f0*\3\2\2\2\u00f1\u00f2\7>\2\2\u00f2,\3\2\2\2\u00f3\u00f4\7?\2\2\u00f4"+
		".\3\2\2\2\u00f5\u00f6\7}\2\2\u00f6\60\3\2\2\2\u00f7\u00f8\7\177\2\2\u00f8"+
		"\62\3\2\2\2\u00f9\u00fa\7\60\2\2\u00fa\64\3\2\2\2\u00fb\u00fc\7?\2\2\u00fc"+
		"\u00fd\7@\2\2\u00fd\66\3\2\2\2\u00fe\u00ff\7>\2\2\u00ff\u0100\7?\2\2\u0100"+
		"8\3\2\2\2\u0101\u0102\7>\2\2\u0102\u0103\7/\2\2\u0103:\3\2\2\2\u0104\u0105"+
		"\t\7\2\2\u0105\u0106\t\b\2\2\u0106\u0107\t\t\2\2\u0107\u0108\t\n\2\2\u0108"+
		"\u0109\t\n\2\2\u0109<\3\2\2\2\u010a\u010b\t\13\2\2\u010b\u010c\t\b\2\2"+
		"\u010c\u010d\t\n\2\2\u010d\u010e\t\13\2\2\u010e>\3\2\2\2\u010f\u0110\t"+
		"\f\2\2\u0110\u0111\t\r\2\2\u0111@\3\2\2\2\u0112\u0113\t\r\2\2\u0113\u0114"+
		"\t\f\2\2\u0114B\3\2\2\2\u0115\u0116\t\r\2\2\u0116\u0117\t\16\2\2\u0117"+
		"D\3\2\2\2\u0118\u0119\t\r\2\2\u0119\u011a\t\16\2\2\u011a\u011b\t\17\2"+
		"\2\u011b\u011c\t\13\2\2\u011c\u011d\t\20\2\2\u011d\u011e\t\r\2\2\u011e"+
		"\u011f\t\21\2\2\u011f\u0120\t\n\2\2\u0120F\3\2\2\2\u0121\u0122\t\b\2\2"+
		"\u0122\u0123\t\13\2\2\u0123\u0124\t\21\2\2\u0124H\3\2\2\2\u0125\u0126"+
		"\t\b\2\2\u0126\u0127\t\22\2\2\u0127\u0128\t\22\2\2\u0128\u0129\t\23\2"+
		"\2\u0129J\3\2\2\2\u012a\u012b\t\23\2\2\u012b\u012c\t\22\2\2\u012c\u012d"+
		"\t\22\2\2\u012d\u012e\t\b\2\2\u012eL\3\2\2\2\u012f\u0130\t\21\2\2\u0130"+
		"\u0131\t\17\2\2\u0131\u0132\t\13\2\2\u0132\u0133\t\16\2\2\u0133N\3\2\2"+
		"\2\u0134\u0135\t\24\2\2\u0135\u0136\t\17\2\2\u0136\u0137\t\r\2\2\u0137"+
		"\u0138\t\b\2\2\u0138\u0139\t\13\2\2\u0139P\3\2\2\2\u013a\u013b\t\7\2\2"+
		"\u013b\u013c\t\t\2\2\u013c\u013d\t\n\2\2\u013d\u013e\t\13\2\2\u013eR\3"+
		"\2\2\2\u013f\u0140\t\13\2\2\u0140\u0141\t\n\2\2\u0141\u0142\t\t\2\2\u0142"+
		"\u0143\t\7\2\2\u0143T\3\2\2\2\u0144\u0145\t\22\2\2\u0145\u0146\t\f\2\2"+
		"\u0146V\3\2\2\2\u0147\u0148\t\16\2\2\u0148\u0149\t\13\2\2\u0149\u014a"+
		"\t\24\2\2\u014aX\3\2\2\2\u014b\u014c\t\r\2\2\u014c\u014d\t\n\2\2\u014d"+
		"\u014e\t\25\2\2\u014e\u014f\t\22\2\2\u014f\u0150\t\r\2\2\u0150\u0151\t"+
		"\26\2\2\u0151Z\3\2\2\2\u0152\u0153\t\16\2\2\u0153\u0154\t\22\2\2\u0154"+
		"\u0155\t\21\2\2\u0155\\\3\2\2\2\u0156\u015a\t\27\2\2\u0157\u0159\t\30"+
		"\2\2\u0158\u0157\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015b^\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u0161\t\31\2\2"+
		"\u015e\u0160\t\30\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f"+
		"\3\2\2\2\u0161\u0162\3\2\2\2\u0162`\3\2\2\2\u0163\u0161\3\2\2\2\u0164"+
		"\u0165\7*\2\2\u0165\u0166\7,\2\2\u0166\u0167\3\2\2\2\u0167\u0168\b\60"+
		"\7\2\u0168\u0169\b\60\5\2\u0169b\3\2\2\2\u016a\u016b\7,\2\2\u016b\u016c"+
		"\7+\2\2\u016c\u016d\3\2\2\2\u016d\u016e\b\61\b\2\u016ed\3\2\2\2\u016f"+
		"\u0170\13\2\2\2\u0170\u0171\7\2\2\3\u0171\u0172\b\62\t\2\u0172f\3\2\2"+
		"\2\u0173\u0174\7*\2\2\u0174\u0175\7,\2\2\u0175\u0176\3\2\2\2\u0176\u0177"+
		"\b\63\n\2\u0177\u0178\b\63\5\2\u0178h\3\2\2\2\u0179\u017a\7,\2\2\u017a"+
		"\u017b\7+\2\2\u017b\u017c\3\2\2\2\u017c\u017d\b\64\13\2\u017d\u017e\b"+
		"\64\5\2\u017ej\3\2\2\2\u017f\u0180\13\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0182\b\65\5\2\u0182l\3\2\2\2\u0183\u0184\13\2\2\2\u0184\u0185\7\2\2"+
		"\3\u0185\u0186\b\66\f\2\u0186n\3\2\2\2\u0187\u0188\7,\2\2\u0188\u0189"+
		"\7+\2\2\u0189\u018a\3\2\2\2\u018a\u018b\7\2\2\3\u018b\u018c\b\67\r\2\u018c"+
		"p\3\2\2\2\u018d\u018e\7*\2\2\u018e\u018f\7,\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u0191\b8\n\2\u0191\u0192\b8\5\2\u0192r\3\2\2\2\u0193\u0194\7,\2\2\u0194"+
		"\u0195\7+\2\2\u0195\u0196\3\2\2\2\u0196\u0197\b9\13\2\u0197\u0198\b9\5"+
		"\2\u0198t\3\2\2\2\u0199\u019a\13\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c"+
		"\b:\5\2\u019cv\3\2\2\2\22\2\3\4\u0082\u0084\u0096\u0098\u00a4\u00ac\u00b1"+
		"\u00c1\u00c6\u00d3\u00d5\u015a\u0161\16\3\2\2\3\3\3\3\4\4\b\2\2\3\t\5"+
		"\7\3\2\3\61\6\3\62\7\7\4\2\6\2\2\3\66\b\3\67\t";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}