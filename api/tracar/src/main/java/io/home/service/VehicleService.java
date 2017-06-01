package io.home.service;

import io.home.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle create(Vehicle vc);

    Vehicle update(String vin, Vehicle vc);

    List<Vehicle> upsert(List<Vehicle> vc);

    void delete(String vin);
}
