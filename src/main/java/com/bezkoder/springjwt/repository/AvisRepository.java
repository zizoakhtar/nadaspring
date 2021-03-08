package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.bezkoder.springjwt.models.avis;

import java.util.List;
@Component
@RepositoryRestResource
@CrossOrigin("*")
public interface AvisRepository extends JpaRepository<avis, Long> {


    @Query(
            value = "SELECT *  FROM avis a ",
            nativeQuery = true)
    List<Object> all();
}
