package com.java.backEnd.services;

import com.java.backEnd.dao.CartItemRepository;
import com.java.backEnd.dao.CartRepository;
import com.java.backEnd.dao.CustomerRepository;
import com.java.backEnd.entities.Cart;
import com.java.backEnd.entities.CartItem;
import com.java.backEnd.entities.Customer;
import com.java.backEnd.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

import static com.java.backEnd.entities.StatusType.cancelled;
import static com.java.backEnd.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;


    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository,CartItemRepository cartItemRepository) {
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
        //assign tracking number to cart
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // Populate w/ cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {cart.add(item);});


        // Populate Customer w/ order
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        //Set status to ordered
        cart.setId(null);
        cart.setStatus(StatusType.ordered);



        //Returns error if cart is empty
        if(purchase.getCart() == null || purchase.getCartItems() == null || cartItems.isEmpty()) {
            cart.setStatus(StatusType.cancelled);
            return new PurchaseResponse("Error please check cart has items and try again :(");
        }
        //Returns error if party size is empty
        else if (cart.getParty_size() < 1) {
            cart.setStatus(StatusType.cancelled);
            return new PurchaseResponse("Error please check party size and try again :(");
        } else{
        //Returns the order Tracking Number
            //Save cart
            customer.add(cart);
            cartRepository.save(cart);
            return new PurchaseResponse(orderTrackingNumber);
    }
    }

    private String generateOrderTrackingNumber() {
        // generate random UUID Number - Vs 4
        return UUID.randomUUID().toString();
    }
}
