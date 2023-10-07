package com.mattoffe.Eccomerce.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String street, city, apartament, zip;
    private long number,floor;
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToMany(mappedBy = "adress")
    private PurchaseOrder purchaseOrder;

    public Adress() {
    }

    public Adress( String street, String city, String apartament, String zip, long number, long floor, boolean status) {
        this.street = street;
        this.city = city;
        this.apartament = apartament;
        this.zip = zip;
        this.number = number;
        this.floor = floor;
        this.status = status;
    }
    //Getters

    public long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getApartament() {
        return apartament;
    }

    public String getZip() {
        return zip;
    }

    public long getNumber() {
        return number;
    }

    public long getFloor() {
        return floor;
    }

    public boolean isStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }
    //Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setApartament(String apartament) {
        this.apartament = apartament;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setFloor(long floor) {
        this.floor = floor;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
