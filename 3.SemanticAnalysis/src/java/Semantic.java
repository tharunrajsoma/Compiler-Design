package cool;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Semantic
{
	public String filename_holder ="h";
	private boolean errorFlag = false;
	public void reportError(String filename, int lineNo, String error)
	{
		errorFlag = true;
		System.err.println(filename+":"+lineNo+": "+error);
	}
	public boolean getErrorFlag()
	{
		return errorFlag;
	}

  /*
    Don't change code above this line
  */
	List<AST.feature> feature_list=new ArrayList<AST.feature>(30);
	List<AST.feature> feature_list11=new ArrayList<AST.feature>(30);
	List<AST.formal> formal_list=new ArrayList<AST.formal>(30);
	List<AST.class_> mylist=new ArrayList<AST.class_>();
	ScopeTable<String> st= new ScopeTable<String>();
	public Semantic(AST.program program)
	{
		//Write Semantic analyzer code here
		
		mylist = program.classes;		
		filename_holder = (mylist.get(0)).filename;
		HashMap<String , AST.class_> hashingmap = new HashMap<String , AST.class_>();
		//write sonmething which will check for the parent as IO , BOOL , STRING , 
		for (int i = 0 ; i < mylist.size() ; i++)
		{	
			List<AST.formal> use_formal_list=new ArrayList<AST.formal>();
			AST.expression use_expr= new AST.expression();
			AST.method now_method1 = new AST.method("init",use_formal_list ,"init" /*list */,use_expr ,1);
			AST.method now_method2= new AST.method("init",use_formal_list ,"init" /*list */,use_expr ,1);
			AST.method now_method3 = new AST.method("init",use_formal_list ,"init" /*list */,use_expr ,1);
			AST.method now_method4 = new AST.method("init",use_formal_list ,"init" /*list */,use_expr ,1);
			AST.attr now_attr = new AST.attr("init","init",use_expr,1) ;
			//if(temp instanceof AST.method)
			//{

				// now_method = (AST.method)temp;
			 	if( ((mylist.get(i)).parent).compareTo("IO") == 0)
				{
						AST.formal use_formal_list11=new AST.formal("x","String",mylist.get(i).lineNo) ;
				//push the IO methods into the table!!
				now_method1.name = "out_string";
				now_method1.typeid ="SELF_TYPE";
				now_method1.formals.add(use_formal_list11);
				feature_list11.add(now_method1);


				AST.formal use_formal_list22=new AST.formal("x","Int",mylist.get(i).lineNo) ;
				now_method2.name = "out_int";
				now_method2.typeid ="SELF_TYPE";
				now_method2.formals.add(use_formal_list11);
				feature_list11.add(now_method2);  
				//use_formal_list11=new AST.formal("x","Int",mylist.get(i).lineNo) ;
				now_method3.name = "in_int";
				now_method3.typeid ="Int";
				feature_list11.add(now_method3);

				now_method4.name = "in_string";
				now_method4.typeid ="String";
				feature_list11.add(now_method4);
				
			
				//System.out.println("the complete feauture list is :" + feature_list);

				}
				else if(((mylist.get(i)).parent).compareTo ("Object") == 0)
				{	
				now_method1.name = "abort";
				now_method1.typeid ="Object";
				feature_list11.add(now_method1);

				now_method2.name = "type_name";
				now_method2.typeid ="String";
				feature_list11.add(now_method2);

				now_method3.name = "copy";
				now_method3.typeid ="SELF_TYPE";
				feature_list11.add(now_method3);
				
				}
				else if(((mylist.get(i)).parent).compareTo ("String") == 0)
				{
					//System.out.println("Iam inside the String");
				now_method1.name = "length";
				now_method1.typeid ="Int";
				feature_list11.add(now_method1);
				AST.formal use_formal_list11=new AST.formal("s","String",mylist.get(i).lineNo) ;
				now_method2.name = "concat";
				now_method2.typeid ="String";
				now_method2.formals.add(use_formal_list11);
				feature_list11.add(now_method2);
				
				now_method3.name = "substr";
				now_method3.typeid ="String";
				AST.formal use_formal_list22=new AST.formal("i","Int",mylist.get(i).lineNo) ;
				AST.formal use_formal_list33=new AST.formal("l","Int",mylist.get(i).lineNo) ;
				now_method3.formals.add(use_formal_list22);
				now_method3.formals.add(use_formal_list33);
				feature_list11.add(now_method3);
				}
				/*else
				{
					//do nothing , 
					
				}*/	
				 
			//}
			//else if(temp instanceof AST.attr)
			//{
				 //now_attr   = (AST.attr)temp; 	
				else if(((mylist.get(i)).parent).compareTo ("Int") == 0)
				{

					now_attr.name = "Int";
					feature_list11.add(now_attr);
				}
				
				else if(((mylist.get(i)).parent).compareTo ("Bool") == 0)
				{
					now_attr.name = "Bool";
					feature_list11.add(now_attr);
				}
			else
			{
				//do nothing
				
			}
		}
		AST.method use_tempory = (AST.method)feature_list11.get(3);
		//System.out.println("the complete feauture list is outside scenario:" + use_tempory.name);
		//add this feauture list to the class as some class defined as IO of no_type !!
		//System.out.println("the side of the list "+mylist.size());
		AST.class_ inserting_class = new AST.class_("IO",filename_holder,null,feature_list11,1);
		mylist.add(inserting_class);
		//System.out.println("the side of the list "+mylist.size());

		for (int i = 0;i<mylist.size();i++)
		{
		
			for(int j = 0;j < mylist.get(i).features.size();j++)
			{
				if(((mylist.get(i)).features.get(j)) instanceof AST.method)
				{
					AST.method iam_using ;
					iam_using = (AST.method)((mylist.get(i)).features.get(j));
					//System.out.println("This is method man :"+iam_using.name  +"  "+iam_using.typeid);
				}
				else{
					AST.attr iam_using_attr ;
					iam_using_attr =(AST.attr)((mylist.get(i)).features.get(j));
					//System.out.println("This is attr   man :"+iam_using_attr.name  +"  "+iam_using_attr.typeid);
				}


			}
		}



		for (int i = 0 ; i < mylist.size() ; i++)
		{
			if(i == 0)
			{
				hashingmap.put(mylist.get(i).name,mylist.get(i));
				//no need to cross check ! 
			}
			else
			{	
				if(hashingmap.containsKey((mylist.get(i)).name))
				{
					reportError((mylist.get(i)).filename ,(mylist.get(i)).lineNo ,"ERROR:CLASS ALREADY DECLARED ");
				}
				else if(hashingmap.containsKey((mylist.get(i)).parent))
				{
					//there is a key with the similar parent of the current class 
					//we have encountered the parent of some hash unit!!
					//we cross check if the parent of that hash unit is this?? if yes ... we need to pull this out as error!!
					int k = 0;

					//int sizer = hashingmap.size();
					AST.class_ alpha = hashingmap.get (mylist.get ( i ).parent ) ;
					for(int sizer =0;sizer < hashingmap.size();sizer++)
					{
						try
						{	
							if((alpha.parent).compareTo(mylist.get(i).name) == 0)
							{
								k = -1;
								reportError((mylist.get(i)).filename , (mylist.get(i)).lineNo ,"ERROR:Mutual inheritance Error!! ");
								break;
							}
							else  
							{
							//just map to the hashmap
							alpha = hashingmap.get(alpha.parent);
							//hashingmap.put(mylist.get(i).name,mylist.get(i));
							}
						}catch(NullPointerException e)
						{
						mylist.get(i).parent = "_no_parent";	
						}
					}
					if(k != -1)
					{
						hashingmap.put(mylist.get(i).name,mylist.get(i));
					}
				}
			
				//we can have same variable inherited from different 
				/*else if (hashingmap.containsKey((mylist.get(i)).name))
				{
					//we are in the dual hashing !! - eliminate the older one ... 
					reportError((mylist.get(i)).filename , (mylist.get(i)).lineNo ,"ERROR: Double Inheritance");
				}*/
				else
				{
					hashingmap.put(mylist.get(i).name,mylist.get(i));

				}
			}
		} 


		//Iterator<AST.class_> iterator=mylist.iterator();
		for(int i=0;i<mylist.size();i++)
		{
			//HashMap<String, Integer> cache = new HashMap<String, Integer>()
			
			feature_list=mylist.get(i).features;
			AST.feature feobj;
			st.enterScope();
			for(int j=0;j<feature_list.size();j++)
			{
				feobj=feature_list.get(j);
				
				AST.method mobj;
				AST.attr aobj;
				AST.expression eobj= new AST.expression();
				if(feobj instanceof AST.method)
				{	
					mobj = (AST.method)feobj;
					
					if(st.lookUpLocal(mobj.name) == null)
					{	//this a  new function ID , thus assuming to be a new function !!
						st.insert(mobj.name,mobj.typeid);
						//System.out.println("This is the new fucntion !!!");	
					}
					else
					{
							// there is already a function defined !!
							reportError(filename_holder,mobj.lineNo,"ERROR : THE FUNCTION ALREADY DECLARED!!");
					}
					
					formal_list=mobj.formals;
					for(int k=0;k<formal_list.size();k++)
					{
						
						st.insert(formal_list.get(k).name,formal_list.get(k).typeid);
					}
					eobj=mobj.body;
					st.enterScope();
					recexp(eobj);
					//st.exitScope();


				}
				else if(feobj instanceof AST.attr)
				{
					aobj = (AST.attr)feobj;
					
					if (st.lookUpLocal(aobj.name) == null )
					{

						st.insert(aobj.name,aobj.typeid);
						//System.out.println("the lookup value is "+st.lookUpLocal(aobj.name));	
					}
					else
					{
						reportError(filename_holder,aobj.lineNo,"ERROR : THE VARIABLE ALREADY DECLARED!!");
					}
					
					eobj=aobj.value;
					recexp(eobj);
					
				}	

				
			}
			//st.exitScope();

		}
	}
	public void recexp(AST.expression exobj)
  {
					////System.out.println("The current scope :" + st.scope);
     				if(exobj instanceof AST.assign)
				    {
				    	AST.assign eaobj=(AST.assign)exobj;
				    	
				    	recexp(eaobj.e1);
                        
				    	String type_of_ID = st.lookUpGlobal(eaobj.name);
				    	//there is a  possibility that the e1.type is nothing == null pointer exception mught raise!!
				    	
				      if(type_of_ID!=null)
				      {
				      	if((type_of_ID).compareTo(eaobj.e1.type) == 0 )
                {
                  
                  ////System.out.println("The types are :" + type_of_ID+"  =  " +eaobj.e1.type);
                  exobj.type = eaobj.e1.type;
                }
                else
                {
                  reportError(filename_holder,exobj.lineNo,"ERROR: IMPROPER MATCH IN ASSIGN");

                }
				      }
				      else
				      {
				      	reportError(filename_holder,exobj.lineNo,"ERROR: UNDECLARED VARIABLE");

				      }
				    	
				    }
				    
				    if(exobj instanceof AST.static_dispatch)
				    {

				    	//System.out.println(" calling a method of a class --- STATIC dispatch");

				    	AST.static_dispatch estobj =(AST.static_dispatch)exobj;
				    	// i need to check the expression to what ever it might be to the respective type and get the function going
				    	
				    	recexp(estobj.caller);
              //AST.expression handle_exp = estobj.caller ;
              //if this is an instance of ID then we can handle it directly by checking the name!! orelse we need to    
              // According to the order given this will be high priority means ,we need to focus on the info giving parts
              
              if ( estobj.caller instanceof AST.object )
              {
                AST.object handle_exp = (AST.object) estobj.caller ;
                for ( int i = 0; i < mylist.size(); i++ )
                {
                  for( int j = 0 ;j < mylist.get(i).features.size(); j++ )
                  {
                    if( mylist.get(i).features.get(j) instanceof AST.method)
                    {
                      AST.method temp_method_use = (AST.method)mylist.get(i).features.get(j);
                      if( ( temp_method_use.name).compareTo(handle_exp.name ) != 0  || 
                          ( temp_method_use.typeid).compareTo(handle_exp.type) !=0 )
                      {	
                        reportError(filename_holder ,mylist.get(i).lineNo ,"ERROR :  THIS CLASS IS NOT YET DEFINED");
                      }
                    }
                  }

                }
              }
                boolean found = false;
                boolean exp_found = false;
                for (int i = 0;i<mylist.size();i++)
                {	
                  for(int j = 0;j < mylist.get(i).features.size();j++)
                  {

                    if(((mylist.get(i)).features.get(j)) instanceof AST.method)
                    {	
				   	    			AST.method temp_method = (AST.method)((mylist.get(i)).features.get(j));
				   	    			if(((temp_method).name).compareTo(estobj.name) == 0)
				   	    			{
				   	    				found  = true;
				   	    				List<AST.expression> expression_list = new ArrayList<AST.expression>();
                        expression_list=estobj.actuals;
                        List <AST.formal> temp_formal_list = new ArrayList<AST.formal>();
                        temp_formal_list = temp_method.formals;
                        for(int k=0;k<expression_list.size();k++)
                        {
                          //sending the corresponding !!
                          recexp(expression_list.get(k));
                          //compare the type id's of the formal list and the expression list which is the argument of the function
                          if(((expression_list.get(k)).type).compareTo((temp_formal_list.get(k)).typeid) != 0)
                          {
                            exp_found = false;
                            reportError(filename_holder,exobj.lineNo,"ERROR: IMPROPER ARGUMENTS");
                            break;
                          }
                        }
					    				
				   	    			}
				   	    			else
				   	    			{
				   	    				found = false;
				   	    			}

				   	    		}
				   	    		else
				   	    		{
				   	    				//
				   	    				System.out.print("");
				   	    		}
				   	    		if(found == true)
                    {
                      break;
                    }
				   	    	}
				   	    	if(found == true)
				   	    	{
                    break;
				   	    	}
				   	    }
				   	   
                if(found == false)
                {
                  reportError(filename_holder,exobj.lineNo,"ERROR: THIS METHOD IS NOT YET DECLARED");
                }
				   	
            }
				   
				    if(exobj instanceof AST.dispatch)
				    {

				    	//System.out.println(" calling a method of a class --- dispatch");
				    	boolean found= false;
				    	boolean exp_found = false;
				   	  AST.dispatch edspobj =(AST.dispatch)exobj;
				   	    	//calling  of the function!!
				   	    //feature list probe must give u the exact i , through which you get the required formal list 
				   	    //now we need to compare the type id's of the list!!
              for (int i = 0;i<mylist.size();i++)
              {
                for(int j = 0;j < mylist.get(i).features.size();j++)
                {

                  if(((mylist.get(i)).features.get(j)) instanceof AST.method)
                  {	
                        AST.method temp_method = (AST.method)((mylist.get(i)).features.get(j));
                        if(((temp_method).name).compareTo(edspobj.name) == 0)
                        {
                          found  = true;
                          List<AST.expression> expression_list = new ArrayList<AST.expression>();
                          expression_list=edspobj.actuals;
                          List <AST.formal> temp_formal_list = new ArrayList<AST.formal>();
                          temp_formal_list = temp_method.formals;
                          for(int k=0;k<expression_list.size();k++)
                          {
                            //sending the corresonding !!
                            recexp(expression_list.get(k));
                            //compare the typeid'sof the formal list and the expression list which is the argument of the function
                            if(((expression_list.get(k)).type).compareTo((temp_formal_list.get(k)).typeid) != 0)
                            {
                              exp_found = false;
                              reportError(filename_holder,exobj.lineNo,"ERROR: IMPROPER ARGUMENTS");
                              break;
                            }
                          }
                        }
                        else
                        {
                          found = false;
                        }

                  }
                  else
                  {
                    System.out.print("");
                  }
                  if(found == true) 
                  {
                    break;
                  }
                }
                if(found == true)
                {
                  break;
                }
              }
				   	   
				   	 	if(found == false)
				   	 	{
				   	 		reportError(filename_holder,exobj.lineNo,"ERROR: THIS METHOD IS NOT YET DECLARED");
				   	 	}
				   	   
				    }
				   
				    if(exobj instanceof AST.cond)
				    {
				    	//condition checking (the must be some logical like = < > ! )
				   	    AST.cond econdobj =(AST.cond)exobj;
				   	    //predicate is must be  a comparison
				   	    recexp(econdobj.predicate);
				   	    //body will a normal expression body 
				   	    recexp(econdobj.ifbody);
				   	    //this is a normal else body
				   	    recexp(econdobj.elsebody);
				    }
            if(exobj instanceof AST.loop)
            {
                 AST.loop elpobj=(AST.loop)exobj;
                 //the logical statement that is to be used to check the while condition
                 recexp(elpobj.predicate);
                 //the normal expression set == block !!
                 recexp(elpobj.body);
            }
				    if(exobj instanceof AST.block)
				    { 
				   		st.enterScope();

				   	  AST.block eblkobj =(AST.block)exobj;
                       //list of expression!!
                       List<AST.expression> expression_list=new ArrayList<AST.expression>();
				      expression_list=eblkobj.l1;
				      for(int k=0;k<expression_list.size();k++)
					    {

					    	//each expression and its detailing !!
					    	recexp(expression_list.get(k));

				    	}
              //st.exitScope();
				    }
				    if(exobj instanceof AST.let)
				    {
              st.enterScope();
              //System.out.println("hello");
              AST.let elobj=(AST.let)exobj;
              st.insert(elobj.name,elobj.typeid);
              recexp(elobj.value);
              recexp(elobj.body);

              if(((elobj.value).type).compareTo("_no_type") ==0)
              {
                  
              }	
              else
              {
                if((elobj.value.type).compareTo(elobj.typeid) == 0)
                {
                    exobj.type = elobj.value.type;
                }
                else
                {
                    reportError(filename_holder,(elobj.value).lineNo,"ERROR: IMPROPER MATCH IN LET ");
                    //remove
                }
              }

			     	}
				    if(exobj instanceof AST.typcase)
             {
                 AST.typcase etypobj =(AST.typcase)exobj;
                 recexp(etypobj.predicate);
                 List<AST.branch> branch_list=new ArrayList<AST.branch>();

                 branch_list=etypobj.branches;
                 for(int k=0;k<branch_list.size();k++)
                {
                  //we need to checj the type id of the expr type !!
                  recexp(branch_list.get(k).value);

                }
             }
				   //as there will be a block when we are declaring the case
				   //no need to do and extra enter scope!!
				   if( exobj instanceof AST.new_ )
				   {
						AST.new_ enobj=(AST.new_)exobj;
						exobj.type = enobj.typeid;
				
						st.insert("new",enobj.typeid);

						////System.out.println(st.lookUpLocal(enobj.typeid));
     				}
				   if(exobj instanceof AST.isvoid)
				   {
				   		//
				   		AST.isvoid eisvdobj =(AST.isvoid)exobj;
				   		recexp(eisvdobj.e1);
				   	   
				   }
				   if(exobj instanceof AST.plus)
				   {
				   		
				   		AST.plus eplsobj=(AST.plus)exobj;
				   			recexp(eplsobj.e1);
				   	  		recexp(eplsobj.e2);

				   		if((eplsobj.e1.type).compareTo(eplsobj.e2.type) == 0)
				   		{
				   			
				   				//this is type checked and can be inserted into the looop
				   			exobj.type = eplsobj.e1.type;
				   		}
				   		else
				   		{
				   			//raise error and remove it from the scope table
				   			reportError(filename_holder,(eplsobj.e1).lineNo,"ERROR: IMPROPER MATCH IN PLUS ");
				   			//remove
				   		}				   	  	
				   	  		
				   }
				   if(exobj instanceof AST.sub)
				   {
				   	  AST.sub esubobj=(AST.sub)exobj;
				   	 
				   	  	recexp(esubobj.e1);
				   	  	recexp(esubobj.e2);
				   		if((esubobj.e1.type).compareTo(esubobj.e2.type) == 0)
				   		{
				   			
				   				//this is type checked and can be inserted into the loop
				   			exobj.type = esubobj.e1.type;
				   		}
				   		else
				   		{
				   			//raise error and remove it from the scope table
				   			reportError(filename_holder,(esubobj.e1).lineNo,"ERROR: IMPROPER MATCH IN SUB  ");
				   			//remove
				   		}
				   }
				   if(exobj instanceof AST.mul)
				   {
				   	  AST.mul emulobj=(AST.mul)exobj;
				   	  recexp(emulobj.e1);
				   	  recexp(emulobj.e2);
				   	  if((emulobj.e1.type).compareTo(emulobj.e2.type) == 0)
				   		{
				   			
				   				//this is type checked and can be inserted into the loop
				   			exobj.type = emulobj.e1.type;
				   		}
				   		else
				   		{
				   			//raise error and remove it from the scope table
				   			reportError(filename_holder,(emulobj.e1).lineNo,"ERROR: IMPROPER MATCH IN MULTIPLY ");
				   			//remove
				   		}
				   }
				   if(exobj instanceof AST.divide)
				   {
				   	  AST.divide edivobj=(AST.divide)exobj;
				   	  recexp(edivobj.e1);
				   	  recexp(edivobj.e2);
				   	  if((edivobj.e1.type).compareTo(edivobj.e2.type) == 0)
				   		{
				   			
				   				//this is type checked and can be inserted into the loop
				   			exobj.type = edivobj.e1.type;
				   		}
				   		else
				   		{
				   			//raise error and remove it from the scope table
				   			reportError(filename_holder,(edivobj.e1).lineNo,"ERROR: IMPROPER MATCH IN DIVIDE ");
				   			//remove
				   		}
				   }
				   if(exobj instanceof AST.neg)
				   {
				   	  AST.neg enegobj=(AST.neg)exobj;
				   	  recexp(enegobj.e1);
				   	  exobj.type = enegobj.e1.type;

				   }
				   if(exobj instanceof AST.lt)
				   {
				   	  AST.lt eltobj=(AST.lt)exobj;
				   	  recexp(eltobj.e1);
				   	  recexp(eltobj.e2);
				   	   if((eltobj.e1.type).compareTo(eltobj.e2.type) == 0)
				   		{
				   			
				   				//this is type checked and can be inserted into the looop
				   			exobj.type = eltobj.e1.type;
				   		}
				   		else
				   		{
				   			//raise error and remove it from the scope table
				   			reportError(filename_holder,(eltobj.e1).lineNo,"ERROR: IMPROPER MATCH IN LESS THAN");
				   			//remove
				   		}
				   }
				   if(exobj instanceof AST.leq)
				   {
				   	  AST.leq eleqobj=(AST.leq)exobj;
				   	  recexp(eleqobj.e1);
				   	  recexp(eleqobj.e2);
				   	  if((eleqobj.e1.type).compareTo(eleqobj.e2.type) == 0)
				   		{
				   			
				   				//this is type checked and can be inserted into the looop
				   			exobj.type = eleqobj.e1.type;
				   		}
				   		else
				   		{
				   			//raise error and remove it from the scope table
				   			reportError(filename_holder,(eleqobj.e1).lineNo,"ERROR: IMPROPER MATCH IN LESS THAN EQUAL");
				   			//remove
				   		}

				   }
				   if(exobj instanceof AST.eq)
				   {
				   	  AST.eq eeqobj=(AST.eq)exobj;
				   	  recexp(eeqobj.e1);
				   	  recexp(eeqobj.e2);
				   	  if((eeqobj.e1.type).compareTo(eeqobj.e2.type) == 0)
				   		{
				   			
				   				//this is type checked and can be inserted into the looop
				   			exobj.type = eeqobj.e1.type;
				   		}
				   		else
				   		{
				   			//raise error and remove it from the scope table
				   			reportError(filename_holder,(eeqobj.e1).lineNo,"ERROR: IMPROPER MATCH IN EQUAL");
				   			//remove
				   		}
				   }
				   if(exobj instanceof AST.comp)
				   {
				   	  AST.comp ecompobj=(AST.comp)exobj;
				   	  recexp(ecompobj.e1);
				   	  exobj.type = ecompobj.e1.type;
				   }
				   if(exobj instanceof AST.object)
				   {
				   		
				    	AST.object eobobj=(AST.object)exobj;
				    	if(st.lookUpGlobal(eobobj.name) == null)
				    	{
				    		//error , because we did not declare and using it here
				    		reportError(filename_holder,eobobj.lineNo,"ERROR: USAGE OF ATTRIBUTE(ID) WITHOUT DECLARATION");
				    	}
				    	else
				    	{
				    		
				        	st.insert(eobobj.name,st.lookUpGlobal(eobobj.name));
				        	eobobj.type = st.lookUpGlobal(eobobj.name);
				    	}
				   }
				   if(exobj instanceof AST.int_const)
				   {
				   	    exobj.type="Int";
				   }
				   if(exobj instanceof AST.bool_const)
				   {
				   		exobj.type = "Bool";
				   }
				  if(exobj instanceof AST.string_const)
				  {
				  	 	exobj.type = "String";	
				  }
	}
}