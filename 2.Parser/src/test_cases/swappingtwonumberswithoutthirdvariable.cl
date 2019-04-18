class Main inherits IO {
  main() : Object {{
    out_string("\nEnter the two numbers to be swapped:\n");
    let a: Int <-in_int() in
    let b: Int <-in_int() in{                               --swapping two numbers without a third variable memory wastage
      a <- a + b;
      b <- a - b;
      a <- a - b;
      out_string("Swapped numbers are:\nFirst number:").out_int(a).out_string("\nSecond number:").out_int(b).out_string("\n");};
  }};
};