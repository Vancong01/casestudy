package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate dateOfPurchase;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @OneToMany(targetEntity = Orderdetail.class)
    private List<Orderdetail> orderdetails;

    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
