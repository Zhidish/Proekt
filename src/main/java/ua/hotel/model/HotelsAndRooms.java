package ua.hotel.model;


import javax.persistence.*;

@Entity
@Table(name = "hotels_and_rooms")
public class HotelsAndRooms {
    public HotelsAndRooms() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
   private  int id;

    @Column(name = "id_hotel")
    @JoinColumn
     private int id_hotel;


    @Column(name="id_room")
    @JoinColumn
  private   int id_room;




}
