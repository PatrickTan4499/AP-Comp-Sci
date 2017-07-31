
class CircusAnimal{
	private String name;
	private int age;
	private String gender;
	
	public CircusAnimal(String startName, int startAge, String startGender){
		name = startName;
		age = startAge;
		gender = startGender;
	}

	public void changeName(String newName){
		name = newName;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	class ClownFiestCircusAnimals{
		public void main(){
		CircusAnimal monkey = new CircusAnimal("kevin", 12, "female");
		int monkeyAge = getAge();
		System.out.println(monkeyAge);
	}
}
}
