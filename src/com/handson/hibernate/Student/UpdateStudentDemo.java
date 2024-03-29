package com.handson.hibernate.Student;

import com.handson.hibernate.Student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

           int studentId=1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id:"+studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("Get complete: "+student);

            student.setFirstName("ketan");

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Updating email for all students");

            session.createQuery("Update Student set email = 'foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
