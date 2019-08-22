package com.handson.hibernate.onetomanymapping;

import com.handson.hibernate.onetomanymapping.Entity.Course;

import com.handson.hibernate.onetomanymapping.Entity.Instructor;
import com.handson.hibernate.onetomanymapping.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Jane", "Doe", "jane.doe@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/janedoe", "Gaming");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor: "+instructor);
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
