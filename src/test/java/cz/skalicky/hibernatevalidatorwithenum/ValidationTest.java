package cz.skalicky.hibernatevalidatorwithenum;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import cz.skalicky.hibernatevalidatorwithenum.model.Car;
import cz.skalicky.hibernatevalidatorwithenum.model.CarBrand;

/**
 * Created by tom on 08.09.14.
 */
@ContextConfiguration(classes = TestConfig.class)
public class ValidationTest extends AbstractTestNGSpringContextTests {

	@Inject
	private Validator validator;

	@Test
	public void when_production_year_is_null_then_should_return_error_message() {

		Car car = new Car();
		car.setProductionYear(null);

		final Set<ConstraintViolation<Car>> violations = validator.validate(car);

		assertThat(violations, hasSize(1));

		final List<ConstraintViolation<Car>> violationList = new ArrayList<>(violations);
		assertThat(violationList.get(0).getPropertyPath().toString(), is("productionYear"));
	}

	@Test
	public void should_return_localized_notNull_error_message() {

		Car car = new Car();
        car.setProductionYear(null);

		final Set<ConstraintViolation<Car>> violations = validator.validate(car);

		final List<ConstraintViolation<Car>> violationList = new ArrayList<>(violations);
		assertThat(violationList.get(0).getMessage(), is("darf nicht null sein"));
	}

    @Test
    public void should_return_localized_min_error_message() {

        Car car = new Car();
        car.setProductionYear(1899);

        final Set<ConstraintViolation<Car>> violations = validator.validate(car);

        final List<ConstraintViolation<Car>> violationList = new ArrayList<>(violations);
        assertThat(violationList.get(0).getMessage(), is("darf nicht kleiner als 1900 sein"));
    }

    @Test
    public void should_return_localized_max_error_message() {

        Car car = new Car();
        
        car.setProductionYear(2101);

        final Set<ConstraintViolation<Car>> violations = validator.validate(car);

        final List<ConstraintViolation<Car>> violationList = new ArrayList<>(violations);
        assertThat(violationList.get(0).getMessage(), is("darf nicht größer als 2100 sein"));
    }

    @Test
    public void should_be_german_car() {

        Car car = new Car();
        car.setBrand(CarBrand.SKODA);
        car.setProductionYear(2000);

        final Set<ConstraintViolation<Car>> violations = validator.validate(car);

        final List<ConstraintViolation<Car>> violationList = new ArrayList<>(violations);
        assertThat(violationList.get(0).getMessage(), is("ist nicht deutsche Automarke"));
    }
}
