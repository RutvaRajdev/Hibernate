package com.handson.hibernate.demo2;

import com.handson.hibernate.demo2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Reading Employee with id=1");

            session.beginTransaction();
            Employee employee = session.get(Employee.class,1);

            System.out.println("Employee: "+employee);

            System.out.println("Deleting Employee");
            session.delete(employee);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            sessionFactory.close();
        }
    }
}
