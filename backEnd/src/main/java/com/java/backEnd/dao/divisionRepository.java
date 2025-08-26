package com.java.backEnd.dao;

import com.java.backEnd.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Division", path = "Divisions")
public interface divisionRepository extends JpaRepository<Division, Long> {
}
