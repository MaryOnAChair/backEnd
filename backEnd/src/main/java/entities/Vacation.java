package entities;

import java.math.BigDecimal;
import java.util.Date;

public class Vacation {
    private Long id;
    private String vacationTitle,description;
    private BigDecimal travelPrice;
    private String imageUrl;
    private Date createDate,lastUpdate;
    private excursions Set<Excussion>;

    Vacation(){}
}
