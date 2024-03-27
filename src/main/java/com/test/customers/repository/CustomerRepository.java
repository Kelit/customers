package com.test.customers.repository;

import com.test.customers.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer getCustomerByName(String name);
    List<Customer> getAllBy();
    Customer getCustomerById(Long id);
//    List<Customer> getAllBy
}