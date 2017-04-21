package testUser.entities;

/**
 * Created by dzbe1116 on 4/20/2017.
 */
public class Room {
    private String number;
    private int places;
    private int free_places;
    private int floor;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Room(String number, int places, int free_places, int floor) {
        this.number = number;
        this.places = places;
        this.free_places = free_places;
        this.floor = floor;

    }

    public Room() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getFree_places() {
        return free_places;
    }

    public void setFree_places(int free_places) {
        this.free_places = free_places;
    }
}
