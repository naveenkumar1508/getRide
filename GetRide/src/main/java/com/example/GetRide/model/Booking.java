package com.example.GetRide.model;

import com.example.GetRide.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookingId;

    private String pickup;

    private  String destination;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private double totalDistance;

    private double totalFare;

    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToOne
    @JoinColumn
    private Driver driver;
}
