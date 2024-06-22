package com.example.GetRide.repository;

import com.example.GetRide.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
