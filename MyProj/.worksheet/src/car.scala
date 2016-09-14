object car{

 object moduleA { class A
}
class ModuleB { class A
};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(248); 
def main(args:Array[String]) = {
val moduleB = new ModuleB
val a1 = new moduleA.A
val a2 = new moduleB.A
println(a1.getClass == a1.getClass)
println(a1.getClass == a2.getClass)
()
}

object UnifiedTypes extends App {
  val set = new scala.collection.mutable.LinkedHashSet[Any]
  set += "This is a string"  // add a string
  set += 732                 // add a number
  set += 'c'                 // add a character
  set += true                // add a boolean value
  set += main _              // add the main function
  val iter: Iterator[Any] = set.iterator
  while (iter.hasNext) {
    println(iter.next.toString())
  }
};System.out.println("""main: (args: Array[String])Unit""");$skip(488); 
 println("Welcome to the Scala worksheet")}
}
