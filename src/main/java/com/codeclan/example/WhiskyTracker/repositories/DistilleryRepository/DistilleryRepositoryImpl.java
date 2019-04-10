package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional // spring knows that this is a method thats going to access database
    public List<Distillery> findDistilleriesThatHavewhiskiesAged(int age){
        List<Distillery> result = null;

        try {
            Session session = entityManager.unwrap(Session.class); //asking JPA to give us something back from hibernate

            //create query in code
            // hibernate gives a criteria

            Criteria cr = session.createCriteria(Distillery.class); //we want to do a query on a ship and get some ships back

            cr.createAlias("whiskies", "whiskeyAlias");
            cr.add(Restrictions.eq("whiskeyAlias.age", age));

            // when we get this query result we can get different results, here we will get a list of objects back

            result = cr.list(); // result is a list that basically fits the criteria query
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            return result;
        }

    }
}