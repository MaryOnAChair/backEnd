package com.java.backEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Table(name = "divisions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Division {

    //Division ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    //Division Name
    @Column(name = "division")
    private String division_name;

    //Create Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    //Last Update
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //Country ID
    @Column(name="country_id")
    private Long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    //Joins on Country ID
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id",nullable = false,insertable = false,updatable = false)
    private Country country;





}

