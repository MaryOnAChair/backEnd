package com.java.backEnd.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {

    //Excursion ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    //Excursion Title
    @Column(name = "excursion_title")
    private String excursion_title;

    //Excursion Price
    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    //Create Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    //Last Update
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //Image
    @Column(name = "image_url")
    private String image_URL;

    //Vacation ID
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;


}
