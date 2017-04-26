package testUser.DAO;

import testUser.entities.Mark;
import testUser.entities.Student;
import testUser.entities.User;
import testUser.entities.WorkHour;

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
    void addMark(Mark mark);
    void addWorkHours(WorkHour workHour);

    String SQL_SELECT_STUDENT_BY_ID = "select * from student where id = ?";
    String SQL_SELECT_ROOM_BY_STUDENT_ID = "select r.ro_number,r.ro_places,r.ro_free_places, r.ro_floor from hostel_schema.room r\n" +
            "join hostel_schema.student st\n" +
            "on st.st_room = r.ro_number\n" +
            "where st.id = ?";
    String SQL_SELECT_ALL_STUDENTS_FROM_HOSTEL = "select * from hostel_schema.student";
    String SQL_ADD_STUDENT = "insert into hostel_schema.student\n" +
            "values(?, ?, ?, ?, ?, ?, ?)";
    String SQL_ADD_MARK =
            "insert into hostel_schema.mark_history(mh_value, mh_date, mh_room)\n" +
                    "values(?, ?, ?)";
    String SQL_ADD_WORK_HOURS = "insert into hostel_schema.work_hours_history(wh_date, wh_number, wh_student)\n" +
                    "values(?, ?, ?)";
}
