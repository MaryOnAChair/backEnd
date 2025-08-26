package com.java.backEnd.dao;

import com.java.backEnd.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
