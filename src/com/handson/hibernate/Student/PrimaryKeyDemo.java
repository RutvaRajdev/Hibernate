package com.handson.hibernate.Student;

import com.handson.hibernate.Student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("Creating 3 student objects");
            Student tempStudent1 = new Student("Rutva", "Rajdev", "rutva.rajdev@gmail.com");
            Student tempStudent2 = new Student("Sakshi", "Rajdev", "sakshi.rajdev@gmail.com");
            Student tempStudent3 = new Student("John", "Doe", "john.doe@gmail.com");


            session.beginTransaction();

            System.out.println("Saving student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
