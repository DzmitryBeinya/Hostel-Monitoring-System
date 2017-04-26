package testUser.service.impl;

import testUser.DAO.impl.StudentDao;
import testUser.entities.Mark;
import testUser.entities.Student;
import testUser.entities.WorkHour;
import testUser.service.StudentService;

import java.util.List;

/**
 * Created by dzbe1116 on 4/21/2017.
 */
public class StudentServiceImpl implements StudentService {

    StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.selectStudentByIdWithJDBCTemplate(id);
    }

    @Override
    public List<Student> getAllStudentsFromHostel() {
        return studentDao.selectAllStudentsFromHostel();
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void addWorkHours(WorkHour workHour) {
        studentDao.addWorkHours(workHour);
    }

    @Override
    public void addMark(Mark mark) {
        studentDao.addMark(mark);
    }
}
