package com.dvn.estock.core;

import com.dvn.estock.core.configuration.DatabaseConfig;
//import com.dvn.estock.core.configuration.HibernateConfig;
import com.dvn.estock.core.util.ConstantEnv;

//import org.hibernate.Session;

public class AppTest {
    
    public static void main(String[] args) {
        /**
         *
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(result);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        
        session.getTransaction().commit();
        
        HibernateConfig.shutdown();
        * 
        */
        
        System.out.println(DatabaseConfig.getDialect());
        System.out.println(ConstantEnv.getDatabaseConfEnv());
    }
}
