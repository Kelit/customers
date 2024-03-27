package com.test.customers.service;

import com.test.customers.model.Customer;
import com.test.customers.model.Email;
import com.test.customers.model.Phone;
import com.test.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CustomersService {

    @Autowired
    private CustomerRepository customerRepository;
    @Transactional
    public ResponseEntity addCustomers(Customer customer){
        if(customer == null && customer.getName() != null) return new ResponseEntity("пустое тело запроса", HttpStatus.BAD_REQUEST);
        customerRepository.save(customer);
        return new ResponseEntity("user save", HttpStatus.BAD_REQUEST);
    }
    @Transactional
    public ResponseEntity addEmail(Customer customer){
        Set email = customer.getEmails();
        Customer customers = customerRepository.getCustomerByName(customer.getName());
        if(customers == null) return new ResponseEntity("клиента с указаным именем нет", HttpStatus.BAD_REQUEST);
        customers.setEmails(email);
        customerRepository.save(customers);
        StringBuilder answer = new StringBuilder();
        answer.append("эл-почта для клиента ").append(customer.getName()).append(" успешно добавлена");
        return new ResponseEntity(answer,HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity addPhone(Customer customer){
        Set phone = customer.getPhones();
        Customer customers = customerRepository.getCustomerByName(customer.getName());
        if(customers == null) return new ResponseEntity("клиента с указаным именем нет", HttpStatus.BAD_REQUEST);
        customers.setPhones(phone);
        customerRepository.save(customers);
        StringBuilder answer = new StringBuilder();
        answer.append("телефон для клиента ").append(customer.getName()).append(" успешно добавлена");
        return new ResponseEntity(answer,HttpStatus.OK);
    }

    public Customer getAllContactsCustomer(String name){
        Customer customers = customerRepository.getCustomerByName(name);
        return customers;
    }

    public List<Customer> getAllCustomers(){ return customerRepository.getAllBy(); }
    public Customer getCustomerById(Long id){ return customerRepository.getCustomerById(id);}
    public Set<Email> getAllEmailsCustomer(String name){
        Customer customer = customerRepository.getCustomerByName(name);
        return customer.getEmails();
    }
    public Set<Phone> getAllPhonesCustomer(String name){
        Customer customer = customerRepository.getCustomerByName(name);
        return customer.getPhones();
    }

}
