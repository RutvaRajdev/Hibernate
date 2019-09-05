package com.handson.hibernate.manytomanymapping;


import com.handson.hibernate.manytomanymapping.entity.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course course = new Course("Pacman");

            System.out.println("Saving the course");
            session.save(course);
            System.out.println(course);

            Student student = new Student("John", "Doe", "john.doe@gmail.com");
            Student student1 = new Student("Jane", "Brooks", "jane.brooks@gmail.com");

            course.addStudent(student);
            course.addStudent(student1);

            System.out.println("Saving Students");
            session.save(student);
            session.save(student1);
            System.out.println("Saved Students: "+course.getStudents());

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
