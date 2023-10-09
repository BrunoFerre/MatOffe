package com.mattoffe.Eccomerce.service.implement;


import com.mattoffe.Eccomerce.dtos.AdressDTO;
import com.mattoffe.Eccomerce.model.Adress;
import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.repositories.AdressRepository;
import com.mattoffe.Eccomerce.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressImplement implements AdressService {
@Autowired
private AdressRepository adressRepository;

    @Override
    public void saveAdress(Adress adress) {
        adressRepository.save(adress);
    }

    @Override
    public List<Adress> findByPerson(Person person) {
        return adressRepository.findByPerson(person);
    }
}
