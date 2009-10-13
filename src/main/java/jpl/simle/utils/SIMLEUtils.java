package jpl.simle.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.validation.BindingResult;

import jpl.simle.domain.SIMLEUser;

public class SIMLEUtils
{

    /**
     * Validate a domain object. It must have JPA annotations attached to it. 
     * @param validator
     *        A validator instance, generally this can be created with the following code block:
     *        <code>
     *        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
     *        </code>
     *        
     *        But you may want to do something special.
     *        
     * @param result
     *        The binding result to store the errors if there are any.
     * @param domainObject
     *        The domain object that needs validation.
     * @return True if there are errors and the domain object did not validate, false otherwise if everything was good. In
     *         other words, <code>result.hasErrors()</code>.
     */
    public static <T> boolean validateDomainObject(Validator validator, BindingResult result, T domainObject)
    {
        for ( ConstraintViolation<T> constraint : validator.validate(domainObject) )
        {
            result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
        }
        
        return result.hasErrors();
    }
}
