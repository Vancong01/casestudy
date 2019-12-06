package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orderdetail")
public class Orderdetail {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quality;

    @ManyToOne
    @JoinColumn(name="orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orderdetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
