class Main inherits IO {
  main() : Object { {
    out_string("\nEnter the number of terms:\n");
    let n: Int <-in_int(), c: Int <- 1,i: Int <- 0 in
    {
    out_string("The fibonacci sequence is :\n");
    	while c<=n loop                    -- iterate the loop untill c==n
    	{ 
    		out_int(fibonacci(i));
    		out_string("\n");
    		c<-c+1;
    		i<-i+1;
    	} pool;  
    };
  }};
  fibonacci(num: Int): Int{
  	if num=0 then  0
  	else if num=1 then 1
  	else fibonacci(num-1)+fibonacci(num-2)
  	fi fi

  };
};
