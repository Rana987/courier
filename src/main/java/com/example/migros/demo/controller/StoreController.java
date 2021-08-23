package com.example.migros.demo.controller;


import com.example.migros.demo.dto.StoresDto;
import com.example.migros.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping
    public ResponseEntity<List<StoresDto>> getAllStores() {
        return new ResponseEntity<>(storeService.getAllStores(),
                HttpStatus.OK);
    }
}
