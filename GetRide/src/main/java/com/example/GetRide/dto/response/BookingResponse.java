package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.BookingStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    private String bookingId;

    private String pickup;

    private  String destination;


    private BookingStatus bookingStatus;

    private double totalDistance;

    private double totalFare;


    private Date bookedAt;

    CustomerResponse customerResponse;

  DriverResponse driverResponse;
}
