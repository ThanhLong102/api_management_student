package customValidation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BirthdayValidator.class)
public @interface BirthdayConstraint {
    String message() default "Invalid birthday";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
