package com.example.GetRide.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookingRequest {

    private String pickup;

    private  String destination;

    private double totalDistance;

    private String customerEmail;
}
