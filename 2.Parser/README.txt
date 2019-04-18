# COOL Compiler #
                                                               PARSER README
	•  Code starts with program as the main block which is the list of classes.For this class_list is created which is properly intialized.
	• Whenever a new rule is written the approporiate key block that need to be matched to execute that list operation is written and then the task performed by it is wriitten.
	•  For this assignment I took a look of AST.java,CoolLexer.tokens files to  write rules in CoolParser.g4 to build AST.

AST.java:
         From this file various classes where taken and used for $value in the action part.For each class taken appropriate parameters required are passed.

CoolLexer.tokens :
                      Rules where written taking into consideration of all tokens defined in this file and make of use of those tokens symbols for every rule written.

Special Cases:
	1. Square brackets :
	It denotes one or zero time that term inside it so for this we wrote the same ruule two times with and without that term in square barcket. If there are two square brackets case in one line rule then four cases are possible.
	Ex: static_dispatch,dispatch classess have this case.
	2. Let: 
	In this parameters passed have expression value and expression body in it but when we actually observe the situation we see that what we pass is expression list.So here we write the recursive case for solving this situation.
	Where we divided entire list seen as expression value and expression body and proceeded.For the second repetiting expression we wrote code such that when it matches with comma the task will be done.
	3. Case:
	Here it expects list of branches as the parameters need to be passed so we created list of branches and did the required task.
	4. LPAREN expression RPAREN:
         It has no new action to be performed and nothing new to be created so we just passed the value returned by expression in it.

Errors observed: Null pointer exception is observed when the semantics of the rules is written is wrong.

Compilation: Get inside the parser folder and type “sudo make” for compilation.

Running: Now change the directory by typing “cd src/java” and type “./parser helloworld.cl”. Here “helloworld.cl” is a test case given