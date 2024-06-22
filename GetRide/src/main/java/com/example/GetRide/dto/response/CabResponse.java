package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.CabType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {

    private String cabNumber;

    private CabType cabType;

    private double farePerKm;

    private boolean booked;
}
