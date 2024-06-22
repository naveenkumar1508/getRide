package com.example.GetRide.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {

    private String name;
    private long mobileNumber;
    CabResponse cab;
}
