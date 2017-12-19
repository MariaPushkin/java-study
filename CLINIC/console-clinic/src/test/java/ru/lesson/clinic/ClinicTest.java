package ru.lesson.clinic;

import junit.framework.Assert;
import org.junit.Test;
import ru.lesson.console_clinic.Cat;
import ru.lesson.console_clinic.Clinic;
import ru.lesson.console_clinic.Client;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClinicTest {
    @Test
    public void addClient() throws Exception {
        Clinic testClinic = new Clinic(10);
        Client testClient = new Client("Ann",new Cat("Sandy"));
        testClinic.addClient(testClient);
        Assert.assertEquals(testClient,testClinic.getClient(0));
        Client testClient2 = new Client("Kap",new Cat("Sandy"));
        Client testClient3 = new Client("Kap",new Cat("Pop"));
        Assert.assertTrue(testClinic.addClient(testClient2));
        Assert.assertFalse(testClinic.addClient(testClient3));
    }

    @Test
    public void findClientByPetName() throws Exception {
        Clinic testClinic = new Clinic(10);
        Client testClient1 = new Client("Ann",new Cat("Sandy"));
        Client testClient2 = new Client("Kap",new Cat("Sandy"));
        testClinic.addClient(testClient1);
        testClinic.addClient(testClient2);
        Client[] foundClients = testClinic.findClientByPetName("Sandy");
        Assert.assertEquals(foundClients[0].getId(),"Ann");
        Assert.assertEquals(foundClients[1].getId(),"Kap");
    }

    @Test
    public void delClient() throws Exception {
        Clinic testClinic = new Clinic(10);
        testClinic.addClient(new Client("Client4",new Cat("Sandy")));
        testClinic.addClient(new Client("Client1",new Cat("Sandy")));
        Assert.assertTrue(testClinic.delClient("Client1"));
        Assert.assertFalse(testClinic.delClient("Client2"));
        testClinic.addClient(new Client("Client2",new Cat("Sandy")));
        testClinic.addClient(new Client("Client3",new Cat("Sandy")));
        Assert.assertTrue(testClinic.delClient("Client4"));
        for(int i = 0; i < testClinic.getCurrCol(); i++) {
            System.out.println(testClinic.getClient(i).getId());
        }
    }

}