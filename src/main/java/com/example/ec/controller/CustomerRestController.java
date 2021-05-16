package com.example.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ec.model.Customer;
import com.example.ec.service.CustomerService;

/**
 * 顧客画面のコントローラクラス。
 */
@RestController
@RequestMapping("/api/open/customers")
public class CustomerRestController extends BaseRestController<Customer> {

    @Autowired
    CustomerService service;

    @Autowired
    public CustomerRestController(CustomerService service) {
        super(service);
    }

    /**
     * uidで検索。
     * @param uid ユーザID
     * @return 顧客
     */
    @GetMapping("/findbyuid/{uid}")
    public ResponseEntity<Customer> findByUid(@PathVariable String uid) {
        return ResponseEntity.ok(service.findByUid(uid).orElse(null));
    }

    /**
     * チェック。
     *
     * @param customer 顧客画面入力値
     * @return 顧客
     */
    @PostMapping("/validate")
    public ResponseEntity<Customer> validate(@Validated @RequestBody Customer customer) {
        return ResponseEntity.ok(customer);
    }
}
