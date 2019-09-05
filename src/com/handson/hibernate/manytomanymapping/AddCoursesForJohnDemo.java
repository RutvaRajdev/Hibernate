package com.handson.hibernate.manytomanymapping;


import com.handson.hibernate.manytomanymapping.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForJohnDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            System.out.println("Getting John from database");
            Student john = session.get(Student.class, 1);
            System.out.println(john);
            System.out.println("Courses: "+john.getCourses());

            Course course = new Course("Rubik's Cube");
            Course course1 = new Course("Mario Bros");

            course.addStudent(john);
            course1.addStudent(john);

            System.out.println("Saving Courses");
            session.save(course);
            session.save(course1);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
