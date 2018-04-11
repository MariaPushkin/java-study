package ru.lesson.clinic.servlets;

import ru.lesson.clinic.models.ClinicModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientViewServlet extends HttpServlet {
    private final ClinicModel CLINIC_MODEL = ClinicModel.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!CLINIC_MODEL.getClients().isEmpty()) {
            System.out.println(CLINIC_MODEL.getClients().get(0).getId());
        }
        req.setAttribute("clients", CLINIC_MODEL.getClients());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/Clinic.jsp");
        dispatcher.forward(req, resp);
    }
}
