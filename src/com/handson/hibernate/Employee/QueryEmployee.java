package com.handson.hibernate.Employee;

import com.handson.hibernate.Employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployee {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Querying Armedia employees");

            session.beginTransaction();
            List<Employee> employees = session.createQuery("from Employee where company='Armedia'").list();

            for(Employee employee : employees)
                System.out.println(employee);

            session.getTransaction().commit();

            System.out.println("Done!");


        }
        finally {
            sessionFactory.close();
        }
    }
}
