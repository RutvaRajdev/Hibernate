package com.handson.hibernate.Employee;

import com.handson.hibernate.Employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Employee employee = new Employee("Vish", "Busa", "Salesforce");

            System.out.println("Creating Employee: "+employee);
            session.beginTransaction();

            System.out.println("Saving Employee...");
            session.save(employee);

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }
    }
}
