package entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    private String vacationTitle,description;
    private BigDecimal travelPrice;
    private String imageUrl;
    private Date createDate,lastUpdate;
    private Set<Excursion> Excursion;

}
