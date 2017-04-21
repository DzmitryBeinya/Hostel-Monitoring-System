package testUser.DAO.impl;

import testUser.DAO.UserDAO;
import testUser.entities.Room;
import testUser.entities.Student;
import testUser.entities.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dzbe1116 on 4/19/2017.
 */
public class JDBCUserDAO implements UserDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User selectUserByName(String userName) {
        String sql = "SELECT * FROM user WHERE us_name = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            User user = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getString("us_name"),
                        rs.getString("us_password"),
                        rs.getInt("us_role")
                );
            }
            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public Student selectStudentById(int id) {
        String sql = "select * from student where id = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Student student= null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("st_name"),
                        rs.getString("st_surname"),
                        rs.getString("st_university"),
                        rs.getString("st_faculty"),
                        rs.getString("st_group")
                );
                student.setRoom(getRoomByStudentId(id));
            }
            rs.close();
            ps.close();

            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    @Override
    public Student selectStudentByIdWithJDBCTemplate(int id) {
        return null;
    }

    private Room getRoomByStudentId(int id){
        String sql = "select r.ro_number,r.ro_places,r.ro_free_places, r.ro_floor from room r\n" +
                "join student st\n" +
                "on st.st_room = r.ro_number\n" +
                "where st.id = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Room room = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                room = new Room(
                        rs.getString("ro_number"),
                        rs.getInt("ro_places"),
                        rs.getInt("ro_free_places"),
                        rs.getInt("ro_floor")
                );
            }
            rs.close();
            ps.close();
            return room;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
