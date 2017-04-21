package testUser.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import testUser.entities.Student;
import testUser.service.StudentService;

/**
 * Created by dzbe1116 on 4/21/2017.
 */
@Controller
public class StudentController {

    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/hostel_schema/student/{id}")
    public String getStudentById(@PathVariable("id") int id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute(student);
        return "hello";
    }

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
