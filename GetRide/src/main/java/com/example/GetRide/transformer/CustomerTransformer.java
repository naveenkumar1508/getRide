package com.example.GetRide.transformer;

import com.example.GetRide.dto.request.CustomerRequest;
import com.example.GetRide.dto.response.CustomerResponse;
import com.example.GetRide.model.Customer;

public class CustomerTransformer {


    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){

        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
//        Customer customer = new Customer();
//        customer.setAge(customerRequest.getAge());
//        customer.setName(customerRequest.getName());
//        customer.setGender(customerRequest.getGender());
//        customer.setEmailId(customerRequest.getEmailId());

       // return customer;
    }
    public static CustomerResponse customerTocustomerResponse(Customer customer){

       return CustomerResponse.builder()
                .name(customer.getName())
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .build();
//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setName(customer.getName());
//        customerResponse.setGender(customer.getGender());
//        customerResponse.setEmailId(customer.getEmailId());

       // return customerResponse;
    }
}
