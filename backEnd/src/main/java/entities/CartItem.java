package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;


    @Column(name = "vacation_id")
    private Vacation vacation;

    @OneToMany
    private Set<Excursion> excursions;

    @Column(name = "cart_id")
    private Cart cart;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update")
    private Date lastUpdate;

    CartItem(){}
}
