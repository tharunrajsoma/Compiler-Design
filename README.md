# Compiler-Design
Compiler Design for Class Object Oriented Language (COOL)
- Designed and built a compiler for COOL (Class Object Oriented Language) where four phases of compiler design are done.
- These phases include Lexical Analysis, Parsing, Semantic Analysis and Code Generation.

### Lexical Analysis
- Lexical analysis is the first phase of a compiler. 
- It takes the modified source code from language preprocessors that are written in the form of sentences.
- The lexical analyzer breaks these syntaxes into a series of tokens, by removing any whitespace or comments in the source code.

- If the lexical analyzer finds a token invalid, it generates an error.The lexical analyzer works closely with the syntax analyzer.
- It reads character streams from the source code, checks for legal tokens, and passes the data to the syntax analyzer when it demands.

<p align="center">
<img src="https://www.tutorialspoint.com/compiler_design/images/token_passing.jpg">
</p>

### Parsing or Syntax Analysis
- Syntax analyzer recognizes “sentences” in the program using syntax of language.
- A syntax analyzer or parser takes the input from a lexical analyzer in the form of token streams. 
- The parser analyzes the source code (token stream) against the production rules to detect any errors in the code. The output of this phase is a parse tree.

### Semantic Analysis
- Semantics of a language provide meaning to its constructs, like tokens and syntax structure. 
- Semantics help interpret symbols, their types, and their relations with each other. 
- Semantic analysis judges whether the syntax structure constructed in the source program derives any meaning or not.

### Code Generation or Synthesis Phase

- Intermediate Code Generator generates “abstract” code.
- Code Optimizer optimizes the abstract code.
- The final Code Generator translates abstract intermediate code into specific machine instructions.

### Flow Chart for a Compiler

<p align="center">
<img src="https://cdncontribute.geeksforgeeks.org/wp-content/uploads/compilerDesign.jpg">
</p>

- Core Technologies used for this project: Jave, ANTLR, COOL Language.
