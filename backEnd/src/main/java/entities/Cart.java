package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id");
    private Long id;

    private String orderTrackingNumber;
    private BigDecimal packagePrice;
    private Integer partySize;
    private Date createDate,lastUpdate;
    private Customer customer;
    private Set<CartItem> cartUten;

    Cart(){}
}
