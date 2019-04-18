package cool;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import cool.AST.class_;

public class Codegen{
    public int string_count = 0;
    public int class_count  = 0;
    public int eval_count=2;
    public HashMap <String, String> string_hashmap = new HashMap <String, String> ();
    public Codegen(AST.program program, PrintWriter out){
        //Write Code generator code here
       //out.println("; I am a comment in LLVM-IR. Feel free to remove me.");
        get_class(program.classes,out);
    }
    //we need to create a hashmap of classes , also some global variable
    public void get_class(List <AST.class_ > classes , PrintWriter out)
    {
        //we need to define the classes in the complete code as
        //%class.<NAME> = type{ i32 }
        int total_classes = 0;

        HashMap <String, AST.class_> class_hashmap = new HashMap <String, AST.class_> ();
        //populating the class list here !!
        String filename = classes.get(0).filename;
        out.println("; ModuleID = '"+filename+"'");
        out.println("target datalayout = \"e-p:64:64:64-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:64:64-f32:32:32-f64:64:64-v64:64:64-v128:128:128-a0:0:64-s0:64:64-f80:128:128-n8:16:32:64-S128\"");
        out.println("target triple = \"x86_64-pc-linux-gnu\" \n");  //this is default printing
        for (int i  =  0 ; i < classes.size()  ; i++)   //for declaring classes gloabally in IR file
        {
            String name;
            int attr_count = 0 ;
            String temp = ""; 
            name = (classes.get(i)).name;
            temp = temp .concat("%class.").concat(name).concat(" = type{ ");
            if((classes.get(i)).parent!="IO"&&(classes.get(i)).parent!="Bool"&&(classes.get(i)).parent!="Int"&&(classes.get(i)).parent!="String"&&(classes.get(i)).parent!="Object")
            {
               // temp="";
                if(name.compareTo("Main")!=0)
                {
                    temp=temp.concat(" %class."+(classes.get(i)).parent+", ");
                }
                
               // out.println(" %class."+(classes.get(i)).parent);

            }
            //classes.get(i).features
            attr_count = 0;
            for (int j = 0 ; j < classes.get(i).features.size() ; j ++)
            {
                AST.feature fobj = classes.get(i).features.get(j);
                if(fobj instanceof AST.attr)
                {
                    AST.attr alpha = (AST.attr) fobj;
                    if(alpha.typeid.compareTo("Int") == 0)
                    {
                        if(attr_count == 0)
                        {
                        temp = temp.concat("i32");   //if it has typeid int default concatenation of i32 
                        attr_count++;
                        }
                        else
                        {
                            temp = temp.concat(", i32");
                            attr_count++;
                        }
                    }
                    else if(alpha.typeid.compareTo("Bool") == 0)
                    {
                        if(attr_count == 0)
                        {
                            temp = temp.concat("B");
                            attr_count++;          //to mainatain the count for attributes
                        }
                        else
                        {
                            temp = temp.concat(", B");
                            attr_count++;
                        }
                    }
                    else if (alpha.typeid.compareTo("String") == 0 )
                    {
                        if(attr_count == 0)
                        {
                            temp = temp.concat("%\"class.std::__1::basic_string\"");
                            attr_count++;
                        }
                        else
                        {
                            temp = temp.concat(", %\"class.std::__1::basic_string\"");
                            attr_count++;
                        }
                    }
                }
            }
            
                //oney one
            temp = temp.concat(" }" );
            out.println(temp);
            class_hashmap.put( name , classes.get(i));
            //go get the stringss!!
           // get_string(classes.get(i).features,out);
           // temp="";
           //temp= temp.concat("define i32 @main() #0 {\nentry:");
        }
        out.println();
        for (int i  =  0 ; i < classes.size()  ; i++)   //for declaring strings globally
        {
            
                //oney one
            //temp = temp.concat(" }" );
            //out.println(temp);
            //class_hashmap.put( name , classes.get(i));
            //go get the stringss!!
            get_string(classes.get(i).features,out);
           // temp="";
           //temp= temp.concat("define i32 @main() #0 {\nentry:");
        }
    }
    public void get_string(List <AST.feature> feature_list, PrintWriter out )
    {
        //get the string from the given class
        //class -> feauture list ---> method -- > expression
        AST.method curr_method ;
        AST.attr curr_attr;
        AST.feature fobj;
        AST.expression curr_expression = null;
        for (int i = 0 ; i < feature_list.size() ; i ++)
        {
            fobj = feature_list.get(i);
            if(fobj instanceof AST.method)
            {
                //System.out.println("Iam in this man");

                curr_method = (AST.method) feature_list.get(i);   //type casting accordingly
                curr_expression = curr_method.body;

                //String temp = ""; 
                //temp= temp.concat("define i32 @main() #0 {\nentry:");
                //out.println(temp);
            }
            else if(fobj instanceof AST.attr)
            {
                curr_attr = (AST.attr) feature_list.get(i);    
                curr_expression = curr_attr.value;
                
            }
            expression_resolver(curr_expression, out);   //this does the task for printing the strings globally

            fobj = feature_list.get(i);
            if(fobj instanceof AST.method)
            {
                //System.out.println("Iam in this man");
                curr_method = (AST.method) feature_list.get(i);
                curr_expression = curr_method.body;
                if(curr_method.name.equals("main"))
                {
                    String temp = ""; 
                    temp= temp.concat("\n; Function Attrs: ssp uwtable \ndefine" +curr_method.typeid + "@main() #0 {\n  %1=alloca i32,align 4"); //deafult things added for method
                    out.println(temp);
                    List<AST.feature> feature_list1=new ArrayList<AST.feature>();
                    feature_list1 = feature_list;
                    for(Iterator<AST.feature>feature_itr1=feature_list1.iterator();feature_itr1.hasNext();)
                    {
                        AST.feature fobj1=feature_itr1.next();
                        if(fobj1 instanceof AST.attr)
                        {
                            AST.attr f1=(AST.attr)fobj1;
                            temp="";
                            if(f1.typeid.equals("String"))   //allocate according to the typeid`s
                            {
                                temp=temp.concat("  %"+f1.name+" = alloca %\"class.std::__1::basic_string\", align 8");

                            }
                            else if(f1.typeid.equals("Int"))
                            {
                                temp=temp.concat("  %"+ f1.name + " = alloca i32, align 4");
 
                            }
                            else if(f1.typeid.equals("Bool"))
                            {
                                temp=temp+("  %"+ f1.name +" = alloca i8, align 1");
                            }
                            else
                            {
                                 temp=temp+("  %"+ f1.name +" = alloca %class."+f1.typeid+", align 4");
                            }
                            out.println(temp);

                        }

                    }
                    AST.expression exp_eval=new AST.expression();
                    exp_eval=curr_method.body;
                    evaluation(exp_eval,out);
                    temp="";
                    temp=temp.concat("\n}\n");
                    out.println(temp);

                }
                
                
                
            }
            else if(fobj instanceof AST.attr)
            {
                curr_attr = (AST.attr) feature_list.get(i);    
                curr_expression = curr_attr.value;
                
            }
           // expression_compresolver(curr_expression, out);
            
        }
    }
    public void evaluation(AST.expression e, PrintWriter out)
    {
        String temp="";
        List<AST.expression> list_expr;
        AST.expression use_expr;
        AST.expression use_expr1;
        AST.expression use_expr2;
        if(e instanceof AST.int_const)
        {
            AST.int_const int_cnst = (AST.int_const)e;
            temp=temp.concat("  %"+eval_count+" = load i32* "+int_cnst.value+", align 4");
            out.println(temp);
            eval_count++;
        }
        else if(e instanceof AST.assign)
        {

            AST.assign alpha = (AST.assign)e;
            use_expr = alpha.e1;
            evaluation(use_expr,out);
            if(use_expr instanceof AST.int_const)
            {
                AST.int_const int1=(AST.int_const)use_expr;
                out.println("  store i32 %"+int1.value+", i32* %"+alpha.name+", align 4"); //storing according to bytes number for int and bool
            }
            else if(use_expr instanceof AST.bool_const)
            {
                AST.bool_const bool1=(AST.bool_const)use_expr;
                out.println("  store i8 %"+bool1.value+", i8* %"+alpha.name+", align 1");
            }
        }
        else if(e instanceof AST.block)
        {
            AST.block alpha = (AST.block)e;
            list_expr = alpha.l1;
            for (int i= 0 ; i < list_expr.size() ; i++) 
            {
                evaluation(list_expr.get(i), out);
            }
        }
        else if(e instanceof AST.plus)
        {
            AST.plus alpha =(AST.plus)e;
            use_expr1=alpha.e1;
            use_expr2=alpha.e2;
            temp="";
            temp=temp.concat("  %"+ eval_count+" = load i32* %");   //initially all values need to be loaded before calling evaluation function
            out.print(temp);
            evaluation(use_expr1,out);
            out.println(", align 4");
            eval_count++;
            temp="";
            temp=temp.concat("  %"+ eval_count+" = load i32* %");
            out.print(temp);
            evaluation(use_expr2,out);
            out.println(", align 4");
            eval_count++;
            temp="";
            temp=temp.concat("  %"+eval_count+" = add nsw i32 %"+(eval_count-2)+", %"+(eval_count-1));//saying that it is getting added
            out.print(temp);
            eval_count++;

            
        }
        else if(e instanceof AST.mul)
        {
            AST.mul alpha =(AST.mul)e;
            use_expr1=alpha.e1;
            use_expr2=alpha.e2;
            temp="";
            temp=temp.concat("  %"+ eval_count+" = load i32* %");   //initially all values need to be loaded before calling evaluation function
            out.println(temp);
            evaluation(use_expr1,out);
            out.println(", align 4");
            eval_count++;
            temp="";
            temp=temp.concat("  %"+ eval_count+" = load i32* %");
            out.println(temp);
            evaluation(use_expr2,out);
            out.println(", align 4");
            eval_count++;
            temp="";
            temp=temp.concat("  %"+eval_count+" = mul nsw i32 %"+(eval_count-2)+", %"+(eval_count-1));//saying that it is getting added
            out.print(temp);
            eval_count++;

            
        }
        else if(e instanceof AST.divide)
        {
            AST.divide alpha =(AST.divide)e;
            use_expr1=alpha.e1;
            use_expr2=alpha.e2;
            temp="";
            temp=temp.concat("  %"+ eval_count+" = load i32* %");   //initially all values need to be loaded before calling evaluation function
            out.println(temp);
            evaluation(use_expr1,out);
            out.println(", align 4");
            eval_count++;
            temp="";
            temp=temp.concat("  %"+ eval_count+" = load i32* %");
            out.println(temp);
            evaluation(use_expr2,out);
            out.println(", align 4");
            eval_count++;
            temp="";
            temp=temp.concat("  %"+eval_count+" = div nsw i32 %"+(eval_count-2)+", %"+(eval_count-1));//saying that it is getting added
            out.print(temp);
            eval_count++;

            
        }

        else if(e instanceof AST.object)
        {
            AST.object obj =(AST.object)e;
            out.print(obj.name);
        }
        
    }

    public void expression_resolver (AST.expression e , PrintWriter out )
    {

        AST.string_const curr_str_constant;
        AST.expression use_expr;
        List<AST.expression> list_expr;        
        //assign
        //static dispatch 
        //dispatch 
        //block
        //while 
        //let
        //if then else
        //string

        if(e instanceof AST.string_const ) //traverse through all possibilities and catch the string_const
        {
           // System.out.println("Iam in string ");
            curr_str_constant = (AST.string_const) e;
            String temp = "@.str";
            if(string_count != 0)
            {
                temp = temp.concat(String.valueOf(string_count));
            }
            string_hashmap.put(curr_str_constant.value ,temp);
            temp = temp.concat(" = private unnamed_addr constant [");
            temp = temp.concat(String.valueOf( curr_str_constant.value.length()+1));
            temp = temp.concat(" x i8] c");
            curr_str_constant.value = (curr_str_constant.value).replace("\n", "\\0A").replace("\r", "\\0A").replace("\t","\\09").replace("\b","\\08").replace("\f","\\0C");
            temp = temp.concat("\""+curr_str_constant.value+"\\00\""+" , align1");
            out.println(temp);
            string_count++;
        }    
        else if(e instanceof AST.assign)
        {
            AST.assign alpha = (AST.assign)e;
            use_expr = alpha.e1;
            expression_resolver(use_expr,out);
        }
        else if (e instanceof AST.dispatch)
        {
            AST.dispatch alpha = (AST.dispatch) e;
            list_expr = alpha.actuals;
            for (int i= 0 ; i < list_expr.size() ; i++) 
            {
                expression_resolver(list_expr.get(i), out);
            }
        }
        else if (e instanceof AST.static_dispatch)  
        {
            AST.static_dispatch alpha = (AST.static_dispatch) e;
            list_expr = alpha.actuals;
            for (int i= 0 ; i < list_expr.size() ; i++) 
            {
                expression_resolver(list_expr.get(i), out);
            }
        }
        else if(e instanceof AST.block)
        {
            AST.block alpha = (AST.block) e;
            list_expr = alpha.l1;
            for (int i= 0 ; i < list_expr.size() ; i++) 
            {
                expression_resolver(list_expr.get(i), out);
            }    
        }
        else if(e instanceof AST.loop)  //catch according the loop
        {
            AST.loop alpha = (AST.loop) e;
            expression_resolver(alpha.body, out);
        }
        else if(e instanceof AST.let)
        { 
          //  System.out.println("I`m here");
            AST.let alpha = (AST.let) e;
            use_expr = alpha.value;
            expression_resolver(use_expr,out);
            use_expr = alpha.body;
            expression_resolver(use_expr,out);
        }
        else if(e instanceof AST.cond)
        {
            AST.cond alpha  = (AST.cond) e;
            use_expr = alpha.ifbody;
            expression_resolver(use_expr,out);
            use_expr = alpha.elsebody;
            expression_resolver(use_expr,out);
        }
        else if (e instanceof AST.lt)
        {
            AST.lt alpha = (AST.lt) e ;
            use_expr = alpha.e1;
            expression_resolver(use_expr,out);
            use_expr = alpha.e2;
            expression_resolver(use_expr,out);    

        }
        else if ( e instanceof AST.leq)
        {
            AST.leq alpha= (AST.leq) e;
            use_expr = alpha.e1;
            expression_resolver(use_expr,out);
            use_expr = alpha.e2;
            expression_resolver(use_expr,out);
        }
        else if(e instanceof AST.eq)
        {    
            AST.eq alpha = (AST.eq) e;
            use_expr = alpha.e1;
            expression_resolver(use_expr,out);
            use_expr = alpha.e2;
            expression_resolver(use_expr,out);
        }
        else if (e instanceof AST.neg)
        {
            AST.neg alpha = (AST.neg) e;
            use_expr = alpha.e1;
            expression_resolver(use_expr,out);
        }
        

    }

}
