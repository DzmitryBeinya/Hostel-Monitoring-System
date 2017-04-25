package testUser.DAO;

import testUser.entities.Student;
import testUser.entities.User;

import java.util.List;

/**
 * Created by dzbe1116 on 4/19/2017.
 */
public interface UserDAO {
    User selectUserByName(String name);
    Student selectStudentById(int id);
    Student selectStudentByIdWithJDBCTemplate(int id);
    List<Student> selectAllStudentsFromHostel();
    void addStudent(Student student);

    String SQL_SELECT_STUDENT_BY_ID = "select * from student where id = ?";
    String SQL_SELECT_ROOM_BY_STUDENT_ID = "select r.ro_number,r.ro_places,r.ro_free_places, r.ro_floor from hostel_schema.room r\n" +
            "join hostel_schema.student st\n" +
            "on st.st_room = r.ro_number\n" +
            "where st.id = ?";
    String SQL_SELECT_ALL_STUDENTS_FROM_HOSTEL = "select * from hostel_schema.student";
    String SQL_ADD_STUDENT = "insert into hostel_schema.student\n" +
            "values(?, ?, ?, ?, ?, ?, ?)";
}
