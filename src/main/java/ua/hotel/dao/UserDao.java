package ua.hotel.dao;


import ua.hotel.model.User;

import java.util.List;

public interface UserDao {


    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int theId);

    public void deleteUser(int theId);

public User findUser(String username);
}
