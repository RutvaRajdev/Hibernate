package com.handson.hibernate.onetoonemapping;

import com.handson.hibernate.onetoonemapping.entity.Instructor;
import com.handson.hibernate.onetoonemapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("InstructorDetail: "+instructorDetail);
            System.out.println("Associated instructor: "+instructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally
        {
            session.close();
            factory.close();
        }
    }
}
