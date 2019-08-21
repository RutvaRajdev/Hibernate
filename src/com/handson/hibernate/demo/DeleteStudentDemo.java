package com.handson.hibernate.demo;

import com.handson.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

           int studentId=5;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id:"+studentId);

            Student student = session.get(Student.class, studentId);

//            System.out.println("Deleting student: "+student);
//            session.delete(student);

            System.out.println("Deleting student id=4");
            session.createQuery("delete from Student where id=4").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
