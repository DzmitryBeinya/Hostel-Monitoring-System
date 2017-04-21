package testUser.entities;

/**
 * Created by dzbe1116 on 4/20/2017.
 */
public class Student {
    private int id;
    private String name;
    private String surname;
    private String university;
    private String faculty;
    private String group;
    private Room room;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", group='" + group + '\'' +
                ", room number=" + room.getNumber() + '\'' +
                ", room places=" + room.getPlaces() + '\'' +
                ", room free_places=" + room.getFree_places() + '\'' +
                ", room floor=" + room.getFloor() + '\'' +
                '}';
    }

    public Student(){

    }

    public Student(int id, String name, String surname,
                   String university, String faculty,
                   String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.university = university;
        this.faculty = faculty;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUnivercity() {
        return university;
    }

    public void setUnivercity(String univercity) {
        this.university = univercity;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
