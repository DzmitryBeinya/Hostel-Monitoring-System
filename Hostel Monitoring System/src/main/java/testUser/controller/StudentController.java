package testUser.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import testUser.entities.*;
import testUser.service.StudentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getRooms/{id}")
    @ResponseBody
    public List<Room> getAllRoomsFromFloor(@PathVariable("id") int floor) {
        List<Room> allRoomsFromFloor= studentService.getAllRoomsFromFloor(floor);

        return allRoomsFromFloor;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getWorkHours/{id}")
    @ResponseBody
    public List<WorkHour> getWorkHoursByStudentId(@PathVariable("id") int studentId) {
        List<WorkHour> workHours= studentService.getWorkHoursOfStudent(studentId);
        return workHours;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getMarks/{id}")
    @ResponseBody
    public List<Integer> getMarksOfRoom(@PathVariable("id") String roomNumber) {
        List<Integer> marks = studentService.selectMarksOfRoom(roomNumber);
        return marks;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getStudents")
    @ResponseBody
    public List<Student> getAllStudentsFromHostel(Model model) {
        List<Student> allStudentsFromHostel= studentService.getAllStudentsFromHostel();

        return allStudentsFromHostel;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getStudent/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addStudent")
    public void addStudent() {
        Student student = new Student();
        student.setName("Stas");
        student.setSurname("Malina");
        student.setUnivercity("BSUIR");
        student.setFaculty("CSN");
        student.setGroup("250503");
        student.setRoomNumber("111a");
        studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addMark")
    public void addMark() throws ParseException {
        Mark mark = new Mark();
        mark.setValue(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        mark.setDate(simpleDateFormat.parse("20170404"));
        mark.setRoomNumber("111a");
        studentService.addMark(mark);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addRebuke")
    public void addRebuke() throws ParseException {
        Rebuke rebuke = new Rebuke();
        rebuke.setName("university");
        rebuke.setRank(3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        rebuke.setStartDate(simpleDateFormat.parse("20170404"));
        rebuke.setEndDate(simpleDateFormat.parse("20170505"));
        rebuke.setStudentId(3);
        studentService.addRebuke(rebuke);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addWorkHours")
    public void addWorkHours() throws ParseException {
        WorkHour workHour = new WorkHour();
        workHour.setNumber(20);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        workHour.setDate(simpleDateFormat.parse("20170404"));
        workHour.setStudentId(9);
        studentService.addWorkHours(workHour);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteWorkHours/{id}")
    public void deleteWorkHours(@PathVariable("id") int id) throws ParseException {
        studentService.deleteWorkHours(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteRebuke/{id}")
    public void deleteRebuke(@PathVariable("id") int id) throws ParseException {
        studentService.deleteRebuke(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateStudent")
    public void updateStudentInformation() {
       Student student = new Student();
       student.setId(15);
       student.setName("Stas");
       student.setSurname("Malinovsky");
       student.setUnivercity("BSUIR");
       student.setFaculty("CSN");
       student.setGroup("250503");
       student.setRoomNumber("222b");
       studentService.updateStudentInformation(student);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/updateRebuke")
    public void updateRebukeInformation() throws ParseException {
        Rebuke rebuke = new Rebuke();
        rebuke.setId(6);
        rebuke.setName("hostel");
        rebuke.setRank(2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        rebuke.setStartDate(simpleDateFormat.parse("20160404"));
        rebuke.setEndDate(simpleDateFormat.parse("20160505"));
        rebuke.setStudentId(7);
        studentService.updateRebukeInformation(rebuke);
    }

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
