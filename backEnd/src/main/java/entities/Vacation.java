package entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Vacation {
    private Long id;
    private String vacationTitle,description;
    private BigDecimal travelPrice;
    private String imageUrl;
    private Date createDate,lastUpdate;
    private Set<Excursion> Excursion;

    Vacation(){}
}
