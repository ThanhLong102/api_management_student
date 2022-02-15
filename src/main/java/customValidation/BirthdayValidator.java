package customValidation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayValidator implements ConstraintValidator<BirthdayConstraint, String> {
    @Override
    public void initialize(BirthdayConstraint birthdayConstraint) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date birthday;
        try {
            birthday = sdf.parse(contactField);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return contactField != null
                && (birthday.compareTo(new Date())) > 0;
    }
}
