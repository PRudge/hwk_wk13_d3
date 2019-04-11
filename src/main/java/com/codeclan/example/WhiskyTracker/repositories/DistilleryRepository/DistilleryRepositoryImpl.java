package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findDistilleriesThatHaveWhiskiesAged(int age) {
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whiskyAlias");
            cr.add(Restrictions.eq("whiskyAlias.age", age));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

//package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
//
//public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {
//}