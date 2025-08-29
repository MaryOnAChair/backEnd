package com.java.backEnd.services;

import com.java.backEnd.dao.CartItemRepository;
import com.java.backEnd.dao.CartRepository;
import com.java.backEnd.dao.CustomerRepository;
import com.java.backEnd.entities.Cart;
import com.java.backEnd.entities.CartItem;
import com.java.backEnd.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository,CartRepository cartRepository,CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        // get Cart info
        Cart cart = purchase.getCart();

        //Generate Tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Populate w/ cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::add);

        // Populate Customer w/ order
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        //Return the order Tracking Number
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate random UUID Number - Vs 4
        return UUID.randomUUID().toString();
    }
}
