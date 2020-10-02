package ua.hotel.service;

import ua.hotel.dao.UserDao;
import ua.hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int theId) {
        return userDao.getUser(theId);

    }

    @Override
    @Transactional
    public void deleteUser(int theId) {
        userDao.deleteUser(theId);
    }

    @Override
    public User findUser(String username) {
        return userDao.findUser(username);
    }


}
