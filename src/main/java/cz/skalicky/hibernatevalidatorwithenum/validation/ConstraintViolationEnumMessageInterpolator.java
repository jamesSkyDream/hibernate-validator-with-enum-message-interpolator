/**
 * 
 */
package cz.skalicky.hibernatevalidatorwithenum.validation;

import java.util.Locale;

import javax.validation.MessageInterpolator;

/**
 * [description]
 *
 * @author Tomas Skalicky
 * @since Nov 23, 2014
 */
public class ConstraintViolationEnumMessageInterpolator implements MessageInterpolator {

    @Override
    public String interpolate(final String messageTemplate, final Context context, final Locale locale) {
        return interpolate(messageTemplate, context);
    }

    @Override
    public String interpolate(final String messageTemplate, final Context context) {
        final ConstraintViolationEnum localizedViolation = ConstraintViolationEnum.getValue(messageTemplate);

        final String errorMessage = localizedViolation.getErrorMessage();
        
        // TODO tomas: tokenizer solution necessary
        if (!context.getConstraintDescriptor().getAttributes().containsKey("value")) {
            return errorMessage;
            
        } else {

            final Object value = context.getConstraintDescriptor().getAttributes().get("value");
            
            final String messageWithResolvedValueParameter = errorMessage.replace("{value}", value.toString());
            return messageWithResolvedValueParameter;
        }
    }
}
