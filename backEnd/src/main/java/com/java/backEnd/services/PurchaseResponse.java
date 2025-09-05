package com.java.backEnd.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;

}
