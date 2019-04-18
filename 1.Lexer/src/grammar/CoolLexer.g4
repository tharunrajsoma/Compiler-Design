lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,
	OBJECTID,
	BOOL_CONST,
	INT_CONST,
	STR_CONST,
	LPAREN,
	RPAREN,
	COLON,
	ATSYM,
	SEMICOLON,
	COMMA,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	TILDE,
	LT,
	EQUALS,
	LBRACE,
	RBRACE,
	DOT,
	DARROW,
	LE,
	ASSIGN,
	CLASS,
	ELSE,
	FI,
	IF,
	IN,
	INHERITS,
	LET,
	LOOP,
	POOL,
	THEN,
	WHILE,
	CASE,
	ESAC,
	OF,
	NEW,
	ISVOID,
	NOT
}

/*
  DO NOT EDIT CODE ABOVE THIS LINE
*/

@members{

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
}

/*
	WRITE ALL LEXER RULES BELOW
*/


STR_EOF:'"'('\\"'|'\\\n'|['\\'']|[a-zA-Z0-9_ !@~`#$%^&()-+=<>,./{}|]|'\\\t'|'\\n'|'\\'|'\t')*?'\n'EOF{reportError("EOFinstringconstant");};
STR_UN:'"'('\\"'|'\\\n'|['\\'']|[a-zA-Z0-9_ !@~`#$%^&()-+=<>,./{}|]|'\\\t'|'\\n'|'\\'|'\t')*?'\n'{reportError("Unterminate StringConst");};
ERROR       : [$\'>!#%^&`|?]{process();};      //calling a new method process for direct printing of that character
WS          : [ \t\n\r]+ -> skip;
COMMENT2    : ('--')+.*?'\n' ->skip;           //Single line comment skipping
BOOL_CONST  : 'true'|'false';
INT_CONST   : [0-9]+;
STR_CONST   :'"'('\\"'|'\\\n'|['\\'']|[a-zA-Z0-9_ !@~`#$%^&()-+=<>,./{}|]|'\\\t'|'\\n'|'\\'|'\t')*?'"'{processString();};
LPAREN      : '(';
RPAREN      : ')';
COLON	    : ':';
ATSYM       : '@';
SEMICOLON   : ';';
COMMA       : ',';
PLUS        : '+';
MINUS       : '-';
STAR	    : '*';
SLASH       : '/';
TILDE       : '~';
LT          : '<';
EQUALS      : '=';
LBRACE      : '{';
RBRACE      : '}';
DOT         : '.';
DARROW      : '=>';
LE          : '<=';
ASSIGN      : '<-';
CLASS       : [cC][lL][aA][sS][sS];
ELSE        : [eE][lL][sS][eE];
FI          : [fF][iI];
IF          : [iI][fF];
IN          : [iI][nN];
INHERITS    : [iI][nN][hH][eE][rR][iI][tT][sS];
LET         : [lL][eE][tT];
LOOP        : [lL][oO][oO][pP];
POOL        : [pP][oO][oO][lL];
THEN        : [tT][hH][eE][nN];
WHILE       : [wW][hH][iI][lL][eE];
CASE        : [cC][aA][sS][eE];
ESAC        : [eE][sS][aA][cC];
OF          : [oO][fF];
NEW         : [nN][eE][wW];
ISVOID      : [iI][sS][vV][oO][iI][dD];
NOT         : [nN][oO][tT];
TYPEID      : [A-Z][a-zA-Z0-9_]*;
OBJECTID    : [a-z][a-zA-Z0-9_]*;

/*Push and Pop modes for finding errors in comments*/

OPEN_C 		: '(*' ->pushMode(mode1),skip;									//multiline comment
UNMATCHED_C: '*)' {reportError("Unmatched *) ");};

mode mode1;
EOF_T_1: .(EOF) {reportError("EOF in comment");};
NEXT_MODE_1: '(*' -> pushMode(mode2),skip;
PRE_MODE_1: '*)' -> popMode,skip;
COMMENT_1 : . ->skip;

mode mode2;
EOF_T_2: .(EOF) {reportError("EOF in comment");};
EOF_END: '*)'(EOF){reportError("EOF in comment");};
NEXT_MODE_2: '(*' -> pushMode(mode2),skip;
PRE_MODE_2: '*)' -> popMode,skip;
COMMENT_2: . ->skip;

