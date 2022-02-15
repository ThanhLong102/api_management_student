package dto;

import customValidation.AverageMarkConstraint;
import customValidation.BirthdayConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    Integer id;

    @BirthdayConstraint
    @NotNull
    @Past
    String birthday;

    @NotNull
    @Length(max = 50)
    String fullName;

    @NotNull
    String className;

    @NotNull
    String major;

    @NotNull
    String hometown;

    @NotNull
    String gender;

    @NotNull
    @Size(max = 10)
    @AverageMarkConstraint(message = "Nhập đúng định dạng:số thập phân 2 chữ số")
    double averageMark;
}
