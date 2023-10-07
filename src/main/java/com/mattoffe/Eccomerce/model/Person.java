package com.mattoffe.Eccomerce.model;

import com.mattoffe.Eccomerce.model.enums.PersonType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String firstName, lastName, email, password;
    private PersonType type;
    @OneToMany(mappedBy = "person")
    private Set<Adress> adress= new HashSet<>();
    @OneToMany(mappedBy = "person")
    private Set<PurchaseOrder> purchaseOrder = new HashSet<>();

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String password, PersonType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.type = type;
    }
    //Methods
    //Adders
    public void addAdress(Adress adress){
        adress.setPerson(this);
        this.adress.add(adress);
    }
    //PurchaseOrder
    public void addPurchaseOrder(PurchaseOrder purchaseOrder){
        purchaseOrder.setPerson(this);
        this.purchaseOrder.add(purchaseOrder);
    }

    //Getters
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public PersonType getType() {
        return type;
    }

    public Set<Adress> getAdress() {
        return adress;
    }

    public Set<PurchaseOrder> getPurchaseOrder() {
        return purchaseOrder;
    }
    //Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public void setAdress(Set<Adress> adress) {
        this.adress = adress;
    }

    public void setPurchaseOrder(Set<PurchaseOrder> purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
