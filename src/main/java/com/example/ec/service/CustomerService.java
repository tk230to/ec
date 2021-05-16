package com.example.ec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.model.Customer;
import com.example.ec.repository.CustomerMapper;
import com.example.ec.repository.CustomerRepository;

import lombok.Getter;

@Service
@Getter
public class CustomerService extends BaseService<Customer> {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerMapper mapper;

    @Autowired
    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        super(repository, mapper);
    }

    public Optional<Customer> findByUid(String uid) {
        return mapper.findByUid(uid);
    }
}
