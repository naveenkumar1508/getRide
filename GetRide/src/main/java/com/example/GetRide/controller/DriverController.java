package com.example.GetRide.controller;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Driver;
import com.example.GetRide.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest){

        String response = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }

    @GetMapping
    public DriverResponse getDriver(@RequestParam("mob-no") long mobileNumber){
        return  driverService.getDriver(mobileNumber);
    }
}
