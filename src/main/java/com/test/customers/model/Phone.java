package com.test.customers.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Table(name = "phone")
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String type;
    private String phone;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}