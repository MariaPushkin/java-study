package ru.lesson.clinic;

/**
 * Потокобезопасная клиника
 * Дата 29.11.17
 */
public class ConcurrentClinic {
    public MyArrayList<Client> clients;

    public ConcurrentClinic(final int size) {
        this.clients = new MyArrayList<Client>(size);
    }

    public int getCurrCol() {
        return this.clients.getSize();
    }

    /*
		Добавление клиента
		Дата 29.11.17
	*/
    public void addClient(final Client client) {
        synchronized (this.clients) {
            while (this.checkClientByName(client.getId())) {
                try {
                    this.clients.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(!this.checkClientByName(client.getId())) {
                this.clients.add(client);
            }
            System.out.println("Добавлен " + client.getId());
            this.clients.notifyAll();
        }
    }

    /*
    Удаление клиента
    Дата 29.11.17
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
                for (int i = 0; i < this.clients.getSize(); i++) {
                    if (name.equals(this.clients.get(i).getId())) {
                        this.clients.remove(i);
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
    дата 30.11.17
*/
    public synchronized Client getClient(int position) throws UserException{
        if(position >= this.clients.getSize())
            throw new UserException("No such person exists");
        else
            return clients.get(position);
    }

    public synchronized boolean checkClientByName(final String name) {
        for(int i = 0; i < this.clients.getSize(); i++){
            if(name.equals(this.clients.get(i).getId())) {
                return true;
            }
        }
        return false;
    }
}
