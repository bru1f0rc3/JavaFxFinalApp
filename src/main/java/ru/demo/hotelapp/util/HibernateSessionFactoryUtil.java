package ru.demo.hotelapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try{
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
                sessionFactory = cfg.buildSessionFactory();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
