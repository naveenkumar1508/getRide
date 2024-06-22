package com.example.GetRide.dto.request;

import com.example.GetRide.model.Cab;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverRequest {

    private String name;

    private int age;

    private String drivingLicense;

    private long mobileNumber;

    private CabRequest cabRequest;
}
