package com.mattoffe.Eccomerce.repositories;

import com.mattoffe.Eccomerce.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
}
