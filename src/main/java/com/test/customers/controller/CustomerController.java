package com.test.customers.controller;

import com.test.customers.model.Customer;
import com.test.customers.model.Email;
import com.test.customers.model.Phone;
import com.test.customers.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "api")
public class CustomerController {

    @Autowired
    private CustomersService customersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<Customer> customerList() {
        return customersService.getAllCustomers();
    }

    @RequestMapping(value = "/get-customer/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Customer getCustomerById(@PathVariable Long id) {
        return customersService.getCustomerById(id);
    }

    @RequestMapping(value = "/get-all-contacts/{name}", method = RequestMethod.GET)
    public @ResponseBody Customer getAllContactsCustomer(@PathVariable String name) {
        return customersService.getAllContactsCustomer(name);
    }

    @RequestMapping(value = "/get-phone-contacts-customer/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Set<Phone> getPhoneContacts(@PathVariable String name) {
        return customersService.getAllPhonesCustomer(name);
    }

    @RequestMapping(value = "/get-email-contacts-customer/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Set<Email> getEmailContacts(@PathVariable String name) {
        return customersService.getAllEmailsCustomer(name);
    }

    @RequestMapping(value = "/add-customer/", method = RequestMethod.POST)
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        return customersService.addCustomers(customer);
    }

    @RequestMapping(value = "/add-email-customer/", method = RequestMethod.POST)
    public ResponseEntity addEmailCustomer(@RequestBody Customer customer) {
        return customersService.addEmail(customer);
    }

    @RequestMapping(value = "/add-phone-customer/", method = RequestMethod.POST)
    public ResponseEntity addPhoneCustomer(@RequestBody Customer customer) {
        return customersService.addPhone(customer);
    }
}