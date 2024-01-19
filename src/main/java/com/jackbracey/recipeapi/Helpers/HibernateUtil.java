package com.jackbracey.recipeapi.Helpers;

import com.jackbracey.recipeapi.Entities.*;
import com.jackbracey.recipeapi.Entities.MeasurementConversion.MeasurementConversionEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class HibernateUtil {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String datasourceDialect;

    @Value("${spring.datasource.driver-class-name}")
    private String datasourceDriver;

    @Value("${spring.jpa.show-sql}")
    private Boolean showSql;

    private static SessionFactory sessionFactory;

    private SessionFactory buildSessionFactory() {
        try {
            return registerEntityClasses().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    private Configuration registerEntityClasses() {
        Configuration conf = new Configuration()
                .addProperties(getProperties());
        conf.addAnnotatedClass(MeasurementConversionEntity.class);
        conf.addAnnotatedClass(IngredientEntity.class);
        conf.addAnnotatedClass(MeasurementEntity.class);
        conf.addAnnotatedClass(RecipeEntity.class);
        conf.addAnnotatedClass(RecipeOverviewEntity.class);
        conf.addAnnotatedClass(StepEntity.class);
        return conf;
    }

    private Properties getProperties() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", this.datasourceUrl);
        prop.setProperty("hibernate.dialect", this.datasourceDialect);
        prop.setProperty("hibernate.connection.username", this.datasourceUsername);
        prop.setProperty("hibernate.connection.password", this.datasourcePassword);
        prop.setProperty("hibernate.connection.driver_class", this.datasourceDriver);
        prop.setProperty("show_sql", this.showSql.toString());
        return prop;
    }

    public SessionFactory getSessionFactory() {
        if(sessionFactory == null || sessionFactory.isClosed()) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }


}
