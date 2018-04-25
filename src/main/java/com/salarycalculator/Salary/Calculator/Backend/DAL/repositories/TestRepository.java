package com.salarycalculator.Salary.Calculator.Backend.DAL.repositories;
import com.salarycalculator.Salary.Calculator.Backend.DAL.hibernate.util.HibernateUtil;
import com.salarycalculator.Salary.Calculator.Backend.DAL.entities.TestEntity;
import org.hibernate.Session;

public class TestRepository {

    public static void saveTest(TestEntity test){
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(TestEntity);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
