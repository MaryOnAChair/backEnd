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
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
public class Cart {

    //cart ID

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    //Order tracking Number
    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    //Package Price
    @Column(name = "package_price")
    private BigDecimal package_price;

    //Party Size
    @Column(name = "party_size")
    private Integer party_size;

    //Create Date
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    //Last Update
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    //Customer ID
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //Status of Order
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    //Cart Items
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new HashSet<>();

    //Adds cart item to Customers carts
    public void add(CartItem item) {
        if (item != null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
        }
    }
}
