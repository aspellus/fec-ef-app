package com.salientcrgt.ezamendment.init;


import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * This is a initializing bean that inserts some test data in the database. 
 *
 */
@Component
public class TestDataInitializer {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public void init() throws Exception {

        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        
        /*Transaction transaction = session.beginTransaction();

        ScheduleA scheduleA = new ScheduleA("", "", "", "", "", "", "", "", "", "", "", "", 
        		"", "", "", "", "", "", "", "", "", "", "", "");

        session.persist(scheduleA);

        session.persist(scheduleA);
        transaction.commit();*/
    }
}
