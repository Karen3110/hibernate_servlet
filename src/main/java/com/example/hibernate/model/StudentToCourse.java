package com.example.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentToCourse {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;


    @Id
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

}
