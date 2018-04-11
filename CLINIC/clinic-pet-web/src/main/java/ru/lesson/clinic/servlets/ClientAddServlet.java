package ru.lesson.clinic.servlets;

import ru.lesson.clinic.models.ClinicModel;
import ru.lesson.console_clinic.Cat;
import ru.lesson.console_clinic.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientAddServlet extends HttpServlet {
    private final ClinicModel CLINIC_MODEL = ClinicModel.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.CLINIC_MODEL.addClient(new Client(req.getParameter("name"),new Cat(req.getParameter("petname"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
