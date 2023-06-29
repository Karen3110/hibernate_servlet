package com.example.hibernate;


import com.example.hibernate.model.Student;
import com.example.hibernate.service.StudentService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class StudentServlet extends HttpServlet {
    private static final StudentService STUDENT_SERVICE = new StudentService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = new Gson().fromJson(request.getReader(), Student.class);
        boolean save = STUDENT_SERVICE.save(student);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        Integer studentId = Integer.valueOf(req.getParameter("student_id"));
        Student student = STUDENT_SERVICE.get(studentId);
        resp.getWriter().write(new Gson().toJson(student));
    }

    public void destroy() {
    }
}
