package io.home.service;


import io.home.entity.Reading;
import io.home.entity.Vehicle;
import io.home.repository.AlertRepo;
import io.home.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertServiceImpl implements AlertService{

    @Autowired
    private AlertRepo repo;

    @Autowired
    private VehicleRepository repository;

    @Override
    @Transactional
    public Reading create(Reading rd) {

        Vehicle vc = repository.findOne(rd.getVin());

        if (rd.getEngineRpm() > vc.getReadlineRpm()) {
            repo.create(rd,"High","Engine RPM High");
        }

        if (rd.getFuelVolume() < (0.1* vc.getMaxFuelVolume())){
            repo.create(rd,"Medium","Fuel Refill Required");
        }

        if ((rd.getTires().getFrontLeft()>32)||(rd.getTires().getFrontLeft()<36)){
            repo.create(rd,"Low","Front Left Tire Pressure Needs to be checked");
        }
        if((rd.getTires().getFrontRight()>32)||(rd.getTires().getFrontRight()<36)){
            repo.create(rd,"Low","Front Right Tire Pressure Needs to be checked");
        }
        if((rd.getTires().getRearLeft()>32)||(rd.getTires().getRearLeft()<36)){
            repo.create(rd,"Low","Rear Left Tire Pressure Needs to be checked");
        }

        if((rd.getTires().getRearRight()>32)||(rd.getTires().getRearRight()<36)){
             repo.create(rd,"Low","Rear Right Tire Pressure Needs to be checked");
        }
        if (rd.isEngineCoolantLow()||rd.isCheckEngineLightOn()){
            repo.create(rd,"Low","Engine Failure");
        }
        return rd;
    }
}
