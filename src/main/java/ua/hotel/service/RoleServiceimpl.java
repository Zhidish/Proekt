package ua.hotel.service;

import ua.hotel.dao.RoleDao;
import ua.hotel.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceimpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Transactional
    @Override
    public List<Roles> getRoles() {
        return roleDao.getRoles();
    }

    @Transactional
    @Override
    public void saveRole(Roles role) {
        roleDao.saveRole(role);
    }

    @Transactional
    @Override
    public Roles getRole(int theId) {
        return roleDao.getRole(theId);
    }
}
