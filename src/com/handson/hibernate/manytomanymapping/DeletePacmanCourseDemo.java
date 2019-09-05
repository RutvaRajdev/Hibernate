package com.handson.hibernate.manytomanymapping;


import com.handson.hibernate.manytomanymapping.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {

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

            System.out.println("Getting Pacman course");
            Course course = session.get(Course.class, 10);

            System.out.println("Deleting course");
            session.delete(course);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
