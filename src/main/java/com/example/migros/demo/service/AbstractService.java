package com.example.migros.demo.service;


import com.example.migros.demo.repository.AbstractRepository;

public abstract class AbstractService {
    private final AbstractRepository repository;


    protected AbstractService(AbstractRepository repository) {
        this.repository = repository;
    }

}

