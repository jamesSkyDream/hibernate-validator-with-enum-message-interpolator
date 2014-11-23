package cz.skalicky.hibernatevalidatorwithenum.model;

/**
 * Created by tom on 08.09.14.
 */
public enum CarBrand {

    AUDI("Germany"), MERCEDES("Germany"), SKODA("Czech Republic");

    private final String productionCountry;

    private CarBrand(final String productionCountry) {
        this.productionCountry = productionCountry;
    }

    public String getProductionCountry() {
        return productionCountry;
    }
}
