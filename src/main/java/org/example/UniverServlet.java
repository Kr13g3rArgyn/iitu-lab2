package org.example;

import org.example.db.DBManagerStudent;
import org.example.models.Student;
import org.example.models.University;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/UniverServlet")
public class UniverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/univer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String universityName = request.getParameter("university");
        University university = new University(universityName);
        DBManagerStudent.addUniversity(new University(universityName));
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
