package com.example.GetRide.service;

import com.example.GetRide.Exception.CabNotFoundException;
import com.example.GetRide.Exception.CustomerNotFoundException;
import com.example.GetRide.dto.request.BookingRequest;
import com.example.GetRide.dto.response.BookingResponse;
import com.example.GetRide.model.Booking;
import com.example.GetRide.model.Cab;
import com.example.GetRide.model.Customer;
import com.example.GetRide.model.Driver;
import com.example.GetRide.repository.BookingRepository;
import com.example.GetRide.repository.CabRepository;
import com.example.GetRide.repository.CustomerRepository;
import com.example.GetRide.repository.DriverRepository;
import com.example.GetRide.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.awt.print.Book;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

//    @Autowired
   private final CustomerRepository customerRepository;

//    @Autowired
   private final CabRepository cabRepository;

  //  @Autowired
   private final  DriverRepository driverRepository;

   // @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest) {
     Customer customer = customerRepository.findByEmailId(bookingRequest.getCustomerEmail());
     if(ObjectUtils.isEmpty(customer)){
         throw  new CustomerNotFoundException("Invalid email Id");
     }

        Optional<Cab> optionalCab = cabRepository.getRandomAvailableCab();
     if(optionalCab.isEmpty()){
         throw new CabNotFoundException("Seems like all the Drivers are Busy");
     }

     Cab cab = optionalCab.get();
     Driver driver  = cab.getDriver();
     cab.setBooked(true);

     //Booking Entity
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,cab);
        booking.setCustomer(customer);
        booking.setDriver(driver);
        Booking savedBooking = bookingRepository.save(booking);


        //Setting the remaining Attributes
        customer.getBookings().add(savedBooking);
        driver.getBookings().add(savedBooking);


        customerRepository.save(customer); // saves Customer + savedBooking
        driverRepository.save(driver);  //Saves Driver + savedBooking

        sendMail(savedBooking);
        //prepare response dto
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }

    private void sendMail(Booking booking) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("naveenpatel42044@gmail.com");
        simpleMailMessage.setTo(booking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Booking Confirmed!!");
        simpleMailMessage.setText("Congrats! " + booking.getCustomer().getName()
                                  + "  Your ride is Confirmed! " +" Your booking Id is: "
                                  + booking.getBookingId());

        javaMailSender.send(simpleMailMessage);
    }
}
