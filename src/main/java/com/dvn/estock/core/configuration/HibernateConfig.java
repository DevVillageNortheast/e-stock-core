package com.dvn.estock.core.configuration;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfig{

    private static StandardServiceRegistry registry;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try{
            // Create registry builder
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            // Hibernate settings equivalent to hibernate.cfg.xml's properties
            Map<String, String> settings = new HashMap<String,String>();
            
            settings.put(Environment.DRIVER, DatabaseConfig.getDrive());
            settings.put(Environment.URL, DatabaseConfig.getUrl());
            settings.put(Environment.USER, DatabaseConfig.getUser());
            settings.put(Environment.PASS, DatabaseConfig.getPassword());
            settings.put(Environment.DIALECT, DatabaseConfig.getDialect());
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");

            // Apply settings
            registryBuilder.applySettings(settings);

            // Create registry
            registry = registryBuilder.build();

            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            return metadata.getSessionFactoryBuilder().build();

        }catch(Throwable e){
            System.err.println("Falha ao inicial a SessionFactory." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}