package service;

import Convert.StudentConvert;
import dto.StudentDto;
import entity.Student;
import repository.StudentDao;
import repository.StudentDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentService {

    StudentDaoImpl studentDao = new StudentDao();

    public Student add(StudentDto studentDto) {
        Student student = StudentConvert.DtoToEntity(studentDto);
        return studentDao.add(student);
    }

    public boolean update(StudentDto studentDto) {
        Student student = StudentConvert.DtoToEntity(studentDto);
        return studentDao.update(student);
    }

    public boolean delete(int id) {
        return studentDao.delete(id);
    }

    public List<Student> getAll(int pageNumber, int pageSize) {
        return studentDao.findAll(pageNumber, pageSize);
    }

    public List<Student> getListStudentBirthday(int pageNumber, int pageSize) {
        return studentDao.findStudentByBirthday(pageNumber, pageSize);
    }

    public List<Student> getListStudentByName(String name, int pageNumber, int pageSize) {
        return studentDao.findStudentByName(name, pageNumber, pageSize);
    }

    public List<Student> getListStudentByGender(String gender, int pageNumber, int pageSize) {
        return studentDao.findStudentByGender(gender, pageNumber, pageSize);
    }

    public List<Student> getListStudentByHometown(String hometown, int pageNumber, int pageSize) {
        return studentDao.findStudentByHometown(hometown, pageNumber, pageSize);
    }

    public List<Student> getListStudentByClassName(String className, int pageNumber, int pageSize) {
        return studentDao.findStudentByClassName(className, pageNumber, pageSize);
    }

    public List<Student> getListStudentByMajor(String major, int pageNumber, int pageSize) {
        return studentDao.findStudentByMajor(major,pageNumber, pageSize);
    }

    public List<Student> getListStudentBirthday(String sdate1, String sdate2, int pageNumber, int pageSize) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1, date2;
        try {
            date1 = sdf.parse(sdate1);
            date2 = sdf.parse(sdate2);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return studentDao.findStudentByBirthday(date1, date2, pageNumber, pageSize);
    }

    public List<Student> getListStudentAverageMark(double min, double max, int pageNumber, int pageSize) {
        return studentDao.findStudentByAverage(min, max, pageNumber, pageSize);
    }

}
