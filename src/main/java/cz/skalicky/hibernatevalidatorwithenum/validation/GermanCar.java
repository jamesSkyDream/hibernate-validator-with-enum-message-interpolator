package cz.skalicky.hibernatevalidatorwithenum.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Null values are OK.
 * 
 * Created by tom on 08.09.14.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GermanCarValidator.class)
@Documented
public @interface GermanCar {

    String message() default "{cz.skalicky.hibernatevalidator.Car.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
