package ru.lesson.example.servlets;

import ru.lesson.console_clinic.Cat;
import ru.lesson.console_clinic.Client;
import ru.lesson.console_clinic.Clinic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class ClinicServlet extends HttpServlet{
    //final List<Client> clients = new CopyOnWriteArrayList<Client>();
    //final List<Pet> pets = new CopyOnWriteArrayList<Pet>();
    final Clinic clinic = new Clinic(10);
    Client[] foundClients = new Client[0];


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "" + "<html>" + "<head>" +
                "     <title>Pet Clinic</title>" + "</head>" +
                "     <style> .test { margin-bottom:3px;}</style>" +
                "<body>" +
                "     <form action='"+req.getContextPath()+"/' method='post'>" +
                "       Client Name: <input type='text' name='name' class='test'>" + "<br>" +
                "       Pet Name: <input type='text' name='pet'>" + "<br>" +
                "       <input type='submit' value='Submit' name='act'>" + "<br>" +
                "       Find client: <input type='text' name='search'>" + "<br>" +
                "       Enter your pet name:" + "<br>" +
                "       <input type='submit' value='Search' name='act'>" +
                "     <form>"+
                this.viewPets() + this.searchResult() +
                "</body>" + "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.pets.add(new Dog(new Animal(req.getParameter("name"))));
        String act = req.getParameter("act");
        if (act.equals("Submit")) {
            this.clinic.addClient(new Client(req.getParameter("name"),new Cat(req.getParameter("pet"))));
        } else if (act.equals("Search")) {
            this.foundClients = this.clinic.findClientByPetName(req.getParameter("search"));
        }
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuffer sb = new StringBuffer();
        sb.append("<p>Clients</p>");
        sb.append("<table style='border':1px solid black'>");
        sb.append("<tr><td>Client name</td><td>Pet name</td></tr>");
        for(Client cl : this.clinic.clients) {
            sb.append("<tr><td>").append(cl.getId()).append("</td><td>").append(cl.getPet().getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String searchResult() {
        if(this.foundClients.length > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("<p>Clients with pet named</p>").append(this.foundClients[0].getPet().getName());
            sb.append("<br><p>");
            for (Client cl : this.foundClients) {
                sb.append(cl.getId()).append("<br>");
            }
            sb.append("</p>");
            return sb.toString();
        }
        return "";
    }
}
