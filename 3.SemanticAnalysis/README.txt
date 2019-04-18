# COOL Compiler #

                                              SEMANTIC ANALYSIS README
Inheritance:
	The inheritance problem here can be divided into two cases:
	• if it inherits IO /STRING/etc.. Whenever a class inherits something like IO we need to add all its methods to the mylist , thus we need to add the complete class of IO into the team for that we created a class_ object and similarly all the necessary methods inside it and made a class_ and we have added it into the myclass. thus whenever we see such methods. we wont see them as alien methods.
	• Mutual inheritance: We solved it by taking a hashmap , we save the deatails of the a value and the parent as a key value pair now do a lookup for the value and fetch the parent , and do a complete cycle so that at the end if we detect a cycle then we raise the error.
	
Naming and Scoping:
	• We get the input program as list of classes in which  we get each class and traverse until complete parsing of entire program is done.
	• Whenever a feature list or formal list or an expression is seen we enter into a new scope and insert the respective key and value pairs into the scopetable which contains list of hash maps.
	• Here whenever we get a member from list of members we assign it to an object and access it elements with this object.
	• Feature list:  It is a list of features derived from a class.Each feature can be a method or an attribute before traversing down the program we check whether it is a method or a attrubute by checking the feature object`s instance and doing the respective type casting for the feature object.
	• Method:  It is simply the method of a class initialization and each method is a collection of formal list and expressions.Here method object is used to send name and typeid as key and value to the hash map.
	•  Attribute:  It is simply the declaration of various global attributes with some initialization if provided.So whenever a feature object is type casted to this we send name and typeid into scope table.
	• Expression:  Expression can be of any style and each expression can have any number of expressions in it.So to deal with this we wrote a function to recurssively use it may times.Each time the respective work to enter the names,typeids to scope table is done.
	• Error Analysis:  It is an error to assign or use a variable which is not declared to resolve this problem we made use of LookUpGlobal() method in the ScopeTable.java file provided.

Type Checking:
  Whenever we assign a expression to an ID we check whether the type`s of both are same if not a error is reported and traversed further.

Procedure:
	• For assigned expression the expression function is called recursively until it reaches int_const or string_const or a bool_const and then it`s type is assigned to the called object.
	• If object ID is reached then we perform LookUpGlobal to get the object type.
	• Now it`s parent is assigned with the children`s type like this we traverse up until we reach called expression function is found.In this way we check the type matching.
	• Special Cases:  For static dispatch and dispatch which are respectively the method and function calls we check for the name and type matching for the function and method in the code and also the check number of parameters passed and their respective types to be matched properly.
  
Inheritance of IO: Some classes inherit IO class which will not be available in the code but we need to be able access the feature list of this class for that to happen we wrote special case with all methos of IO class as a seperate class.