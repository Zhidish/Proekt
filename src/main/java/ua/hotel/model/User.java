package ua.hotel.model;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Transient
    transient private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "roles_of_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;

    /*@ManyToMany
    @JoinTable(name="booking_dates",joinColumns =@JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name="room_id") )
    private Set<Booking>  bookings;
*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "booking_dates", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "room_id"))
    List<Room> rooms;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "booking_dates", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    List<Booking> booking;

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /* public Set<Room> getRooms() {
            return rooms;
        }

        public void setRooms(Set<Room> rooms) {
            this.rooms = rooms;
        }
    */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public User() {
    }
}
