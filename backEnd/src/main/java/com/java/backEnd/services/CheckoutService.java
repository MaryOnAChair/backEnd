package com.java.backEnd.services;
import com.java.backEnd.services.Purchase;
import com.java.backEnd.services.PurchaseResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
