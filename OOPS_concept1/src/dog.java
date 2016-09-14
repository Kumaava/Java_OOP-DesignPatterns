public class dog extends Animal {

	 public void digHole(){
		 System.out.println("Dug a hole");
	 }
	 public dog(){
		 super();
		 setSound("Bark"); 
	 }
	 public void changeVar(int randNum){
		 randNum = 12;
		 System.out.println("randNum in method : " + randNum);
	 }
}
