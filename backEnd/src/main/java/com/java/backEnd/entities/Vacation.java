package com.java.backEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacation {

    //Vacation ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    //Vacation Title
    @Column(name = "vacation_title")
    private String vacation_title;

    //Description
    @Column(name = "description")
    private String description;

    //Travel Price
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    //Image
    @Column(name = "image_url")
    private String image_URL;

    //Create Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    //Last Update
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //Excursions
    @OneToMany(mappedBy = "vacation")
    private Set<Excursion> excursions;

}
