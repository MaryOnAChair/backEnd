package com.java.backEnd.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_first_name",nullable = false)
    private String firstName;

    @Column(name = "customer_last_name" ,nullable = false)
    private String lastName;

    @Column(name="address" ,nullable = false)
    private String address;

    @Column(name = "postal_code" ,nullable = false)
    private String postalCode;

    @Column(name = "phone" ,nullable = false)
    private String phone;

    @Column(name ="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name ="division_id")
    private Division division;

    @OneToMany(mappedBy = "customer",cascade ={CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Cart> carts;


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
