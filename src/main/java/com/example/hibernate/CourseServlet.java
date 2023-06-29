package com.example.hibernate;

import com.example.hibernate.model.Course;
import com.example.hibernate.service.CourseService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CourseServlet", value = "/course")
public class CourseServlet extends HttpServlet {
    private static final CourseService COURSE_SERVICE = new CourseService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Course course = new Gson().fromJson(request.getReader(), Course.class);

        boolean save = COURSE_SERVICE.save(course);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");


    }

    public void destroy() {
    }
}
