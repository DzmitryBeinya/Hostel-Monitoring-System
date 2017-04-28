package testUser.entities;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Date;

/**
 * Created by dzbe1116 on 4/28/2017.
 */
public class Rebuke {
    private int id;
    private String name;
    private int rank;
    private Date startDate;
    private Date endDate;
    private int studentId;

    public Rebuke() {

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rebuke(int id, String name, int rank, Date startDate, Date endDate, int studentId) {

        this.id = id;

        this.name = name;
        this.rank = rank;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
