package com.gwumonitor.demo.controller;
import com.gwumonitor.demo.model.Customer;
import com.gwumonitor.demo.model.Resource;
import com.gwumonitor.demo.model.Usage;
import com.gwumonitor.demo.repository.ResourceRepository;
import com.gwumonitor.demo.repository.UsageRepository;
import com.gwumonitor.demo.utils.Response;
import com.gwumonitor.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UsageRepository usageRepository;
    @Autowired
    ResourceRepository resourceRepository;

    @GetMapping("/all")
    ResponseEntity<?> findAll(){
        try {
            return Response.result(customerRepository.findAll());
        }catch (Exception e){
            return Response.error(e);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewCustomer(@RequestBody Customer customer) {
        try {
            LocalDateTime instance = LocalDateTime.now();
            Customer newCustomer = customerRepository.save(customer);
            List<Resource> resourceArrayList = new ArrayList<>();
            resourceArrayList = resourceRepository.findAll();
            resourceArrayList.forEach(resource -> {
                Usage usage = new Usage(customer.getId(),resource.getId(),0, instance );
                usageRepository.save(usage);
            });

            return Response.result(customerRepository.save(customer));
        }catch (Exception e) {
            return Response.error(e);
        }
    }

    @GetMapping("/getById")
    ResponseEntity<?> getByResourceId(@RequestParam("id") long id){
        try{
            return Response.result(customerRepository.findById(id));
        }catch (Exception e){
            return Response.error(e);
        }
    }




}
