package Convert;

import dto.StudentDto;
import entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentConvert {
    public static Student DtoToEntity(StudentDto studentDto){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Student student = new Student();
        try {
            student.setBirthday(sdf.parse(studentDto.getBirthday()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        student.setAverageMark(studentDto.getAverageMark());
        student.setGender(studentDto.getGender());
        student.setClassName(studentDto.getClassName());
        student.setHometown(studentDto.getHometown());
        student.setMajor(studentDto.getMajor());
        student.setFullName(studentDto.getFullName());
        return student;
    }

//    public static Student EntityToDto(Student student){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        StudentDto studentDto = new StudentDto();
//        studentDto.setId(student.getId());
//        studentDto.setBirthday(String.format(sdf.format(student.getBirthday())));
//        studentDto.setAverageMark(student.getAverageMark());
//        studentDto.setGender(student.getGender());
//        studentDto.setClassName(student.getClassName());
//        studentDto.setHometown(student.getHometown());
//        studentDto.setMajor(student.getMajor());
//        studentDto.setFullName(student.getFullName());
//        return student;
//    }

}
