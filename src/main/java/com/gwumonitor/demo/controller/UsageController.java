package com.gwumonitor.demo.controller;

import com.gwumonitor.demo.model.Customer;
import com.gwumonitor.demo.model.Resource;
import com.gwumonitor.demo.model.Usage;
import com.gwumonitor.demo.repository.CustomerRepository;
import com.gwumonitor.demo.repository.ResourceRepository;
import com.gwumonitor.demo.repository.UsageRepository;
import com.gwumonitor.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usage")
public class UsageController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UsageRepository usageRepository;
    @Autowired
    ResourceRepository resourceRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addUsage(@RequestParam(value = "customerId") long customerId,
                                      @RequestParam(value = "resourceId") long resourceId,
                                      @RequestParam(value = "usage") float usage) {
        try {
          LocalDateTime instance = LocalDateTime.now();
          Usage newUsage = new Usage(customerId,resourceId,usage,instance);

            return Response.result(usageRepository.save(newUsage));
        }catch (Exception e) {
            return Response.error(e);
        }
    }

    @GetMapping("/all")
    ResponseEntity<?> findAll(){
        try {
            return Response.result(usageRepository.findAll());
        }catch (Exception e){
            return Response.error(e);
        }
    }

    @GetMapping("/getByCustomerIdAndResId")
    ResponseEntity<?> getUsageByCustomerIdAndResID(@RequestParam(value = "customerId") long customerId,
                                                   @RequestParam(value = "resourceId") long resourceId){
        try{
            return Response.result(usageRepository.findByCustomerIdAndResourceId(customerId,resourceId));
        }catch (Exception e){
            return Response.error(e);
        }
    }




}
