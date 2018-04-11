package ru.lesson.console_clinic;

public interface Pet {

	void makeSound();
	String getName();
	boolean isCatDog();
	boolean isDog();
	boolean isCat();
	void changeName(String newName1, String ... newName2);
}
