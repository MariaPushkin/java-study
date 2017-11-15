package ru.lesson.clinic;

/*
	Клиент
	Дата 14.11.17
*/

public class Client {
	private String id;
	private final Pet pet;
	
	public Client(String id, Pet pet) {
		this.id = id;
		this.pet = pet;
	}
	
	/*
		Получить id клиента
	*/
	public String getId() {
		return this.id;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	/*
		Редактирование имени
	*/
	public void changeName(String newName) {
		this.id = newName;
	}
}