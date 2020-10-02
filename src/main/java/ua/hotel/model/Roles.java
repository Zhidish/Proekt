package ua.hotel.model;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Roles {


    public Roles() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role_name")
    private String role;


    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


}
