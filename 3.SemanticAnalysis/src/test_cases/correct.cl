class B inherits IO
{
   main(): Object 
   {{
      let x:Int<-3,y:String<-"raj" in
         {
              z<-4;
              if(x="raj")
              then
              {
                 x=2+"thar";
                 out_string("it`s correct");
              }
              else
              {
                 y="thar";
                 out_string("it` wrong returned with:");
              }
               fi;
         };
      out_string("hello");
   }};
};
