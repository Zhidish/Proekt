package ua.hotel.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id_room;

    @Column(name = "room_number")
    int room_number;


    @Column(name = "room_type")
    @JoinColumn
    int room_type;

    @Column(name = "floor")
    int floor;

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "hotels_and_rooms", joinColumns = @JoinColumn(name = "id_room"), inverseJoinColumns = @JoinColumn(name = "id_hotel"))
    Set<Hotel> hotel;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "booking_dates", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<Booking> bookingList;

    public Hotel getHotel_room() {
        return hotel_room;
    }

    public void setHotel_room(Hotel hotel_room) {
        this.hotel_room = hotel_room;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinTable(name = "hotels_and_rooms", joinColumns = @JoinColumn(name = "id_room"), inverseJoinColumns = @JoinColumn(name = "id_hotel"))
    Hotel hotel_room;


 /*
    @OneToOne
    @JoinColumn(name = "room_type")
    List<>*/
    public Set<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(Set<Hotel> hotel) {
        this.hotel = hotel;
    }

    public Room() {


    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id) {
        this.id_room = id;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public int getRoom_type() {
        return room_type;
    }

    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id_room +
                ", room_number=" + room_number +
                ", room_type=" + room_type +
                ", floor=" + floor +
                '}';
    }
}
