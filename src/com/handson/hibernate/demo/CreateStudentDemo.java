package com.handson.hibernate.demo;

import com.handson.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            System.out.println("Creating new student object");
            Student tempStudent = new Student("Rutva", "Rajdev", "rutva.rajdev@gmail.com");

            session.beginTransaction();

            System.out.println("Saving student...");
            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
