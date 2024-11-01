package com.app.reactiveCurdOPeration.controller;

import com.app.reactiveCurdOPeration.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
    private static final Logger logger= LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @PostMapping("/create/customer")
    public Mono<Customer> saveCustomer(@RequestBody Customer customer){
        logger.info("saving customer data {}",customer);
        return reactiveMongoTemplate.save(customer);
    }
    @GetMapping("customerId")
    public Mono<Customer> getCustomerById(@RequestParam("customerId") String customerId){
        Criteria criteria = Criteria.where("id").is(customerId);
        Query query = Query.query(criteria);
        return reactiveMongoTemplate.findOne(query,Customer.class);
    }
    @GetMapping("list")
    public Flux<Customer> getCustomers(){
        System.out.println(reactiveMongoTemplate.findAll(Customer.class).log());
        return reactiveMongoTemplate.findAll(Customer.class);
    }
}
