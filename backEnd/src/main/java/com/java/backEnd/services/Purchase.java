package com.java.backEnd.services;

import com.java.backEnd.entities.Cart;
import com.java.backEnd.entities.CartItem;
import com.java.backEnd.entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
