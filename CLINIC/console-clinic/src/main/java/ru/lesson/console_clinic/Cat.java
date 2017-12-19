package ru.lesson.console_clinic;

/*
	Кот. Мяукает и ловит мышей.
	дата 14.11.17
*/
public class Cat extends Animal {
	public Cat(final String name) {
		super(name);
	}
	
	public void catchMouse() {
	}
	
	@Override
	public void makeSound() {
		System.out.println(String.format("May %s", this.getName()));
	}
	
	@Override
	public boolean isCatDog() {
		return false;
	}
	
	@Override
	public boolean isDog() {
		return false;
	}	
	
	@Override
	public boolean isCat() {
		return true;
	}
	
	@Override
	public void changeName(String newName1, String ... newName2) {
		super.changeName(newName1);
	}
}