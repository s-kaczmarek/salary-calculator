package com.salarycalculator.Salary.Calculator.Backend.DAL.hibernate.util;

import org.hibernate.SessionFactory;
import javax.websocket.Session;
import java.lang.module.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError("Blad polaczenia z baza danych!");
        }
    }

    public static Session openSession() throws Exception {
        Session session;
        try {
            session = sessionFactory.openSession();
        } catch (Exception e) {
            throw new Exception("Blad polaczenia z baza danych!");
        }
        return session;
    }
}
