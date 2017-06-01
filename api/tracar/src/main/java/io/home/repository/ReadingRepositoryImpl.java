package io.home.repository;

import io.home.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Reading create(Reading rd) {

        em.persist(rd);
        return rd;
    }
}
