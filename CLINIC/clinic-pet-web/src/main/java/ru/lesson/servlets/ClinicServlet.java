package ru.lesson.servlets;

import ru.lesson.clinic.Animal;
import ru.lesson.clinic.Client;
import ru.lesson.clinic.Dog;
import ru.lesson.clinic.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 */
public class ClinicServlet extends HttpServlet{
    final List<Client> clients = new CopyOnWriteArrayList<Client>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "" + "<html>" + "<head>" +
                "     <title>Pet Clinic</title>" + "</head>" +
                "<body>" +
                "     <form action='"+req.getContextPath()+"/' method='post'>" +
                "       Name: <input type='text' name='name'>" +
                "       <input type='submit' value='Submit'>" +
                "     <form>"+
                this.viewPets() +
                "</body>" + "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.pets.add(new Dog(new Animal(req.getParameter("name"))));
        doGet(req, resp);
    }

    private String viewPets() {
        StringBuffer sb = new StringBuffer();
        sb.append("<p>Pets</p>");
        sb.append("<table style='border':1px solid black'>");
        for(Pet pet : this.pets) {
            sb.append("<tr><td style='border:1px solid black'>").append(pet.getName()).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
