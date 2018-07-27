package ru.lesson.console_clinic;

/*
	Клиент
	Дата 14.11.17
*/

public class Client {
	private String id;
	private final Pet pet;
	private final String petType;
	
	public Client(String id, Pet pet) {
		this.id = id;
		this.pet = pet;
		if(pet.isCat()) {
            this.petType = "Cat";
        } else if(pet.isDog()){
		    this.petType = "Dog";
        }else {
		    this.petType = "CatDog";
        }
	}

	public Client(Client client) {
		this.id = client.getId();
		this.pet = client.getPet();
		this.petType = client.petType;
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

    public String getPetType() {
        return petType;
    }

    /*
            Редактирование имени
        */
	public void changeName(String newName) {
		this.id = newName;
	}
}