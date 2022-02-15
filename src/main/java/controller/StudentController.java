package controller;

import dto.StudentDto;
import entity.Student;
import service.StudentService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
public class StudentController {
    StudentService studentService = new StudentService();

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student add(@Valid StudentDto studentDTO) {
        return studentService.add(studentDTO);
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(@Valid StudentDto studentDto) {
        return studentService.update(studentDto) ? "Update thành công" : "Update thất bại";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("id") int id) {
        return studentService.delete(id) ? "Xóa thành công" : "Xóa thất bại";
    }

    @GET
    @Path("/page={pageNumber}&limit={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent(@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getAll(pageNumber, pageSize);
    }

    @GET
    @Path("/name={name}&page={pageNumber}&limit={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByName(@PathParam("name") String name, @PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentByName(name, pageNumber, pageSize);
    }

    @GET
    @Path("/gender={gender}&page={pageNumber}&limit={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByGender(@PathParam("gender") String gender, @PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentByGender(gender, pageNumber, pageSize);
    }

    @GET
    @Path("/hometown={hometown}&page={pageNumber}&limit={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByHometown(@PathParam("hometown") String hometown, @PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentByHometown(hometown, pageNumber, pageSize);
    }

    @GET
    @Path("/class-name={className}&page={pageNumber}&limit={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByClassName(@PathParam("className") String className, @PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentByClassName(className, pageNumber, pageSize);
    }

    @GET
    @Path("/major={major}&page={pageNumber}&limit={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByMajor(@PathParam("major") String major, @PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentByMajor(major, pageNumber, pageSize);
    }

    @GET
    @Path("/average-mark-min={min}&average-mark-max={max}&page={pageNumber}&limit={pageSize}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByAverageMark(@PathParam("min") double min, @PathParam("max") double max, @PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentAverageMark(min, max, pageNumber, pageSize);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get-between-birthdays/sdate1={sdate1}&sdate2={sdate2}&page={pageNumber}&limit={pageSize}")
    public List<Student> getAllBirthdayPeople(@PathParam("sdate1") String sdate1, @PathParam("sdate2") String sdate2, @PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentBirthday(sdate1, sdate2, pageNumber, pageSize);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/birthdays/page={pageNumber}&limit={pageSize}")
    public List<Student> getAllBirthdayPeople(@PathParam("pageNumber") int pageNumber, @PathParam("pageSize") int pageSize) {
        return studentService.getListStudentBirthday(pageNumber, pageSize);
    }
}
