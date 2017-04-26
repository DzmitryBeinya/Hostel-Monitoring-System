package testUser.entities;


import java.util.Date;

/**
 * Created by dzbe1116 on 4/25/2017.
 */
public class Mark {
    private int value;
    private Date date;
//    private Room room;
    private String roomNumber;

    public Mark() {

    }

    public Mark(int value, Date date, String roomNumber) {
        this.value = value;
        this.date = date;
        this.roomNumber = roomNumber;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(Room room) {
//        this.room = room;
//    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
