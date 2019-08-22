package com.handson.hibernate.onetomanybidirectionalmapping;

import com.handson.hibernate.onetomanybidirectionalmapping.Entity.Course;
import com.handson.hibernate.onetomanybidirectionalmapping.Entity.Instructor;
import com.handson.hibernate.onetomanybidirectionalmapping.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            System.out.println("Getting course with id 10");
            Course course = session.get(Course.class, 10);

            System.out.println("Course: "+course);
            session.delete(course);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
