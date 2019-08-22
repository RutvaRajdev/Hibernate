package com.handson.hibernate.onetomanymapping;

import com.handson.hibernate.onetomanymapping.Entity.Course;
import com.handson.hibernate.onetomanymapping.Entity.Instructor;
import com.handson.hibernate.onetomanymapping.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            int id=1;
            Instructor instructor = session.get(Instructor.class, id);

            Course course1 = new Course("Introduction to programming");
            Course course2 = new Course("Software Development");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
