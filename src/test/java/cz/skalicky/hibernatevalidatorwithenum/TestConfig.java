/**
 * 
 */
package cz.skalicky.hibernatevalidatorwithenum;

import javax.validation.MessageInterpolator;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import cz.skalicky.hibernatevalidatorwithenum.validation.ConstraintViolationEnumMessageInterpolator;

/**
 * [description]
 *
 * @author Tomas Skalicky
 * @since Nov 23, 2014
 */
@Configuration
public class TestConfig {
	
	@Bean
	public MessageInterpolator messageInterpolator() {
		return new ConstraintViolationEnumMessageInterpolator();
	}
	
	@Bean
	public LocalValidatorFactoryBean validatorFactoryBean() {
		final LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setMessageInterpolator(messageInterpolator());
		return factoryBean;
	}
	
	@Bean
	public Validator validator() {
		return validatorFactoryBean().getValidator();
	}
}
