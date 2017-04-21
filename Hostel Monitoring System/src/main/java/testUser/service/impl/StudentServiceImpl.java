package testUser.service.impl;

import testUser.DAO.impl.StudentDao;
import testUser.entities.Student;
import testUser.service.StudentService;

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
}
