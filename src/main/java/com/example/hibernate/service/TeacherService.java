package com.example.hibernate.service;

import com.example.hibernate.model.Teacher;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherService {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public boolean save(Teacher teacher) {
        if (teacher == null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        transaction.commit();
        session.close();


        return true;
    }
}
