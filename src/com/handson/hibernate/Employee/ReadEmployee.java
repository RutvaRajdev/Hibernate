package com.handson.hibernate.Employee;

import com.handson.hibernate.Employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployee {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            System.out.println("Reading Employee with id 1");

            session.beginTransaction();

            Employee employee = session.get(Employee.class, 1);

            System.out.println("Employee: "+employee);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {

            factory.close();

        }
    }

}
