package testUser.service;

import testUser.entities.*;

import java.util.List;

/**
 * Created by dzbe1116 on 4/21/2017.
 */
public interface StudentService {
    Student getStudentById(int id);
    List<Student> getAllStudentsFromHostel();
    void addStudent(Student student);
    void addMark(Mark mark);
    void addRebuke(Rebuke rebuke);
    void addWorkHours(WorkHour workHour);
    void deleteWorkHours(int id);
    void deleteRebuke(int id);
    void updateStudentInformation(Student student);
    void updateRebukeInformation(Rebuke rebuke);
    void deleteStudent(int id);
    List<Room> getAllRoomsFromFloor(int floor);
}
