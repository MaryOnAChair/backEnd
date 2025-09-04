package com.java.backEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country {

    //Country ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    //Country Name
    @Column(name = "country")
    private String country_name;

    //Create Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDate;

    //Last Update
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    //Divisions
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "country", fetch = FetchType.LAZY)
    private Set<Division> divisions;

}
