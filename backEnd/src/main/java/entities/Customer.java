package entities;

import java.util.Date;
import java.util.Set;

public class Customer {
    private long id;
    private String firstName,lastName,address,postalCode,phone;
    private Date createDate,lastUpdate;
    private Division division;
    private Set<Cart> carts;

    Customer() {}
}
