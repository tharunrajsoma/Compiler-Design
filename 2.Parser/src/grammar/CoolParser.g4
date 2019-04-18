parser grammar CoolParser;

options {
    tokenVocab = CoolLexer;
}

@header{
    import cool.AST;
    import java.util.List;
}

@members{
    String filename;
    public void setFilename(String f){
        filename = f;
    }

/*
    DO NOT EDIT THE FILE ABOVE THIS LINE
    Add member functions, variables below.
*/

}

/*
    Add Grammar rules and appropriate actions for building AST below.
*/




program returns [AST.program value] : 
                        cl=class_list EOF 
                            {
                                $value = new AST.program($cl.value, $cl.value.get(0).lineNo);//task need to be done when matched with requirement
                            }
                    ;

class_list returns [List<AST.class_> value] //class_list to satisfy requirement of the list
                     
         @init{$value = new ArrayList<AST.class_>();} ://initializing the class list as list of classes
          (class1 SEMICOLON {$value.add($class1.value);})+;//execute only when this gets matched 

class1 returns [AST.class_  value]      :
                                                     CLASS tp1=TYPEID LBRACE f=feature_list RBRACE
                                                      {
   $value=new AST.class_($tp1.getText(),filename,"",$f.value,$tp1.getLine());  //empty string is passed to satisfy the parameter requirement

                                                      }
                                                      |
                                               CLASS tp1=TYPEID INHERITS tp2=TYPEID LBRACE f=feature_list RBRACE
                                                      {
   $value=new AST.class_($tp1.getText(),filename,$tp2.getText(),$f.value,$tp1.getLine());//passing all parameters to class_

                                                      }
                                         ;

feature_list returns [List<AST.feature> value]
                                 
          @init{$value = new ArrayList<AST.feature>();}:  //intializing the a new list of features
          (feature1 SEMICOLON {$value.add($feature1.value);})*;

feature1 returns[AST.feature value]      :
                                               ob1=OBJECTID LPAREN RPAREN COLON tp1=TYPEID LBRACE exp1=expr1 RBRACE   
                                               {
                                                           $value=new AST.method($ob1.getText(),new ArrayList<AST.formal>(),$tp1.getText(),$exp1.value,$ob1.getLine());
                                               }
                                               |
                                               ob1=OBJECTID LPAREN fo1=formal_main RPAREN COLON tp1=TYPEID LBRACE exp1=expr1 RBRACE     
                                               {
                                                           $value=new AST.method($ob1.getText(),$fo1.value,$tp1.getText(),$exp1.value,$ob1.getLine());
                                               }
                                               |
                                               ob2=OBJECTID COLON tp2=TYPEID 
                                               {
                                                          $value=new AST.attr($ob2.getText(),$tp2.getText(),new AST.expression(),$ob2.getLine()); //passing a empty new expression
                                               }
                                               |
                                               ob2=OBJECTID COLON tp2=TYPEID ASSIGN exp2=expr1
                                               {
                                                          $value=new AST.attr($ob2.getText(),$tp2.getText(),$exp2.value,$ob2.getLine());
                                               }
                                         ;

formal_main returns[List<AST.formal> value ]
        @init{$value=new ArrayList<AST.formal>();}:
            formal1{$value.add($formal1.value);} (COMMA formal1{$value.add($formal1.value);})*
                                               
                                     ;

formal_list returns [List<AST.formal> value] 
          @init{$value = new ArrayList<AST.formal>();}:
          (COMMA formal1{$value.add($formal1.value);})* ;
formal1 returns[AST.formal value]        :
                                              ob1=OBJECTID COLON tp1=TYPEID
                                              {
                                              $value=new AST.formal($ob1.getText(),$tp1.getText(),$ob1.getLine()); //action part
                                              }
                                ;
                                
expr1 returns[AST.expression value]           :  


                                            ob1=OBJECTID ASSIGN ex1=expr1 
                                            {
                                             $value =new AST.assign($ob1.getText(),$ex1.value,$ob1.getLine());
                                            }
                                            |
                                            ex2=expr1  DOT ob2=OBJECTID LPAREN RPAREN //4 possible cases
                                            {
                                             $value =new AST.static_dispatch($ex2.value,"",$ob2.getText(),new ArrayList<AST.expression>(),$ex2.value.lineNo); //by looking the parametres number a suitable class is used 
                                            }

                                            |
                                            ex2=expr1  DOT ob2=OBJECTID LPAREN exlm1=expr_list_main RPAREN 
                                            {
                                             $value =new AST.static_dispatch($ex2.value,"",$ob2.getText(),$exlm1.value,$ex2.value.lineNo);
                                            }
                                            |
                                            
                                            ex2=expr1 ATSYM tp1=TYPEID DOT ob2=OBJECTID LPAREN  RPAREN 
                                            {
                                             $value =new AST.static_dispatch($ex2.value,$tp1.getText(),$ob2.getText(),new ArrayList<AST.expression>(),$ex2.value.lineNo);
                                            }
                                            |
                                            
                                            ex2=expr1 ATSYM tp1=TYPEID DOT ob2=OBJECTID LPAREN exlm1=expr_list_main RPAREN 
                                            {
                                             $value =new AST.static_dispatch($ex2.value,$tp1.getText(),$ob2.getText(),$exlm1.value,$ex2.value.lineNo);
                                            }
                                        
                                            | 
                                            ob3=OBJECTID LPAREN RPAREN 
                                            {
                                             $value =new AST.dispatch(new AST.no_expr($ob3.getLine()),$ob3.getText(),new ArrayList<AST.expression>(),$ob3.getLine());
                                            }
                                            |
                                            ob3=OBJECTID LPAREN exl1=expr_list5 RPAREN 
                                            {
                                             $value =new AST.dispatch(new AST.no_expr($ob3.getLine()),$ob3.getText(),$exl1.value,$ob3.getLine());
                                            }
                                            
                                        
                                            | 
                                            IF ex3=expr1 THEN ex4=expr1 ELSE ex5=expr1 FI 
                                            {
                                             $value =new AST.cond($ex3.value,$ex4.value,$ex5.value,$ex3.value.lineNo);
                                            }
                                            
                                            | 
                                            WHILE ex6=expr1 LOOP ex7=expr1 POOL 
                                            {
                                             $value =new AST.loop($ex6.value,$ex7.value,$ex6.value.lineNo);
                                            }
                                            
                                            | 
                                            LBRACE exl2=expr_list2 RBRACE 
                                            {
                                             $value =new AST.block($exl2.value,$exl2.value.get(0).lineNo);
                                            }
                                        
                                            | 
                                          
                                            
                                            LET ob1=OBJECTID COLON tp1=TYPEID ASSIGN ex1=expr1 IN ex6=expr1  //if only assign expression case is present
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),$ex1.value,$ex6.value,$ob1.getLine());
                                            }
                                            |
                                            LET ob1=OBJECTID COLON tp1=TYPEID IN ex6=expr1 
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),new AST.expression(),$ex6.value,$ob1.getLine());
                                            }
                                            |
                                            LET ob1=OBJECTID COLON tp1=TYPEID ASSIGN ex33=expr1 COMMA exll=expr_list_let //when we consider second expression list
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),$ex33.value,$exll.value,$ob1.getLine());
                                            }
                                            |
                                            LET ob1=OBJECTID COLON tp1=TYPEID COMMA exll=expr_list_let 
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),new AST.expression(),$exll.value,$ob1.getLine());
                                            }
                                            |
                                            
                                            
                            
                                            CASE ex8=expr1 OF exl3=expr_list4 ESAC //it expects a list of branches as parameter
                                            {
                                             $value =new AST.typcase($ex8.value,$exl3.value,$ex8.value.lineNo);
                                            }
                                            
                                            | 
                                            
                                            NEW tp5=TYPEID
                                            {
                                             $value =new AST.new_($tp5.getText(),$tp5.getLine());
                                            } 

                                            | 
                                            ISVOID ex9=expr1 
                                            {
                                             $value =new AST.isvoid($ex9.value,$ex9.value.lineNo);
                                            }
                                            
                                            | 
                                            ex10=expr1 PLUS ex11=expr1 
                                            {
                                             $value =new AST.plus($ex10.value,$ex11.value,$ex10.value.lineNo);
                                            }
                                            
                                            | 
                                            ex12=expr1 MINUS ex13=expr1 
                                            {
                                             $value =new AST.sub($ex12.value,$ex13.value,$ex12.value.lineNo);
                                            }
                                            
                                            | 
                                            ex14=expr1 STAR ex15=expr1 
                                            {
                                             $value =new AST.mul($ex14.value,$ex15.value,$ex14.value.lineNo);
                                            }
                                            
                                            | 
                                            ex16=expr1 SLASH ex17=expr1
                                            {
                                             $value =new AST.divide($ex16.value,$ex17.value,$ex16.value.lineNo);
                                            } 
                                        
                                            | 
                                            TILDE ex18=expr1
                                            {
                                             $value =new AST.neg($ex18.value,$ex18.value.lineNo);
                                            } 
                                        
                                            | 
                                            ex19=expr1 LT ex20=expr1 
                                            {
                                             $value =new AST.lt($ex19.value,$ex20.value,$ex19.value.lineNo);
                                            }
                                            
                                            | 
                                            ex21=expr1 LE ex22=expr1 
                                            {
                                             $value =new AST.leq($ex21.value,$ex22.value,$ex21.value.lineNo);
                                            }
                                            
                                            | 
                                            ex22=expr1 EQUALS ex23=expr1 
                                            {
                                             $value =new AST.eq($ex22.value,$ex23.value,$ex22.value.lineNo);
                                            }
                                            
                                            | 
                                            NOT ex24=expr1 
                                            {
                                             $value =new AST.comp($ex24.value,$ex24.value.lineNo);
                                            }
                                            
                                            | 
                                            
                                            LPAREN ex25=expr1 RPAREN //as no new operation is done just the same expression value is passed
                                            {
                                             $value =$ex25.value;
                                            }

                                            | 
                                            
                                            ob3=OBJECTID 
                                            {
                                             $value =new AST.object($ob3.getText(),$ob3.getLine());
                                            }

                                            | 
                                            in1=INT_CONST 
                                            {
                                             $value =new AST.int_const($in1.type,$in1.getLine());
                                            }
                                            | 
                                            st1=STR_CONST 
                                            {
                                             $value =new AST.string_const($st1.getText(),$st1.getLine());
                                            }
                                        
                                            | 
                                            b1=BOOL_CONST  
                                            {
                                             $value =new AST.bool_const(Boolean.parseBoolean($b1.getText()),$b1.getLine());
                                            }
            
                                            ;

expr_list_let returns[AST.expression value]:
                                          ob1=OBJECTID COLON tp1=TYPEID ASSIGN ex1=expr1 IN ex6=expr1  
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),$ex1.value,$ex6.value,$ob1.getLine());
                                            }
                                            |
                                            ob1=OBJECTID COLON tp1=TYPEID IN ex6=expr1 
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),new AST.expression(),$ex6.value,$ob1.getLine());
                                            }
                                            |
                                            ob1=OBJECTID COLON tp1=TYPEID ASSIGN ex33=expr1 COMMA exll=expr_list_let
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),$ex33.value,$exll.value,$ob1.getLine());
                                            }
                                            |
                                             ob1=OBJECTID COLON tp1=TYPEID COMMA exll=expr_list_let 
                                            {
                                             $value =new AST.let($ob1.getText(),$tp1.getText(),new AST.expression(),$exll.value,$ob1.getLine());
                                            }
                                          ;



expr_list5 returns[List<AST.expression> value]  //the lists used above are defined here
          @init{$value = new ArrayList<AST.expression>();}:
          expr1{$value.add($expr1.value);} (COMMA expr1{$value.add($expr1.value);})*
                                 ;

expr_list_main returns[List<AST.expression> value ]
                @init{$value=new ArrayList<AST.expression>();}:
                expr1{$value.add($expr1.value);} (COMMA expr1{$value.add($expr1.value);})*
                                              
                                               ;
expr_list returns[List<AST.expression> value] 
          @init{$value = new ArrayList<AST.expression>();}:
          (COMMA expr1{$value.add($expr1.value);})*
                                 ;
                                 
expr_list2 returns[List<AST.expression> value]  
          @init{$value = new ArrayList<AST.expression>();}:
          (e1=expr1 SEMICOLON {$value.add($e1.value);})*
                                 ; 
                                 
expr_list3 returns[List<AST.expression> value] 
          @init{$value = new ArrayList<AST.expression>();}:
           (COMMA OBJECTID COLON TYPEID ASSIGN e2=expr1 {$value.add($e2.value);})*
                                 ;
                                 
expr_list4 returns[List<AST.branch> value]  
          @init{$value = new ArrayList<AST.branch>();}:
          ( e3=branch1 {$value.add($e3.value);})+
                                 ;


                                 
branch1 returns[AST.branch value]        :
                              ob1= OBJECTID COLON tp1=TYPEID DARROW ex1=expr1 SEMICOLON
                              {
                                 $value=new AST.branch($ob1.getText(),$tp1.getText(),$ex1.value,$ob1.getLine());
                              }
                                ;










               
                                               









  

