package testUser.entities;

import java.util.Date;

/**
 * Created by dzbe1116 on 4/26/2017.
 */
public class WorkHour {
    private int number;
    private Date date;
    private int studentId;

    public WorkHour() {

    }

    public WorkHour(int number, Date date, int studentId) {
        this.number = number;
        this.date = date;
        this.studentId = studentId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
