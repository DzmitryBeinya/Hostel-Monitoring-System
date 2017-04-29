package testUser.DAO.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import testUser.DAO.StudentDAO;
import testUser.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dzbe1116 on 4/20/2017.
 */
public class JdbcStudentDao implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void updateStudentInformation(Student student) {
        jdbcTemplate.update(SQL_UPDATE_STUDENT_INFO,
                student.getName(),
                student.getSurname(),
                student.getUnivercity(),
                student.getFaculty(),
                student.getGroup(),
                student.getRoomNumber(),
                student.getId());
    }

    @Override
    public void deleteFromWorkHoursHistory(int id) {
        jdbcTemplate.update(SQL_DELETE_FROM_WORK_HISTORY, id);
    }

    @Override
    public void addWorkHours(WorkHour workHour) {
        jdbcTemplate.update(SQL_ADD_WORK_HOURS,
                workHour.getDate(),
                workHour.getNumber(),
                workHour.getStudentId());
    }

    private final RowMapper<Student> ROW_MAPPER_STUDENT = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setSurname(rs.getString(3));
        student.setUnivercity(rs.getString(4));
        student.setFaculty(rs.getString(5));
        student.setRoom(selectRoomByStudentId(student.getId()));
        return student;
    };

    @Override
    public List<Integer> selectMarksOfRoom(String roomNumber) {
        List<Integer> marks = jdbcTemplate.queryForList(SQL_SELECT_MARKS_OF_ROOM, Integer.class, roomNumber);
        return marks;
    }

    @Override
    public List<WorkHour> selectWorkHoursOfStudent(int studentId) {
        List<WorkHour> workHours = jdbcTemplate.query(SQL_SELECT_WORK_HOURS_BY_STUDENT_ID, ROW_MAPPER_WORK_HOUR, studentId);
        return workHours;
    }

    @Override
    public void updateRebuke(Rebuke rebuke) {
        jdbcTemplate.update(SQL_UPDATE_REBUKE,
                rebuke.getName(),
                rebuke.getRank(),
                rebuke.getStartDate(),
                rebuke.getEndDate(),
                rebuke.getStudentId(),
                rebuke.getId());
    }

    @Override
    public void deleteRebuke(int id) {
        jdbcTemplate.update(SQL_DELETE_REBUKE, id);
    }

    @Override
    public void addRebuke(Rebuke rebuke) {
        jdbcTemplate.update(SQL_ADD_REBUKE,
                rebuke.getName(),
                rebuke.getRank(),
                rebuke.getStartDate(),
                rebuke.getEndDate(),
                rebuke.getStudentId());
    }

    private final RowMapper<Room> ROW_MAPPER_ROOM = (rs, rowNum) -> {
        Room room = new Room();
        room.setNumber(rs.getString(1));
        room.setPlaces(rs.getInt(2));
        room.setFree_places(rs.getInt(3));
        room.setFloor(rs.getInt(4));
        return room;
    };

    private final RowMapper<WorkHour> ROW_MAPPER_WORK_HOUR = (rs, rowNum) -> {
        WorkHour workHour = new WorkHour();
        workHour.setDate(rs.getDate(2));
        workHour.setNumber(rs.getInt(3));
        workHour.setStudentId(rs.getInt(4));
        return workHour;
    };

    private final RowMapper<Student> studentRowMapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setSurname(rs.getString(3));
            student.setUnivercity(rs.getString(4));
            student.setFaculty(rs.getString(5));

            Room room = new Room();
            room.setNumber(rs.getString(6));
            room.setPlaces(rs.getInt(7));
            room.setFree_places(rs.getInt(8));
            room.setFloor(rs.getInt(9));
            student.setRoom(room);
            return student;
        }
    };

    public JdbcStudentDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Student selectStudentById(int id) {

            return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID, ROW_MAPPER_STUDENT, id);

    }

    @Override
    public List<Student> selectAllStudentsFromHostel() {
        List<Student> allStudentsFromHostel = this.jdbcTemplate.query(SELECT_STUDENTS_WITH_ROOM,
                studentRowMapper);
        return allStudentsFromHostel;
    }

    @Override
    public List<Room> selectRoomByFloor(int floor) {
        List<Room> allRoomsFromFloor = this.jdbcTemplate.query(SQL_VIEW_ROOMS_BY_FLOOR, ROW_MAPPER_ROOM, floor);
        return allRoomsFromFloor;
    }

    @Override
    public void deleteStudent(int id) {
        jdbcTemplate.update(SQL_DELETE_STUDENT, id);
    }

    @Override
    public List<Room> selectAllRooms() {
        List<Room> rooms = jdbcTemplate.query(SQL_SELECT_ALL_ROOMS, ROW_MAPPER_ROOM);
        return rooms;
    }

    @Override
    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_ADD_STUDENT,
                student.getName(),
                student.getSurname(),
                student.getUnivercity(),
                student.getFaculty(),
                student.getGroup(),
                student.getRoomNumber());
    }

    @Override
    public void addMark(Mark mark) {
       jdbcTemplate.update(SQL_ADD_MARK,
               mark.getValue(),
               mark.getDate(),
               mark.getRoomNumber());
    }

    private Room selectRoomByStudentId(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_ROOM_BY_STUDENT_ID, ROW_MAPPER_ROOM, id);
    }
}
