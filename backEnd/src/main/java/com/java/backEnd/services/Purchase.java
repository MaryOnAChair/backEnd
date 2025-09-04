package com.java.backEnd.services;

import com.java.backEnd.entities.Cart;
import com.java.backEnd.entities.CartItem;
import com.java.backEnd.entities.Customer;
import com.java.backEnd.entities.Excursion;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems = new HashSet<>();
    private Set<Excursion> excursions = new HashSet<>();

}
