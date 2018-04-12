package ru.lesson.clinic.servlets;

import ru.lesson.clinic.models.ClinicModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientDeleteServlet extends HttpServlet {
    private final ClinicModel CLINIC_MODEL = ClinicModel.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.CLINIC_MODEL.delClient(req.getParameter("name"));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
