package io.home.service;

import io.home.entity.Vehicle;
import io.home.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Vehicle vc = repository.findOne(vin);
        if (vc == null) {
            throw new io.home.Exception.NotFoundException("Employee with id=" + vin + " not found");
        }
        return vc;
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle vc) {
        Vehicle existing = repository.findByVin(vc.getVin());
        if (existing != null) {
            throw new io.home.Exception.BadRequestException("Employee with email=" + vc.getVin() + " already exist");
        }
        return repository.create(vc);
    }

    @Override
    @Transactional
    public Vehicle update(String vin, Vehicle vc) {
        Vehicle existing = repository.findOne(vin);
        if (existing == null) {
            throw new io.home.Exception.NotFoundException("Employee with id=" + vin + " not found");
        }
        return repository.update(vc);
    }

    @Override
    @Transactional
    public List<Vehicle> upsert(List<Vehicle> vc) {

        return repository.upsert(vc);
    }

    @Override
    @Transactional
    public void delete(String vin) {
        Vehicle existing = repository.findOne(vin);
        if (existing == null) {
            throw new io.home.Exception.NotFoundException("Employee with id=" + vin + " not found");
        }
        repository.delete(existing);
    }
}
