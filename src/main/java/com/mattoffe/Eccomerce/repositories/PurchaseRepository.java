package com.mattoffe.Eccomerce.repositories;

import com.mattoffe.Eccomerce.model.Person;
import com.mattoffe.Eccomerce.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PurchaseRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> findByPerson(Person person);
    boolean existsByTicket(String ticket);
}
