package com.mattoffe.Eccomerce.dtos;

import com.mattoffe.Eccomerce.model.Details;
import com.mattoffe.Eccomerce.model.Product;
import com.mattoffe.Eccomerce.model.PurchaseOrder;

import java.util.ArrayList;
import java.util.List;

public class DetailsDTO {
    private long id;
    private int quatity;
    private Double price;
    private Product product;
    private PurchaseOrder purchaseOrder;
    private List<Long> idProduct = new ArrayList<>();

    public DetailsDTO() {
    }

    public DetailsDTO(List<Long> idProduct, int quatity) {
        this.idProduct = idProduct;
        this.quatity = quatity;
    }


    public long getId() {
        return id;
    }

    public int getQuatity() {
        return quatity;
    }

    public Double getPrice() {
        return price;
    }

    public List<Long> getIdProduct() {
        return idProduct;
    }

    public Product getProduct() {
        return product;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }
}
