package testUser.DAO.impl;

import testUser.DAO.StudentDAO;
import testUser.entities.*;

import java.util.List;

/**
 * Created by dzbe1116 on 4/26/2017.
 */
public class HibernateStudentDao implements StudentDAO {

    @Override
    public Student selectStudentById(int id) {
        return null;
    }

    @Override
    public List<Integer> selectMarksOfRoom(String roomNumber) {
        return null;
    }

    @Override
    public List<WorkHour> selectWorkHoursOfStudent(int studentId) {
        return null;
    }

    @Override
    public void updateRebuke(Rebuke rebuke) {

    }

    @Override
    public void deleteRebuke(int id) {

    }

    @Override
    public void addRebuke(Rebuke rebuke) {

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

    @Override
    public List<Room> selectRoomByFloor(int floor) {
        return null;
    }

    @Override
    public void deleteStudent(int id) {

    }
}
