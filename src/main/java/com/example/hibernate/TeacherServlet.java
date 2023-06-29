package com.example.hibernate;

import com.example.hibernate.model.Teacher;
import com.example.hibernate.service.TeacherService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TeacherServlet", value = "/teacher")
public class TeacherServlet extends HttpServlet {
    private static final TeacherService TEACHER_SERVICE = new TeacherService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teacher teacher = new Gson().fromJson(request.getReader(), Teacher.class);
        boolean save = TEACHER_SERVICE.save(teacher);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");


    }

    public void destroy() {
    }

}
