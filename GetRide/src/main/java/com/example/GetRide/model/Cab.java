package com.example.GetRide.model;

import com.example.GetRide.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Cab {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cabNumber;

    private CabType cabType;

    private double farePerKm;

    private boolean booked;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Driver driver;
}
