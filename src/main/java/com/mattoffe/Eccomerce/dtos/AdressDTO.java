package com.mattoffe.Eccomerce.dtos;

import com.mattoffe.Eccomerce.model.Adress;

public class AdressDTO {
    private long id;
    private String street, city, apartament, zip;
    private long number,floor;
    private boolean status;

    public AdressDTO() {
    }
    public AdressDTO(Adress adress) {
        this.street = adress.getStreet();
        this.city = adress.getCity();
        this.apartament = adress.getApartament();
        this.zip = adress.getZip();
        this.number = adress.getNumber();
        this.floor = adress.getFloor();
        this.status = adress.isStatus();
    }

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
}
