package com.mattoffe.Eccomerce.model;

import com.mattoffe.Eccomerce.model.enums.CatogoryProduct;
import com.mattoffe.Eccomerce.model.enums.ColorProduct;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name, image;
    @Column(length = 10000)
    private String description;
    private int stock;
    private double price, discount, averagePoints, actuallyTotalPoints;
    private CatogoryProduct catogoryProduct;
    private ColorProduct colorProduct;
    @ElementCollection
    private List<String> imageCollection = new ArrayList<>();

    @ElementCollection
    private List<Integer> points = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private Set<Details> details = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private List<Comment> comments = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String image, String description, int stock, double price, double discount, double averagePoints, double actuallyTotalPoints, CatogoryProduct catogoryProduct, ColorProduct colorProduct, List<String> imageCollection, List<Integer> points) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.discount = discount;
        this.averagePoints = averagePoints;
        this.actuallyTotalPoints = actuallyTotalPoints;
        this.catogoryProduct = catogoryProduct;
        this.colorProduct = colorProduct;
        this.imageCollection = imageCollection;
        this.points = points;
    }
    //Methods
    public void AddDetails(Details details) {
        details.setProduct(this);
        this.details.add(details);
    }

    //Getters

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

    public List<String> getImageCollection() {
        return imageCollection;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public Set<Details> getDetails() {
        return details;
    }

    public List<Comment> getComments() {
        return comments;
    }
//Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setAveragePoints(double averagePoints) {
        this.averagePoints = averagePoints;
    }

    public void setActuallyTotalPoints(double actuallyTotalPoints) {
        this.actuallyTotalPoints = actuallyTotalPoints;
    }

    public void setCatogoryProduct(CatogoryProduct catogoryProduct) {
        this.catogoryProduct = catogoryProduct;
    }

    public void setColorProduct(ColorProduct colorProduct) {
        this.colorProduct = colorProduct;
    }

    public void setImageCollection(List<String> imageCollection) {
        this.imageCollection = imageCollection;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public void setDetails(Set<Details> details) {
        this.details = details;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
