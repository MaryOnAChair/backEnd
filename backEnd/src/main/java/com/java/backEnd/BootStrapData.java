package com.java.backEnd;

import com.java.backEnd.dao.CustomerRepository;
import com.java.backEnd.dao.DivisionRepository;
import com.java.backEnd.entities.Customer;
import com.java.backEnd.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Gets divisions for each customer
        Division divisionJane = divisionRepository.findById(4L).get();     //California
        Division divisionEnrique = divisionRepository.findById(3L).get();  //Arkansas
        Division divisionJose = divisionRepository.findById(2L).get();     //Arizona
        Division divisionStacey = divisionRepository.findById(6L).get();   //Connecticut
        Division divisionPeter = divisionRepository.findById(5L).get();    //Colorado

        //Created Customers
        Customer jane = new Customer();
        Customer enrique = new Customer();
        Customer jose = new Customer();
        Customer stacey = new Customer();
        Customer peter = new Customer();


        //First Name
        jane.setFirstName("Jane");
        enrique.setFirstName("Enrique");
        jose.setFirstName("Jose");
        stacey.setFirstName("Stacey");
        peter.setFirstName("Peter");

        //Last Name
        jane.setLastName("Johnson");
        enrique.setLastName("Masterdon");
        jose.setLastName("Richards");
        stacey.setLastName("Mom");
        peter.setLastName("Albetres");

        //Address
        jane.setAddress("123 Holly Street");
        enrique.setAddress("456 Oxford Street");
        jose.setAddress("789 Maxton Street");
        stacey.setAddress("887 NautolWood Street");
        peter.setAddress("554 Baxton Street");

        // ZipCode
        jane.setPostal_code("5588");
        enrique.setPostal_code("5589");
        jose.setPostal_code("5590");
        stacey.setPostal_code("5591");
        peter.setPostal_code("5592");

        //Phone
        jane.setPhone("555-887-8888");
        enrique.setPhone("555-888-888");
        jose.setPhone("555-888-888");
        stacey.setPhone("555-888-888");
        peter.setPhone("555-888-888");

        //Division
        jane.setDivision(divisionJane);
        enrique.setDivision(divisionEnrique);
        jose.setDivision(divisionJose);
        stacey.setDivision(divisionStacey);
        peter.setDivision(divisionPeter);

        if (customerRepository.count() < 5) {

            //Save customers to database
            customerRepository.save(jane);
            customerRepository.save(enrique);
            customerRepository.save(jose);
            customerRepository.save(stacey);
            customerRepository.save(peter);

            System.out.println(customerRepository.count());
        }
    }
}
