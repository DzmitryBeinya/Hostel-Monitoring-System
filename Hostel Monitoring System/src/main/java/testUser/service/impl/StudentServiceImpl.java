package testUser.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import testUser.DAO.impl.JdbcStudentDao;
import testUser.entities.Mark;
import testUser.entities.Student;
import testUser.entities.WorkHour;
import testUser.service.StudentService;

import java.util.List;

/**
 * Created by dzbe1116 on 4/21/2017.
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {

    JdbcStudentDao jdbcStudentDao;

    public StudentServiceImpl(JdbcStudentDao jdbcStudentDao) {
        this.jdbcStudentDao = jdbcStudentDao;
    }

    @Override
    public Student getStudentById(int id) {
        return jdbcStudentDao.selectStudentByIdWithJDBCTemplate(id);
    }

    @Override
    public List<Student> getAllStudentsFromHostel() {
        return jdbcStudentDao.selectAllStudentsFromHostel();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addStudent(Student student) {
        jdbcStudentDao.addStudent(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateStudentInformation(Student student) {
        jdbcStudentDao.updateStudentInformation(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteWorkHours(int id) {
        jdbcStudentDao.deleteFromWorkHoursHistory(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addWorkHours(WorkHour workHour) {
        jdbcStudentDao.addWorkHours(workHour);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addMark(Mark mark) {
        jdbcStudentDao.addMark(mark);
    }
}
