package com.example.mongodb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.mongodb.beans.Customer;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Optional<Customer> findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);
}
