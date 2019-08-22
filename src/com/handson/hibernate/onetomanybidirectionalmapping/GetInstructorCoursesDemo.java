package com.handson.hibernate.onetomanybidirectionalmapping;

import com.handson.hibernate.onetomanybidirectionalmapping.Entity.Course;
import com.handson.hibernate.onetomanybidirectionalmapping.Entity.Instructor;
import com.handson.hibernate.onetomanybidirectionalmapping.Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstructorCoursesDemo {

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

            System.out.println("Instructor: "+instructor);
            List<Course> courses = instructor.getCourses();

            System.out.println("Courses: "+courses);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
