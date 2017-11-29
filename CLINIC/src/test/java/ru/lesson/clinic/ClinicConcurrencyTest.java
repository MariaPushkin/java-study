package ru.lesson.clinic;

import org.junit.Test;


import static org.junit.Assert.*;

public class ClinicConcurrencyTest  {
    @Test
    public void clinic() throws InterruptedException {
        Clinic testClinic = new Clinic(10);
        testClinic.addClient(new Client("Client1",  new Cat("Bola")));
        testClinic.addClient(new Client("Client4",  new Cat("Bob")));
        testClinic.delClient("Client4");
        AdderAdmin adder1 = new AdderAdmin(testClinic,"Client1","Bola");
        AdderAdmin adder2 = new AdderAdmin(testClinic,"Client2","Sola");
        AdderAdmin adder3 = new AdderAdmin(testClinic,"Client3","Lola");
        DeleteAdmin delete1 = new DeleteAdmin(testClinic, "Client1");
        DeleteAdmin delete2 = new DeleteAdmin(testClinic, "Client2");
        adder1.start();
        adder2.start();
        adder3.start();
        delete1.start();
        delete2.start();
        adder1.join();
        adder2.join();
        adder3.join();
        delete1.join();
        delete2.join();
        Thread.sleep(1000);
        //adder1.interrupt();
        //adder2.interrupt(); adder3.interrupt();
        //delete1.interrupt();
        if(!adder1.isAlive() && !adder2.isAlive() && !adder3.isAlive() && !delete1.isAlive()) {
            System.out.println("Оставшиеся крутяшки:");
            for (Client cl : testClinic.clients) {
                System.out.print(cl.getId());
                System.out.print(" ");
                System.out.println(cl.getPet().getName());
            }
            System.out.println(" ");
            for(int i = 0; i < testClinic.getCurrCol(); i++) {
                System.out.print(testClinic.clients.get(i).getId());
                System.out.print(" ");
                System.out.println(testClinic.clients.get(i).getPet().getName());
            }
        }
    }

    /*
    Класс-админ
    Дата 28.11.17
     */
    private abstract static class Admin extends Thread {
        Clinic clinic = new Clinic(10);

        public Admin(Clinic clinic) {
            this.clinic = clinic;
        }

        abstract public void doYourWork();

        @Override
        public void run() {
            this.doYourWork();
        }
    }

    /*
    Класс-админ, добавляющий клиентов в клинику
    Дата 28.11.17
     */
    private static class AdderAdmin extends Admin {
        private String clientName;
        private String dogName;
        private String catName;

        public AdderAdmin(Clinic clinic, String clientName, String catName) {
            super(clinic);
            this.clientName = clientName;
            this.catName = catName;
        }

        @Override
        public void doYourWork() {
            Client newClient = new Client(this.clientName, new Cat(this.catName));
            this.clinic.addClient(newClient);
            //System.out.println("Добавлен " + this.clientName);
        }
    }

    /*
    Класс-админ, добавляющий клиентов в клинику
    Дата 28.11.17
     */
    private static class DeleteAdmin extends Admin {
        private String clientName;

        public DeleteAdmin(Clinic clinic, String clientName) {
            super(clinic);
            this.clientName = clientName;
        }

        @Override
        public void doYourWork() {
            this.clinic.delClient(this.clientName);
            //System.out.println("Удален " + this.clientName);
        }
    }
}