package testUser.DAO.impl;

import testUser.DAO.StudentDAO;
import testUser.entities.Mark;
import testUser.entities.Student;
import testUser.entities.User;
import testUser.entities.WorkHour;

import java.util.List;

/**
 * Created by dzbe1116 on 4/26/2017.
 */
public class HibernateStudentDao implements StudentDAO {
    @Override
    public User selectUserByName(String name) {
        return null;
    }

    @Override
    public Student selectStudentById(int id) {
        return null;
    }

    @Override
    public Student selectStudentByIdWithJDBCTemplate(int id) {
        return null;
    }

    @Override
    public List<Student> selectAllStudentsFromHostel() {
        return null;
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void addMark(Mark mark) {

    }

    @Override
    public void addWorkHours(WorkHour workHour) {

    }

    @Override
    public void deleteFromWorkHoursHistory(int id) {

    }

    @Override
    public void updateStudentInformation(Student student) {

    }
}
