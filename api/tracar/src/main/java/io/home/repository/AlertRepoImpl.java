package io.home.repository;

import io.home.entity.Alert;
import io.home.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class AlertRepoImpl implements AlertRepo{

    @PersistenceContext
    private EntityManager em;


    @Override
    public Reading create(Reading rd, String priority, String alert) {
        Alert al=new Alert();
        al.setVin(rd.getVin());
        al.setRin(rd.getRin());
        al.setAlert(alert);
        al.setPriority(priority);
        em.persist(al);
        return rd;
    }
}
