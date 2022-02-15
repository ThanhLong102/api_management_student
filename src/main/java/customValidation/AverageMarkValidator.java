package customValidation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AverageMarkValidator implements ConstraintValidator<AverageMarkConstraint, Double> {

    @Override
    public void initialize(AverageMarkConstraint averageMarkConstraint) {

    }

    @Override
    public boolean isValid(Double contactField,
                           ConstraintValidatorContext cxt) {
        return contactField.toString().matches("[0-9]{1,2}[.][0-9]{2}");
    }
}
