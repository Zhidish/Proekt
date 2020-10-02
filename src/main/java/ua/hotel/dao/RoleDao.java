package ua.hotel.dao;

import ua.hotel.model.Roles;
import ua.hotel.model.User;

import java.util.List;

public interface RoleDao {


    public List<Roles> getRoles();

    public void saveRole(Roles roles);

    public Roles getRole(int theId);




}
