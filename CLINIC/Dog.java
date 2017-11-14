/*
	Пес
	дата 14.11.17
*/
public class Dog implements Pet {
	//базовая реализация питомца
	private final Pet pet;
	
	public Dog(final Pet pet) {
		this.pet = pet;
	}
	
	@Override
	public void makeSound() {
		this.pet.makeSound();
		System.out.println("Gav, Gav");
	}
	
	@Override
	public String getName() {
		return this.pet.getName();
	}
	
	@Override
	public boolean isCatDog() {
		return false;
	}
	
	@Override
	public boolean isDog() {
		return true;
	}	
	
	@Override
	public boolean isCat() {
		return false;
	}
	
	@Override
	public void changeName(String newName1, String ... newName2) {
		this.pet.changeName(newName1);
	}
}