package com.handson.hibernate.eagervslazyloading;

import com.handson.hibernate.eagervslazyloading.Entity.Course;
import com.handson.hibernate.eagervslazyloading.Entity.Instructor;
import com.handson.hibernate.eagervslazyloading.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EagerLazyDemo {

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

            System.out.println("New: Instructor: "+instructor);
            List<Course> courses = instructor.getCourses();

            System.out.println("New: Courses: "+courses);

            session.getTransaction().commit();

            System.out.println("New: Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
