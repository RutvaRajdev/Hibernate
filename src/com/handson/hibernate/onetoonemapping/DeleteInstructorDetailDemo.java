package com.handson.hibernate.onetoonemapping;

import com.handson.hibernate.onetoonemapping.entity.Instructor;
import com.handson.hibernate.onetoonemapping.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("InstructorDetail: "+instructorDetail);
            System.out.println("Associated instructor: "+instructorDetail.getInstructor());

            System.out.println("Deleting instructor detail: "+instructorDetail);

            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

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
