package com.gwumonitor.demo.controller;

import com.gwumonitor.demo.model.Resource;
import com.gwumonitor.demo.repository.CustomerRepository;
import com.gwumonitor.demo.repository.ResourceRepository;
import com.gwumonitor.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    ResourceRepository resourceRepository;

    @GetMapping("/all")
    ResponseEntity<?> findAll(){
        try {
            return Response.result(resourceRepository.findAll());
        }catch (Exception e){
            return Response.error(e);
        }
    }

    @GetMapping("/getById")
    ResponseEntity<?> getByResourceId(@RequestParam("id") long id){
        try{
            return Response.result(resourceRepository.findById(id));
        }catch (Exception e){
            return Response.error(e);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?> addNewResource(@RequestBody Resource resource) {
        try {
            return Response.result(resourceRepository.save(resource));
        }catch (Exception e) {
            return Response.error(e);
        }

    }
}
