package ua.hotel.service;

import ua.hotel.model.Roles;

import java.util.List;

public interface RoleService {

    public List<Roles> getRoles();

    public void saveRole(Roles roles);

    public Roles getRole(int theId);

}
