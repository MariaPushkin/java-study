public interface Pet {

	void makeSound();
	String getName();
	boolean isCatDog();
	boolean isDog();
	boolean isCat();
	public void changeName(String newName1, String ... newName2);
}
