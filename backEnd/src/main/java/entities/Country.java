package entities;

import java.util.Date;
import java.util.Set;

public class Country {
    private long id;
    private String countryName;
    private Date createDate,lastUpdate;
    private Set<Division> divisions;
}
