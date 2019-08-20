package com.handson.hibernate.demo;

import com.handson.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Rajdev'").list();

            System.out.println("\nStudents with last name 'Rajdev'");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.firstName='John' OR s.lastName='Rajdev'").list();
            System.out.println("\nStudents with last name 'Doe' or 'Rajdev'");
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
            System.out.println("\n");
            displayStudents(theStudents);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
