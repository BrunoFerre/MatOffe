package com.mattoffe.Eccomerce.repositories;

import com.mattoffe.Eccomerce.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DetailRepository extends JpaRepository<Details, Long> {
}
