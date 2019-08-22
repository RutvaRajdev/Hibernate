package com.handson.hibernate.Instructor;

import com.handson.hibernate.Instructor.entity.Instructor;
import com.handson.hibernate.Instructor.entity.InstructorDetail;
import com.handson.hibernate.Student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

//            Instructor instructor = new Instructor("John", "Doe", "john.doe@gmail.com");
//            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/JohnDoe", "Teaching");

            Instructor instructor = new Instructor("ABC", "DEF", "abc.def@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/abcd", "Music");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            System.out.println("Saving Instructor: "+instructor);
            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
