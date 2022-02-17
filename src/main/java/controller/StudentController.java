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
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudent(@QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getAll(pageNumber, pageSize);
    }

    @GET
    @Path("/names")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByName(@QueryParam("name") String name, @QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentByName(name, pageNumber, pageSize);
    }

    @GET
    @Path("/genders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByGender(@QueryParam("gender") String gender, @QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentByGender(gender, pageNumber, pageSize);
    }

    @GET
    @Path("/homtetowns")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByHometown(@QueryParam("hometown") String hometown, @QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentByHometown(hometown, pageNumber, pageSize);
    }

    @GET
    @Path("/classnames")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByClassName(@QueryParam("className") String className, @QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentByClassName(className, pageNumber, pageSize);
    }

    @GET
    @Path("/majors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByMajor(@QueryParam("major") String major, @QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentByMajor(major, pageNumber, pageSize);
    }

    @GET
    @Path("/between-averageMarks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByAverageMark(@QueryParam("min") double min, @QueryParam("max") double max, @QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentAverageMark(min, max, pageNumber, pageSize);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/between-birthdays")
    public List<Student> getAllBirthdayPeople(@QueryParam("sdate1") String sdate1, @QueryParam("sdate2") String sdate2, @QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentBirthday(sdate1, sdate2, pageNumber, pageSize);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/birthdays")
    public List<Student> getAllBirthdayPeople(@QueryParam("page") int pageNumber, @QueryParam("limit") int pageSize) {
        return studentService.getListStudentBirthday(pageNumber, pageSize);
    }
}
