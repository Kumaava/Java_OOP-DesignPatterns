 public class workingwithanimals {

	public static void main (String[] args){
		
		Cat babe = new Cat();
		babe.setName("Latina");
		System.out.println(babe.getName());
		babe.Movehere();
		
		dog fido = new dog();
		
		fido.setName("Fido");
		System.out.println(fido.getName());
		
		fido.digHole();
		
		fido.setWeight(-1);
		
		int randNum = 10;
		fido.changeVar(randNum);
		System.out.println("randNum after method call: " +  randNum);
		
		changeObjectname(fido);
		
		System.out.println("dog name after method call:" + fido.getName());
	}
	
	public static void  changeObjectname(dog fido){
		fido.setName("Marcus");
	}
}
