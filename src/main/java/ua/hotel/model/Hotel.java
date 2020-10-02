package ua.hotel.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "country")
    String country;


    @Column(name = "city")
    String city;

    @Column(name = "area")
    String area;


    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phone_number;


    @Column(name="name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel() {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }



    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "hotels_and_rooms", joinColumns = @JoinColumn(name = "id_hotel"), inverseJoinColumns = @JoinColumn(name = "id_room"))
    Set<Room> rooms;

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }


}




