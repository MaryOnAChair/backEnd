package entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    private String excussionTitle;
    private BigDecimal excussionPrice;
    private Date createDate,lastUpdate;
    private Vacation vacation;
    private Set<CartItem> CartItem;

}
