package com.example.GetRide.service;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.dto.response.CustomerResponse;
import com.example.GetRide.model.Customer;
import com.example.GetRide.repository.CustomerRepository;
import com.example.GetRide.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
          //DTO --> entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);


       //Saved Entity --> Response
       return CustomerTransformer.customerTocustomerResponse(savedCustomer);

    }

    public  CustomerResponse getCustomer(String email) {
        Customer savedCustomer =  customerRepository.findByEmailId(email);
        return CustomerTransformer.customerTocustomerResponse(savedCustomer);
    }


    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {

        List<Customer> customers =  customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customerTocustomerResponse(customer));
        }

        return customerResponses;
    }



}
