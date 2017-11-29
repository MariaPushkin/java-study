package ru.lesson.clinic;



/*
	Клиника
	дата 14.11.17
*/
public class Clinic {
	public MyArrayList<Client> clients;
	//текущее количество клиентов
	private volatile int currCol;
	//private int maxSize;
	
	public Clinic(final int size) {
		this.clients = new MyArrayList<Client>(size);
		//this.maxSize = size;
		this.currCol = 0;
	}
	
	public int getCurrCol() {
		return this.currCol;
	}
	
	/*
		Добавление клиента
	*/
	public void addClient(final Client client) /*throws UserException*/ {
		synchronized (this.clients) {
			while (this.checkClientByName(client.getId())) {
				try {
					this.clients.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//throw new UserException("Such person has already exists");
			}
		if(!this.checkClientByName(client.getId())) {
			this.clients.add(client);
			this.currCol++;
		}
			System.out.println("Добавлен " + client.getId());
			this.clients.notifyAll();
		}
	}
	
	/*
		Нахождение клиента по имени его питомца
	*/
	public Client[] findClientByPetName(final String name) {
		Client[] foundClients = new Client[10];
		int foundCol = 0;
		for(int i = 0; i < this.currCol; i++){
			if(name.equals(this.clients.get(i).getPet().getName())) {
				foundClients[foundCol] = this.clients.get(i);
				foundCol++;
			}
		}
		Client[] foundClients2 = new Client[foundCol];
		for(int j = 0; j < foundCol; j++)
			foundClients2[j] = foundClients[j];
		return foundClients2;
	}
	
	/*
		Удаление клиента
	*/
	public boolean delClient(String name) {
		synchronized (this.clients) {
			while (!this.checkClientByName(name)) {
				try {
					this.clients.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		if(this.checkClientByName(name)) {
			for (int i = 0; i < this.currCol; i++) {
				if (name.equals(this.clients.get(i).getId())) {
					//for (int j = i; j < this.currCol; j++)
						this.clients.remove(i);
					this.currCol--;
					System.out.println("Удален " + name);
					this.clients.notifyAll();
					return true;
				}
			}
		}
		}
		return false;
	}

	/*
		Показать клиента с определенной позиции
		дата 15.11.17
	*/
	public synchronized Client getClient(int position) throws UserException{
		if(position >= currCol)
			throw new UserException("No such person exists");
		else
			return clients.get(position);
	}

	/*
		Поиск клиента по имени
		//TODO change with check method
		дата 15.11.17
	*/
	public int findClientByName(final String name) throws UserException{
		for(int i = 0; i < this.currCol; i++){
			if(name.equals(this.clients.get(i).getId())) {
				return i;
			}
		}
		throw new UserException("No such person exists");
	}

	public synchronized boolean checkClientByName(final String name) {
		for(int i = 0; i < this.currCol; i++){
			if(name.equals(this.clients.get(i).getId())) {
				return true;
			}
		}
		return false;
	}
}

