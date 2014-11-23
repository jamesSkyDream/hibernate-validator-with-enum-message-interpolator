package cz.skalicky.hibernatevalidatorwithenum.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cz.skalicky.hibernatevalidatorwithenum.model.CarBrand;

/**
 * Created by tom on 08.09.14.
 */
public class GermanCarValidator implements ConstraintValidator<GermanCar, CarBrand> {

    @Override
    public void initialize(GermanCar constraintAnnotation) {
    }

    @Override
    public boolean isValid(CarBrand object, ConstraintValidatorContext context) {
        
        if (object == null) {
            return true;
        }

        return object.getProductionCountry() == "Germany";
    }
}
