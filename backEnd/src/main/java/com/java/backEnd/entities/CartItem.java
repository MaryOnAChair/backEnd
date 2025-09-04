package com.java.backEnd.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    //Cart Item ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id", nullable = false)
    private Long id;

    //Joins on Vacation
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;


    //Cart
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    //Excursion Cart Items
    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions = new HashSet<>();


    //Create Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_update;

    //Last Update
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;




}
