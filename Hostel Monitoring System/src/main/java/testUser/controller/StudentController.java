package testUser.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import testUser.entities.Mark;
import testUser.entities.Room;
import testUser.entities.Student;
import testUser.service.StudentService;

import java.sql.Date;
import java.util.List;

/**
 * Created by dzbe1116 on 4/21/2017.
 */
@Controller
public class StudentController {

    StudentService studentService;

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/hostel_schema/student/{id}")
//    public String getStudentById(@PathVariable("id") int id, Model model) {
//        Student student = studentService.getStudentById(id);
//        model.addAttribute(student);
//        return "hello";
//    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/students")
    @ResponseBody
    public List<Student> getAllStudentsFromHostel(Model model) {
        List<Student> allStudentsFromHostel= studentService.getAllStudentsFromHostel();

        return allStudentsFromHostel;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/hostel_schema/student/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public void addStudent() {
        //Room room = new Room("111b", 5, 5, 1);
        Student student = new Student();
        student.setId(15);
        student.setName("Stas");
        student.setSurname("Malina");
        student.setUnivercity("BSUIR");
        student.setFaculty("CSN");
        student.setGroup("250503");
        student.setRoomNumber("111a");
        studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addMark")
    public void addMark() {
        Mark mark = new Mark();
        mark.setValue(5);
        mark.setDate(new Date(201744));
        mark.setRoomNumber("111a");
        studentService.addMark(mark);
    }


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
