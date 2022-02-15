package entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student5_seq")
    @SequenceGenerator(name = "student5_seq", sequenceName = "student5_seq", allocationSize = 1)
    int id;

    @Column(name = "fullname", nullable = false)
    String fullName;

    @Column(name = "birthday", nullable = false)
    Date birthday;

    @Column(name = "class_name", nullable = false)
    String className;

    @Column(name = "major", nullable = false)
    String major;

    @Column(name = "hometown", nullable = false)
    String hometown;

    @Column(name = "gender")
    String gender;

    @Column(name = "average_mark", nullable = false)
    double averageMark;
}
