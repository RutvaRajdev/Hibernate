package com.handson.hibernate.onetoonemapping;

import com.handson.hibernate.onetoonemapping.entity.Instructor;
import com.handson.hibernate.onetoonemapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 1 ;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("Found instructor: "+instructor);

            if(instructor != null) {
                System.out.println("Deleting: "+instructor);
                session.delete(instructor);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
