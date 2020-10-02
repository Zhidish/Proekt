package ua.hotel.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking_dates")
public class Booking {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date date_to;


    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date date_from;

    @JoinColumn(name = "room_id")
    int room_id;


    @JoinColumn(name = "user_id")
    int user_id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "booking_dates", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
    List<Room> rooms;


    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
/*

    @ManyToMany(mappedBy = "user_id")
    Set<User>  users;
*/

    public Booking() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int id_room) {
        this.room_id = id_room;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int id_user) {
        this.user_id = id_user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", date_to=" + date_to +
                ", date_from=" + date_from +
                ", room_id=" + room_id +
                ", user_id=" + user_id +
                '}';
    }
}
