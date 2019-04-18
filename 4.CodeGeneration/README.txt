# COOL Compiler #
                                                                CODE GENERATION README
 
Description of various segments of the Code:
	We have been given the ast  tree as our input and from which our current codegen.java does the following activities.

Declaring all the classes and their parameters globally:
	We traverser through the complete tree , searching for the classes , now we measure the arguments of the given class and make the declaration accordingly.
 
Example :
 
	%class.A = type{ i32, %"class.std::__1::basic_string" }
 
For the existing cool code :
	class A inherits IO
	{
	    x:Int;
	    alph:String;
	};
 
Printing all the strings as Globally in IR:
	We have found all the string constant in the tree and pushed them into our hashmap and accordingly   named with an identification.
 
Example :
	@.str = private unnamed_addr constant [26 x i8] c"Enter two numbers to add\0A\00" , align1
	@.str1 = private unnamed_addr constant [24 x i8] c"The result:\0A\00" , align1
 
For the existing cool code:
	• out_string("Enter two numbers to add\n");
	• out_string("The result :\n");
	• We replace the “\n,\t,\r” by respective strings which cool adapts for itself.
 
Performing Arithmetic operations: 
	• For this we used assign,block,int_const,plus,minus,division,multiplication and object types in the expressions and whenever the codes sets itself to one of the those prinitng of IR code is done accordingly.
	• The allocation of space  is done first and then if there is any loading of the values and finally the values are stored in other registers.
	• In the process of memory allocation we use infinite number of registers.
	• We used eval_count to make the track of the resisters.
	• For “assign” respective type casting of strings and integers is done.
 
Loading :
	"  %"+eval_count+" = load i32* "+int_cnst.value+", align 4"
 
Storing :
	"  store i8 %"+bool1.value+", i8* %"+alpha.name+", align 1"
 
Final multiplication:
"  %"+eval_count+" = mul nsw i32 %"+(eval_count-2)+", %"+(eval_count-1)