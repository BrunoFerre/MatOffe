package com.mattoffe.Eccomerce.dtos;

import com.mattoffe.Eccomerce.model.PurchaseOrder;
import com.mattoffe.Eccomerce.model.enums.PaymentMethod;

import java.time.LocalDateTime;

public class PurchaseDTO {
    private long id;
    private String ticket;
    private double total;
    private LocalDateTime date;
    private PaymentMethod paymentMethod;

    public PurchaseDTO() {
    }
    public PurchaseDTO(PurchaseOrder purchaseOrder){
        this.ticket = purchaseOrder.getTicket();
        this.total = purchaseOrder.getTotal();
        this.date = purchaseOrder.getDate();
        this.paymentMethod = purchaseOrder.getPaymentMethod();
    }

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
}
