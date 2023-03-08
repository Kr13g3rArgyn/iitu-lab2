package org.example;

import org.example.db.DBManagerStudent;
import org.example.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/StudentServlet" )
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        int age = Integer.parseInt(request.getParameter("age"));
        String universityName = request.getParameter("university");
        int university = DBManagerStudent.getUniversity(universityName);

        Student  student = new Student(fname,lname,age,university);
        DBManagerStudent.addStudent(student);

        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
