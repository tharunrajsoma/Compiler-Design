# COOL Compiler #

                                                        LEXER README
	1. Initially I wrote the lexer rules for the tokens provided in CoolLexer.g4.
	2. Here while writing the rules I always took care such that regular expression are not in single quotation mark and rest of the them all are under single quotation mark.
	3. STRINGS:  Strings may contain any characters present on keyboard for this I wrote lexer rules such that it covers even “\n\t\'” it was done escaping the function of the character after back slash by inserting a back slash.I used the help of processString() function provided to  do error analysis related to Sting.
		a. java.lang.StringBuilder class was used to access each character in a string that was sent as input  through the proceessString() function.
		b.  In order to make my scanner convert escape characters in string constants to their correct values  I made use of  java.lang.StringBuilder.deleteCharAt() to delete a character('n') and java.lang.StringBuilder.setCharAt() to set character '\n' in please of '\'.
		c.  For sequence of two characters '\' and '0' when observed in the string need to be converted into single character '0' the same above mentioned methods where used to perform this task.
	4. ERROR HANDLING:
	  As my lexer shouldn`t print anything instead report the error to the parser.So i made use of reportError(“message”) to do the error analysis.
		a. When an invalid character($\'>!#%^&`|?) is encountered I returned error.
		b. If string contains an unescaped newline ‘‘Unterminated string constant’’ error is reported and it is done using regular expressions.
		c. If a string conatains NULL character in between then it returns error by converting the corresponding character into it`s ascii value and compare with '0'.
		d. In finding errors in comments I used push and pop modes using stack where every new comment beginning is pushed into stack and every ending comment is popped from the stack.
		e. If entire process of scanning the input is done if one beginning comment is more in the stack after EOF then it returns “EOF in comment” error.
		f. If we find '*)' outside a comment then stack contains and extra '*)' then error is returned.
	5. TEST CASES: My test cases will have all errors mentioned and return corresponding error messages and even testing the strings is done by including '/0' and '/n' in middle of the strings.