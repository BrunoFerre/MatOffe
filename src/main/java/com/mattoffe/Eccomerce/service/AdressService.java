package com.mattoffe.Eccomerce.service;

import com.mattoffe.Eccomerce.dtos.AdressDTO;
import com.mattoffe.Eccomerce.model.Adress;
import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AdressService {
    void saveAdress(Adress adress);
    List<Adress> findByPerson(Person person);
}
