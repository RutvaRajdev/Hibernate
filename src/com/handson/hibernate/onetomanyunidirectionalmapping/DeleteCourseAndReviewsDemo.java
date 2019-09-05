package com.handson.hibernate.onetomanyunidirectionalmapping;


import com.handson.hibernate.onetomanyunidirectionalmapping.entity.Course;
import com.handson.hibernate.onetomanyunidirectionalmapping.entity.Instructor;
import com.handson.hibernate.onetomanyunidirectionalmapping.entity.InstructorDetail;
import com.handson.hibernate.onetomanyunidirectionalmapping.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 10;

            //System.out.println("Getting course");
            Course course = session.get(Course.class, id);

            System.out.println("Deleting course");
            System.out.println(course);

            System.out.println(course.getReviews());

            session.delete(course);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
