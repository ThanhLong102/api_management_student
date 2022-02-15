package repository;

import entity.Student;

import java.util.Date;
import java.util.List;

public interface StudentDaoImpl {

    List<Student> findAll(int pageNumber, int pageSize);

    Student add(Student student);

    boolean update(Student student);

    boolean delete(int id);

    List<Student> findStudentByName(String name, int pageNumber, int pageSize);

    List<Student> findStudentByBirthday(Date date1, Date date2, int pageNumber, int pageSize);

    List<Student> findStudentByGender(String gender, int pageNumber, int pageSize);

    List<Student> findStudentByHometown(String homeTown, int pageNumber, int pageSize);

    List<Student> findStudentByClassName(String className, int pageNumber, int pageSize);

    List<Student> findStudentByMajor(String major, int pageNumber, int pageSize);

    List<Student> findStudentByAverage(double min, double max, int pageNumber, int pageSize);

    List<Student> findStudentByBirthday(int pageNumber, int pageSize);
}
