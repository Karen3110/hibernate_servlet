package com.example.hibernate.service;

import com.example.hibernate.model.Student;
import com.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentService {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public boolean save(Student student) {


        if (student == null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();


        return true;
    }

    public Student get(Integer studentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT student FROM Student student LEFT JOIN FETCH student.courses course WHERE student.id = :studentId";

        Query<Student> query = session.createQuery(hql, Student.class);
        query.setParameter("studentId", studentId);

        Student student = query.uniqueResult();


        transaction.commit();
        session.close();

        return student;
    }
}
