package com.handson.hibernate.demo2;

import com.handson.hibernate.demo2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Getting Employee John");

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);

            System.out.println("Employee John: "+employee);
            System.out.println("Upadating employee's company to ABC");

            employee.setCompany("ABC");
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            System.out.println("Reading Updated Employee...");
            session.beginTransaction();

            employee = session.get(Employee.class,1);
            System.out.println("Updated Employee: "+employee);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            sessionFactory.close();
        }
    }
}
