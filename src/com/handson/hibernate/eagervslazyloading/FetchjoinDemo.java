package com.handson.hibernate.eagervslazyloading;

import com.handson.hibernate.eagervslazyloading.Entity.Course;
import com.handson.hibernate.eagervslazyloading.Entity.Instructor;
import com.handson.hibernate.eagervslazyloading.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchjoinDemo {

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

            int id = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "where i.id=:theInstructorId",
                    Instructor.class);

            query.setParameter("theInstructorId", id);

            Instructor instructor = query.getSingleResult();

            System.out.println("New: Instructor: " + instructor);

            session.getTransaction().commit();
            session.close();

            System.out.println("Session Closed");

            System.out.println("Courses: "+instructor.getCourses());

            System.out.println("New: Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
