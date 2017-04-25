package testUser.service;

import testUser.entities.Student;

import java.util.List;

/**
 * Created by dzbe1116 on 4/21/2017.
 */
public interface StudentService {
    Student getStudentById(int id);
    List<Student> getAllStudentsFromHostel();
    void addStudent(Student student);
}
