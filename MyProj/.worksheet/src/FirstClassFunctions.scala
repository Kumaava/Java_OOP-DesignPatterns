object FirstClassFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  println("Welcome to the Scala worksheet");$skip(327); 
  
 /* 1) Write a function literal that takes two integers and returns the higher number.
  Then write a higher-order function that takes a 3-sized tuple of integers plus this
   function literal, and uses it to return the maximum value in the tuple. */
  
  //Lamdaexpressions
  val max = (x:Int, y: Int) => if( x>y) x else y;System.out.println("""max  : (Int, Int) => Int = """ + $show(max ));$skip(15); val res$0 = 
  
  max(9,13);System.out.println("""res0: Int = """ + $show(res$0));$skip(105); 
  
  def maxagain(t: (Int, Int, Int), cmp: (Int, Int) => Int): Int = {
  cmp((t._1), cmp(t._2,t._3))
  };System.out.println("""maxagain: (t: (Int, Int, Int), cmp: (Int, Int) => Int)Int""");$skip(28); val res$1 = 
  
  maxagain((2,3,4), max);System.out.println("""res1: Int = """ + $show(res$1));$skip(393); 
  
  /* 2) The library function util.Random.nextInt returns a random integer. Use it to
  invoke the "max" function with two random integers plus a function that returns
  the larger of two given integers. Do the same with a function that returns the
  smaller of two given integers, and then a function that returns the second integer
   every time. */
  
  def nextInt = util.Random.nextInt;System.out.println("""nextInt: => Int""");$skip(41); 
  
  var x = (nextInt, nextInt, nextInt);System.out.println("""x  : (Int, Int, Int) = """ + $show(x ));$skip(21); val res$2 = 
  
  maxagain(x,max);System.out.println("""res2: Int = """ + $show(res$2));$skip(285); 
 
 
 /* 3) Write a higher-order function that takes an integer and returns a function.
 The returned function should take a single integer argument (say, "x") and return
 the product of x and the integer passed to the higher-order function.  */

 def multy(x: Int) = (y: Int) => x * y;System.out.println("""multy: (x: Int)Int => Int""");$skip(26); 
 
 val Doubler = multy(2);System.out.println("""Doubler  : Int => Int = """ + $show(Doubler ));$skip(13); val res$3 = 

 Doubler(9);System.out.println("""res3: Int = """ + $show(res$3));$skip(312); 



/* 4) Let’s say that you happened to run across this function while reviewing another developer’s code:

def fzero[A](x: A)(f: A ⇒ Unit): A = { f(x); x }

What does this function accomplish? Can you give an example of how you might invoke it? */

def fzero(x: String, f: String => Unit): String = { f(x); x };System.out.println("""fzero: (x: String, f: String => Unit)String""");$skip(40); val res$4 = 
fzero("Hello", s => println(s.reverse));System.out.println("""res4: String = """ + $show(res$4));$skip(204); 


/* 5) There’s a function named "square" that you would like to store in a function value. Is this the right way to do it?
 How else can you store a function in a value? */
def square(m: Double) = m * m;System.out.println("""square: (m: Double)Double""");$skip(18); 
val sq = square _;System.out.println("""sq  : Double => Double = """ + $show(sq ));$skip(6); val res$5 = 
sq(5);System.out.println("""res5: Double = """ + $show(res$5));$skip(36); 

val sq1: Double => Double = square;System.out.println("""sq1  : Double => Double = """ + $show(sq1 ));$skip(8); val res$6 = 
sq1(10);System.out.println("""res6: Double = """ + $show(res$6));$skip(563); 

/* 6) Write a function called "conditional" that takes a value x and two functions,
 p and f, and returns a value of the same type as x. The p function is a predicate,
 taking the value x and returning a Boolean b. The f function also takes the value x
 and returns a new value of the same type. Your "conditional" function should only
 invoke the function f(x) if p(x) is true, and otherwise return x. How many type
 parameters will the "conditional" function require? */
 
 def conditional[A](x: A, p: A => Boolean, f: A => A): A = {
 if (p(x)) f(x) else x
 };System.out.println("""conditional: [A](x: A, p: A => Boolean, f: A => A)A""");$skip(60); 
 
 val a = conditional[String]("yo", _.size > 4, _.reverse);System.out.println("""a  : String = """ + $show(a ));$skip(934); 
 
 /* 7) Do you recall the “typesafe” challenge from the exercises in Chapter 3?
  There is a popular coding interview question I’ll call “typesafe,” in which
  the numbers 1-100 must be printed one per line. The catch is that multiples
  of 3 must replace the number with the word “type,” while multiples of 5 must
   replace the number with the word “safe.” Of course, multiples of 15 must print
    “typesafe.”
Use the “conditional” function from exercise 6 to implement this challenge.
Would your solution be shorter if the return type of “conditional” did not
match the type of the parameter x? Experiment with an altered version of the
“conditional” function that works better with this challenge. */
for (i <- 1 to 100) {
val a1 = conditional[Int](i, _ % 3 == 0, x => { print("type"); 0 })
val a2 = conditional[Int](i, _ % 5 == 0, x => { print("safe"); 0 })
 if (a1 > 0 && a2 > 0) print(i)
  if (a1 > 0 && a2 > 0) print(i)
  };$skip(99); 

def conditional1[A](x: A, p: A => Boolean, f: A => String): String = {
 if (p(x)) f(x) else ""
 };System.out.println("""conditional1: [A](x: A, p: A => Boolean, f: A => String)String""");$skip(235); 
 
 for (i <- 1 to 100) {
  val a1 = conditional1[Int](i, _ % 3 == 0, _ => "type")
  val a2 = conditional1[Int](i, _ % 5 == 0, _ => "safe")
  val a3 = conditional1[Int](i, _ % 3 > 0 && i % 5 > 0, x => s"$x")
  println(a1 + a2 + a3)
  }}

 

 }
