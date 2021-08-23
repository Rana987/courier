package com.example.migros.demo.controller;


import com.example.migros.demo.dto.CourierLocationRequestDto;
import com.example.migros.demo.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couriers")
public class CourierController {

    @Autowired
    CourierService courierService;

    @PostMapping
    public ResponseEntity<Void> insertCourierLocation(@RequestBody CourierLocationRequestDto courierLocationRequestDto) {
        courierService.insertCourierLocation(courierLocationRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Double> getTotalTravelDistance(@PathVariable Integer id) {
        double totalTravelDistance = courierService.getTotalTravelDistance(id);
        return new ResponseEntity<>(totalTravelDistance, HttpStatus.OK);
    }

}
