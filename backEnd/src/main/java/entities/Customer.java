package entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String firstName,lastName,address,postalCode,phone;
    private Date createDate,lastUpdate;
    private Division division;
    private Set<Cart> carts;


}
