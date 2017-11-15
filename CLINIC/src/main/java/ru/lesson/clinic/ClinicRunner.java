package ru.lesson.clinic;

import java.util.Scanner;

/*
	Работа клиники
	Дата 14.11.17
*/
public class ClinicRunner {
	public static void main(String[] arg) {
		Scanner reader = new Scanner(System.in);
		try {
			final Clinic clinic = new Clinic(10);
			clinic.addClient(0, new Client("Brown", new Cat("Digy")));
			String exit = "n";
			while (!exit.equals("y")) {
				System.out.println("What are u going to do?");
				System.out.println("a - add client");
				System.out.println("f - find client by pet name");
				System.out.println("cc - Change client name");
				System.out.println("cp - Change pet name");
				System.out.println("d - Delete client");
				System.out.println("s - Show all clients with pets");
				String action = reader.next();
				switch (action) {
				//добавление клиента
				case "a":
					boolean wrong = false;
					System.out.println("Enter your name");
					String name = reader.next();
					if(!clinic.checkClientByName(name)) {
						System.out.println("What type of Animal do u have? Cat - c, Dog - d, CatDog - cd");
						String animalType = reader.next();
						switch (animalType) {
							case "c":
								System.out.println("Enter your cat name");
								String petName = reader.next();
								clinic.addClient(clinic.getCurrCol(), new Client(name, new Cat(petName)));
								break;
							case "d":
								System.out.println("Enter your dog name");
								String petName2 = reader.next();
								clinic.addClient(clinic.getCurrCol(), new Client(name, new Dog(new Animal(petName2))));
								break;
							case "cd":
								System.out.println("Enter your cat name");
								String catName = reader.next();
								System.out.println("Enter your dog name");
								String dogName = reader.next();
								clinic.addClient(clinic.getCurrCol(), new Client(name, new CatDog(new Cat(catName), new Dog(new Animal(dogName)))));
								break;
							default:
								System.out.println("Somth wrong");
								break;
						}
					}
					else
						System.out.println("Such person has already exists");
					break;
				//нахождение клиентов по имени питомца
				case "f":
					System.out.println("Enter your pet name");
					String searchPetName = reader.next();
					Client[] foundClients = clinic.findClientByPetName(searchPetName);
					try {
						if(foundClients.length == 0)
							System.out.println("No clients with such pet exists");
						else {
							System.out.println("Clients with such pets");
							for(int j = 0; j < foundClients.length; j++)
								System.out.println(foundClients[j].getId());
						}
					} catch (NullPointerException e) {
					}
					break;
				//изменение имени клиента
				case "cc":
					System.out.println("Enter your name");
					String currName = reader.next();

					try {
						int clientPos = clinic.findClientByName(currName);
						System.out.println("Enter new name");
						String newCurrName = reader.next();
						clinic.clients[clientPos].changeName(newCurrName);

					} catch (UserException e) {
						System.out.println(e.getMessage());
					}
					break;
				//изменение имени питомца
				case "cp":
					System.out.println("Enter your name");
					String currName2 = reader.next();
					boolean exist2 = false;
					for(int i = 0; i < clinic.getCurrCol(); i++){
						if(currName2.equals(clinic.clients[i].getId())) {
							if(clinic.clients[i].getPet().isCatDog()) {
								System.out.println("Enter new cat name");
								String newCatName = reader.next();
								System.out.println("Enter new dog name");
								String newDogName = reader.next();
								clinic.clients[i].getPet().changeName(newCatName, newDogName);
							}
							else {
								System.out.println("Enter new pet name");
								String newPetName = reader.next();
								clinic.clients[i].getPet().changeName(newPetName);
							}
							exist2 = true;
							break;
						}
					}
					if(!exist2)
						System.out.println("No such person exists");
					break;
				//удаление клиента
				case "d":
					System.out.println("Enter name of deleating client");
					String delName = reader.next();
					if(clinic.delClient(delName))
						System.out.println("Client deleted successfuly");
					else
						System.out.println("Impossoble delete this client");
					break;
				//показ всех клиентов
				case "s":
					for(int i = 0; i < clinic.getCurrCol(); i++){
						System.out.print("Client - " + clinic.clients[i].getId());
						if(clinic.clients[i].getPet().isCat())
							System.out.print(", Cat - " + clinic.clients[i].getPet().getName());
						if(clinic.clients[i].getPet().isDog())
							System.out.print(", Dog - " + clinic.clients[i].getPet().getName());
						if(clinic.clients[i].getPet().isCatDog())
							System.out.print(", CatDog - " + clinic.clients[i].getPet().getName());
						System.out.println();
					}
					break;
				default:
					break;
				}
				System.out.println("Exit: y - yes/n - no ");
				exit = reader.next();
			}
		}	finally {
				reader.close();
			}
	}
}