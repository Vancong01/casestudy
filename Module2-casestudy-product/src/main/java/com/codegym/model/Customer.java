package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="customer")
public class Customer {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String address;

    private String phone;
    private String email;
    private LocalDate birthOfDate;

    @OneToMany(targetEntity = Order.class)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer(@NotNull String name, String address, String phone, String email, LocalDate birthOfDate) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthOfDate = birthOfDate;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(LocalDate birthOfDate) {
        this.birthOfDate = birthOfDate;
    }
}
