package com.mattoffe.Eccomerce.dtos;

import com.mattoffe.Eccomerce.model.Product;
import com.mattoffe.Eccomerce.model.enums.CatogoryProduct;
import com.mattoffe.Eccomerce.model.enums.ColorProduct;

public class ProductDTO {
    private long id;
    private String name, image;
    private String description;
    private int stock;
    private double price, discount, averagePoints, actuallyTotalPoints;
    private CatogoryProduct catogoryProduct;
    private ColorProduct colorProduct;

    public ProductDTO() {
    }
    public ProductDTO(Product product){
        this.name = product.getName();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.stock = product.getStock();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.averagePoints = product.getAveragePoints();
        this.actuallyTotalPoints = product.getActuallyTotalPoints();
        this.catogoryProduct = product.getCatogoryProduct();
        this.colorProduct = product.getColorProduct();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public double getAveragePoints() {
        return averagePoints;
    }

    public double getActuallyTotalPoints() {
        return actuallyTotalPoints;
    }

    public CatogoryProduct getCatogoryProduct() {
        return catogoryProduct;
    }

    public ColorProduct getColorProduct() {
        return colorProduct;
    }
}
