package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String address;

    private String description;

    public Supplier(@NotNull String name, @NotNull String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public Supplier() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
