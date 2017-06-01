package io.home.repository;

import io.home.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Vehicle> findAll() {

        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();
    }

    @Override
    public Vehicle findOne(String vin) {
        return em.find(Vehicle.class, vin);
    }

    @Override
    public Vehicle findByVin(String vin) {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findByVin", Vehicle.class);
        query.setParameter("pVin", vin);
        List<Vehicle> resultList = query.getResultList();

        if(resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Vehicle create(Vehicle vc) {
        em.persist(vc);
        return vc;
    }

    @Override
    public Vehicle update(Vehicle vc) {
        return em.merge(vc);
    }

    @Override
    public List<Vehicle> upsert(List<Vehicle> vc) {

        for (Vehicle v: vc) {
            Vehicle existing = findOne(v.getVin());
            if (existing == null) {
                em.persist(v);
            }
            else {
                em.merge(v);
            }
        }
        return vc;
    }


    @Override
    public void delete(Vehicle vc) {
        em.remove(vc);
    }
}
