package com.mattoffe.Eccomerce.model;

import com.mattoffe.Eccomerce.model.enums.PaymentMethod;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String ticket;
    private double total;
    private LocalDateTime date;
    private PaymentMethod paymentMethod;
    @OneToOne
    @JoinColumn(name = "adress_id")
    private Adress adress;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToMany(mappedBy = "purchaseOrder")
    private Set<Details> details = new HashSet<>();


    public PurchaseOrder() {
    }

    public PurchaseOrder(String ticket, double total, LocalDateTime date, PaymentMethod paymentMethod) {
        this.ticket = ticket;
        this.total = total;
        this.date = date;
        this.paymentMethod = paymentMethod;
    }
    //Methods
    public void addDetails(Details details){
        details.setPurchaseOrder(this);
        this.details.add(details);
    }
    //Getters

    public long getId() {
        return id;
    }

    public String getTicket() {
        return ticket;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Adress getAdress() {
        return adress;
    }

    public Person getPerson() {
        return person;
    }

    public Set<Details> getDetails() {
        return details;
    }
    //Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setDetails(Set<Details> details) {
        this.details = details;
    }
}
