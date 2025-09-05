package com.java.backEnd.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
