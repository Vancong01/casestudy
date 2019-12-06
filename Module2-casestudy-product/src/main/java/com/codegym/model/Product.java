package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name="product")
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private int price;
    @NotNull
    private String image;
    private String description;

    @ManyToOne
    @JoinColumn(name="supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    @OneToMany(targetEntity = Orderdetail.class)
    private List<Orderdetail> orderdetails;

    public List<Orderdetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(@NotNull String name, @NotNull int price, @NotNull String image, String description) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public Product() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
