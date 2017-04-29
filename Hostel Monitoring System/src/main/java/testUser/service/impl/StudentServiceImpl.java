package testUser.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import testUser.DAO.impl.JdbcStudentDao;
import testUser.entities.*;
import testUser.service.StudentService;

import java.util.List;

/**
 * Created by dzbe1116 on 4/21/2017.
 */
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {

    private JdbcStudentDao jdbcStudentDao;

    public StudentServiceImpl(JdbcStudentDao jdbcStudentDao) {
        this.jdbcStudentDao = jdbcStudentDao;
    }

    @Override
    public Student getStudentById(int id) {
        return jdbcStudentDao.selectStudentById(id);
    }

    @Override
    public List<Room> selectAllRooms() {
        return jdbcStudentDao.selectAllRooms();
    }

    @Override
    public List<Integer> selectMarksOfRoom(String roomNumber) {
        return jdbcStudentDao.selectMarksOfRoom(roomNumber);
    }

    @Override
    public List<WorkHour> getWorkHoursOfStudent(int studentId) {
        List<WorkHour> studentList = jdbcStudentDao.selectWorkHoursOfStudent(studentId);
        return studentList;
    }

    @Override
    public void updateRebukeInformation(Rebuke rebuke) {
        jdbcStudentDao.updateRebuke(rebuke);
    }

    @Override
    public void deleteRebuke(int id) {
        jdbcStudentDao.deleteRebuke(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addRebuke(Rebuke rebuke) {
        jdbcStudentDao.addRebuke(rebuke);
    }

    @Override
    public List<Student> getAllStudentsFromHostel() {
        List<Student> studentList = null;

        long start = System.nanoTime();
        for(int i = 0; i<1000; i++) {
            studentList = jdbcStudentDao.selectAllStudentsFromHostel();
        }
        long end = System.nanoTime();

        System.out.println(end-start);
        return studentList;
    }

    @Override
    public List<Room> getAllRoomsFromFloor(int floor) {
        return jdbcStudentDao.selectRoomByFloor(floor);
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
    public void deleteStudent(int id) {
        jdbcStudentDao.deleteStudent(id);
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
