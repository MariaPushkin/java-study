/*
	Котопес
	дата 14.11.17
*/
public class CatDog implements Pet {
	private final Pet cat;
	private final Pet dog;
	
	public CatDog(Pet cat, Pet dog) {
		this.cat = cat;
		this.dog = dog;
	}
	
	@Override
	public void makeSound() {
		this.cat.makeSound();
		this.dog.makeSound();
	}
	
	@Override
	public String getName() {
		return String.format("%s%s", this.cat.getName(), this.dog.getName());
	}
	
	@Override
	public boolean isCatDog() {
		return true;
	}
	
	@Override
	public boolean isDog() {
		return false;
	}	
	
	@Override
	public boolean isCat() {
		return false;
	}
	
	public void changeName(String newName1, String ... newName2) {
		this.cat.changeName(newName1);
		this.dog.changeName(newName2[0]);
	}
}