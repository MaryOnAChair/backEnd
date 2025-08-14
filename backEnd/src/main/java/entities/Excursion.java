package entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Excursion {
    private Long id;
    private String excussionTitle;
    private BigDecimal excussionPrice;
    private Date createDate,lastUpdate;
    private Vacation vacation;
    private Set<CartItem> CartItem;

    Excursion(){}
}
