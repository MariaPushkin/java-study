package ru.lesson.clinic.servlets;

import ru.lesson.clinic.models.ClinicModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientEditServlet extends HttpServlet {
    int clientPosition;

    private final ClinicModel CLINIC_MODEL = ClinicModel.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clientPosition = CLINIC_MODEL.findClientPositionByName(req.getParameter("name"));
        req.setAttribute("client", CLINIC_MODEL.getClient(clientPosition));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/ClientEdit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.CLINIC_MODEL.editClientPet(clientPosition, req.getParameter("petname"));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
