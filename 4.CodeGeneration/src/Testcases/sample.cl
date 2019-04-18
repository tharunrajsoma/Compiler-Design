class A{
	b: Int;
	fo : String <- "jerusalem";
	f():Int{
		b<-10
	};
};


class B inherits A{ 
	temp: String;
	foo():String{
		temp <- "sadas"	
	};
};
class Main inherits IO{
	a : Int<-5;
	a1: Int<-3;
	asd: Int;
        amd:Int;
	g : String <- "qwertyasd";
	gh : String <- "wedslm";
	fg : String;
	foo: B;
	main(): Object {{
		fg <- "asd";
		a<-5;
                amd<-a+a1;
		}};	
};
