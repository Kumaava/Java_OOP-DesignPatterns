object FirstClassFunctions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
 /* 1) Write a function literal that takes two integers and returns the higher number.
  Then write a higher-order function that takes a 3-sized tuple of integers plus this
   function literal, and uses it to return the maximum value in the tuple. */
  
  //Lamdaexpressions
  val max = (x:Int, y: Int) => if( x>y) x else y  //> max  : (Int, Int) => Int = <function2>
  
  max(9,13)                                       //> res0: Int = 13
  
  def maxagain(t: (Int, Int, Int), cmp: (Int, Int) => Int): Int = {
  cmp((t._1), cmp(t._2,t._3))
  }                                               //> maxagain: (t: (Int, Int, Int), cmp: (Int, Int) => Int)Int
  
  maxagain((2,3,4), max)                          //> res1: Int = 4
  
  /* 2) The library function util.Random.nextInt returns a random integer. Use it to
  invoke the "max" function with two random integers plus a function that returns
  the larger of two given integers. Do the same with a function that returns the
  smaller of two given integers, and then a function that returns the second integer
   every time. */
  
  def nextInt = util.Random.nextInt               //> nextInt: => Int
  
  var x = (nextInt, nextInt, nextInt)             //> x  : (Int, Int, Int) = (-1001063158,-4089875,94511823)
  
  maxagain(x,max)                                 //> res2: Int = 94511823
 
 
 /* 3) Write a higher-order function that takes an integer and returns a function.
 The returned function should take a single integer argument (say, "x") and return
 the product of x and the integer passed to the higher-order function.  */

 def multy(x: Int) = (y: Int) => x * y            //> multy: (x: Int)Int => Int
 
 val Doubler = multy(2)                           //> Doubler  : Int => Int = <function1>

 Doubler(9)                                       //> res3: Int = 18



/* 4) Let’s say that you happened to run across this function while reviewing another developer’s code:

def fzero[A](x: A)(f: A ⇒ Unit): A = { f(x); x }

What does this function accomplish? Can you give an example of how you might invoke it? */

def fzero(x: String, f: String => Unit): String = { f(x); x }
                                                  //> fzero: (x: String, f: String => Unit)String
fzero("Hello", s => println(s.reverse))           //> olleH
                                                  //| res4: String = Hello


/* 5) There’s a function named "square" that you would like to store in a function value. Is this the right way to do it?
 How else can you store a function in a value? */
def square(m: Double) = m * m                     //> square: (m: Double)Double
val sq = square _                                 //> sq  : Double => Double = <function1>
sq(5)                                             //> res5: Double = 25.0

val sq1: Double => Double = square                //> sq1  : Double => Double = <function1>
sq1(10)                                           //> res6: Double = 100.0

/* 6) Write a function called "conditional" that takes a value x and two functions,
 p and f, and returns a value of the same type as x. The p function is a predicate,
 taking the value x and returning a Boolean b. The f function also takes the value x
 and returns a new value of the same type. Your "conditional" function should only
 invoke the function f(x) if p(x) is true, and otherwise return x. How many type
 parameters will the "conditional" function require? */
 
 def conditional[A](x: A, p: A => Boolean, f: A => A): A = {
 if (p(x)) f(x) else x
 }                                                //> conditional: [A](x: A, p: A => Boolean, f: A => A)A
 
 val a = conditional[String]("yo", _.size > 4, _.reverse)
                                                  //> a  : String = yo
 
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
  }                                               //> 1122type44safetype7788typesafe1111type13131414typesafe16161717type1919safet
                                                  //| ype22222323typesafe2626type28282929typesafe31313232type3434safetype37373838
                                                  //| typesafe4141type43434444typesafe46464747type4949safetype52525353typesafe565
                                                  //| 6type58585959typesafe61616262type6464safetype67676868typesafe7171type737374
                                                  //| 74typesafe76767777type7979safetype82828383typesafe8686type88888989typesafe9
                                                  //| 1919292type9494safetype97979898typesafe

def conditional1[A](x: A, p: A => Boolean, f: A => String): String = {
 if (p(x)) f(x) else ""
 }                                                //> conditional1: [A](x: A, p: A => Boolean, f: A => String)String
 
 for (i <- 1 to 100) {
  val a1 = conditional1[Int](i, _ % 3 == 0, _ => "type")
  val a2 = conditional1[Int](i, _ % 5 == 0, _ => "safe")
  val a3 = conditional1[Int](i, _ % 3 > 0 && i % 5 > 0, x => s"$x")
  println(a1 + a2 + a3)
  }                                               //> 1
                                                  //| 2
                                                  //| type
                                                  //| 4
                                                  //| safe
                                                  //| type
                                                  //| 7
                                                  //| 8
                                                  //| type
                                                  //| safe
                                                  //| 11
                                                  //| type
                                                  //| 13
                                                  //| 14
                                                  //| typesafe
                                                  //| 16
                                                  //| 17
                                                  //| type
                                                  //| 19
                                                  //| safe
                                                  //| type
                                                  //| 22
                                                  //| 23
                                                  //| type
                                                  //| safe
                                                  //| 26
                                                  //| type
                                                  //| 28
                                                  //| 29
                                                  //| typesafe
                                                  //| 31
                                                  //| 32
                                                  //| type
                                                  //| 34
                                                  //| safe
                                                  //| type
                                                  //| 37
                                                  //| 38
                                                  //| type
                                                  //| safe
                                                  //| 41
                                                  //| type
                                                  //| 43
                                                  //| 44
                                                  //| typesafe
                                                  //| 46
                                                  //| 47
                                                  //| type
                                                  //| 49
                                                  //| safe
                                                  //| type
                                                  //| 52
                                                  //| 53
                                                  //| type
                                                  //| safe
                                                  //| 56
                                                  //| type
                                                  //| 58
                                                  //| 59
                                                  //| typesafe
                                                  //| 61
                                                  //| 62
                                                  //| type
                                                  //| 64
                                                  //| safe
                                                  //| type
                                                  //| 67
                                                  //| 68
                                                  //| type
                                                  //| safe
                                                  //| 71
                                                  //| type
                                                  //| 73
                                                  //| 74
                                                  //| typesafe
                                                  //| 76
                                                  //| 77
                                                  //| type
                                                  //| 79
                                                  //| safe
                                                  //| type
                                                  //| 82
                                                  //| 83
                                                  //| type
                                                  //| safe
                                                  //| 86
                                                  //| type
                                                  //| 88
                                                  //| 89
                                                  //| typesafe
                                                  //| 91
                                                  //| 92
                                                  //| type
                                                  //| 94
                                                  //| safe
                                                  //| type
                                                  //| 97
                                                  //| 98
                                                  //| type
                                                  //| safe

 

 }