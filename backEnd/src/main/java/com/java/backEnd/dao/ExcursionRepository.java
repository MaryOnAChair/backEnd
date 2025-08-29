package com.java.backEnd.dao;

import com.java.backEnd.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}
