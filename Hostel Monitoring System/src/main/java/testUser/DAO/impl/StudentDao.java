package testUser.DAO.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import testUser.DAO.UserDAO;
import testUser.entities.Room;
import testUser.entities.Student;
import testUser.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dzbe1116 on 4/20/2017.
 */
public class StudentDao implements UserDAO {

    private JdbcTemplate jdbcTemplate;

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

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
