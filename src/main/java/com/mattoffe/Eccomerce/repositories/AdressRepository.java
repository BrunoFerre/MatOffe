package com.mattoffe.Eccomerce.repositories;

import com.mattoffe.Eccomerce.dtos.AdressDTO;
import com.mattoffe.Eccomerce.model.Adress;
import com.mattoffe.Eccomerce.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AdressRepository  extends JpaRepository<Adress, Long> {
    List<Adress> findByPerson(Person person);

    @Override
    boolean existsById(Long id);
}
