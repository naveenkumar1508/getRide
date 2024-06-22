package com.example.GetRide.service;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Cab;
import com.example.GetRide.model.Driver;
import com.example.GetRide.repository.DriverRepository;
import com.example.GetRide.transformer.CabTransformer;
import com.example.GetRide.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;
    public String addDriverAndCab(DriverRequest driverRequest) {

        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.CabRequestToCab(driverRequest.getCabRequest());
        driver.setCab(cab);
        cab.setDriver(driver);

        //Save both Driver and Cab
        driverRepository.save(driver);
        return "Driver Registered Sucessfully";

    }

    public DriverResponse getDriver(long mobileNumber) {
        Driver savedDriver = driverRepository.findByMobileNumber(mobileNumber);
        //Entity to response dto
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }
}
