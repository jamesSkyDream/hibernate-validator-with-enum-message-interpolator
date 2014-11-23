package cz.skalicky.hibernatevalidatorwithenum.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cz.skalicky.hibernatevalidatorwithenum.validation.GermanCar;

/**
 * Created by tom on 08.09.14.
 */
public class Car {

    @GermanCar
    private CarBrand brand;

    @NotNull
    @Min(1900)
    @Max(2100)
    private Integer productionYear;

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }
}
