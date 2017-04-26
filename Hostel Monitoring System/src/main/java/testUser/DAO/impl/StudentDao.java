package testUser.DAO.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import testUser.DAO.UserDAO;
import testUser.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dzbe1116 on 4/20/2017.
 */
public class StudentDao implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void addWorkHours(WorkHour workHour) {
        jdbcTemplate.update(SQL_ADD_WORK_HOURS,
                workHour.getDate(),
                workHour.getNumber(),
                workHour.getStudentId());
    }

    private final RowMapper<Student> ROW_MAPPER = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setSurname(rs.getString(3));
        student.setUnivercity(rs.getString(4));
        student.setFaculty(rs.getString(5));
        student.setGroup(rs.getString(6));
        student.setRoom(selectRoomByStudentIdwithJDBCTemplate(student.getId()));
        return student;
    };

    public StudentDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

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
        return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID, ROW_MAPPER, id);
    }

    @Override
    public List<Student> selectAllStudentsFromHostel() {
        List<Student> allStudentsFromHostel = this.jdbcTemplate.query(SQL_SELECT_ALL_STUDENTS_FROM_HOSTEL,
                ROW_MAPPER);
        return allStudentsFromHostel;
    }

    @Override
    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_ADD_STUDENT,
                student.getId(),
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

    private Room selectRoomByStudentIdwithJDBCTemplate(int id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_ROOM_BY_STUDENT_ID,
                new ParameterizedRowMapper<Room>() {
                    @Override
                    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Room room = new Room();
                        room.setNumber(rs.getString(1));
                        room.setPlaces(rs.getInt(2));
                        room.setFree_places(rs.getInt(3));
                        room.setFloor(rs.getInt(4));
                        return room;
                    }
                },
                id
        );
    }
}
