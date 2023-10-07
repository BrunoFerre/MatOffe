package com.mattoffe.Eccomerce.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int quatity;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    public Details() {
    }

    public Details(int quatity, Double price) {
        this.quatity = quatity;
        this.price = price;
    }
    //Getters

    public long getId() {
        return id;
    }

    public int getQuatity() {
        return quatity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }
    //Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
