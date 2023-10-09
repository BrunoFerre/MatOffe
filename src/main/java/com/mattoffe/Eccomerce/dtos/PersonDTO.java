package com.mattoffe.Eccomerce.dtos;

import com.mattoffe.Eccomerce.model.Adress;
import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.model.PurchaseOrder;
import com.mattoffe.Eccomerce.model.enums.PersonType;

import javax.persistence.OneToMany;
import java.util.Set;

public class PersonDTO {
    private long id;
    private String firstName, lastName, email, password;
    private PersonType type;
    private Set<Adress> adress;
    private Set<PurchaseOrder> purchaseOrder;

    public PersonDTO() {
    }
    public PersonDTO(Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.password = person.getPassword();
    }

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
}
