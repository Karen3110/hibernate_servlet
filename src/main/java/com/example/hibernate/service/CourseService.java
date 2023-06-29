package com.example.hibernate.service;

import com.example.hibernate.model.Course;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CourseService {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public boolean save(Course course) {
        if (course == null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();

        return true;
    }
}
