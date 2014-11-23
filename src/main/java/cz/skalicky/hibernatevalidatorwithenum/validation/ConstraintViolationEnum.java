/**
 * 
 */
package cz.skalicky.hibernatevalidatorwithenum.validation;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [description]
 *
 * @author Tomas Skalicky
 * @since Nov 23, 2014
 */
public enum ConstraintViolationEnum {

    // @formatter:off
	//              messageTemplate                                     localizedErrorMessage                      id
	NOT_NULL       ("{javax.validation.constraints.NotNull.message}",   "darf nicht null sein",                    40001),
	MIN            ("{javax.validation.constraints.Min.message}",       "darf nicht kleiner als {value} sein",     40002),
    MAX            ("{javax.validation.constraints.Max.message}",       "darf nicht größer als {value} sein",      40003),
    GERMAN_CAR     ("{cz.skalicky.hibernatevalidator.Car.message}",     "ist nicht deutsche Automarke",            40004);
	// @formatter:on

    private final String messageTemplate;
    private final String errorMessage;
    private final long id;

    private static final Map<String, ConstraintViolationEnum> messageTemplateToValueMap;

    static {
        messageTemplateToValueMap = Arrays.stream(values()).collect(
                Collectors.toMap(v -> v.messageTemplate, v -> v));
    }

    private ConstraintViolationEnum(final String messageTemplate, final String errorMessage, final long id) {
        this.messageTemplate = messageTemplate;
        this.errorMessage = errorMessage;
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getId() {
        return id;
    }
    
    public static ConstraintViolationEnum getValue(final String messageTemplate) {
        if (messageTemplateToValueMap.containsKey(messageTemplate)) {
            return messageTemplateToValueMap.get(messageTemplate);
        } else {
            throw new IllegalArgumentException(messageTemplate + " is not a supported message template");
        }
    }
}
