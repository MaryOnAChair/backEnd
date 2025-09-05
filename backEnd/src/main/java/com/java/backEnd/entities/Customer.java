package com.java.backEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    //Customer ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    //First Name
    @NotNull
    @Column(name = "customer_first_name")
    private String firstName;

    //Last Name

    @NotNull
    @Column(name = "customer_last_name")
    private String lastName;

    //Address
    @NotNull
    @Column(name="address")
    private String address;

    //Zip Code
    @NotNull
    @Column(name = "postal_code")
    private String postal_code;

    //Phone
    @NotNull
    @Column(name = "phone")
    private String phone;

    //Create Date
    @Column(name ="create_date")
    @CreationTimestamp
    private Date create_date;

    //Last Update
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //Division Id
    @NotNull
    @ManyToOne
    @JoinColumn(name ="division_id")
    private Division division;

    //Customer Cart
    @OneToMany(mappedBy = "customer",cascade ={CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Cart> carts;


    //Adds Cart to Customer
    public void add(Cart cart) {
        if(cart != null) {
            if(carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }

}


