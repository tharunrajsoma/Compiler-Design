class A inherits IO {
x:Int<-4;
z:String;
};
class B inherits A
{
   main(): Object 
   {{
      let y:String<-5 in{
              y<-"thar";
              x<-5;
                k<-3;
              z<-"hello";
              x<-"hello";
              z<-6;
              } ;
      out_string("hello");
   }};
};
