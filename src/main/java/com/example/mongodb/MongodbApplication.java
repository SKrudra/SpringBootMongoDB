package com.example.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mongodb.beans.Customer;
import com.example.mongodb.beans.CustomerRepository;

@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// clearing any old records
		customerRepository.deleteAll();

		// saving some new records
		customerRepository.save(new Customer("Sandeep", "Kumar"));
		customerRepository.save(new Customer("Sanjeet", "Kumar"));

		// fetch all customers
		customerRepository.findAll().forEach(System.out::println);

		// fetch a specific record
		customerRepository.findByFirstName("Sandeep").ifPresent(System.out::println);
		
		
	}

}
