package testUser.entities;

/**
 * Created by dzbe1116 on 4/19/2017.
 */
public class User {
    private String name;
    private String password;
    private int role;
    private Room room;


    public User(String name, String password, int role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public User(String name, String password, int role, Room room) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.room = room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public void setRole(int role) {
        this.role = role;
    }
}
