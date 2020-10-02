package ua.hotel.dao;

import org.hibernate.engine.spi.EntityEntryFactory;
import ua.hotel.model.Roles;
import ua.hotel.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();

    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Set<Roles> roles = new HashSet<>();
        roles.add(roleDao.getRole(1));
        user.setRoles(roles);
        session.saveOrUpdate(user);

    }


    @Override
    public User getUser(int theId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, theId);
        return user;
    }

    @Override
    public void deleteUser(int theId) {
        Session session = sessionFactory.getCurrentSession();
        User usersession = session.byId(User.class).load(theId);
        session.delete(usersession);
    }

    @Override
    public User findUser(String username) {
        Session session = sessionFactory.getCurrentSession();

        User user = (User) session.createNativeQuery(" SELECT * from User where username = :username").
                addEntity(User.class).
                setParameter("username", username)
                .uniqueResult();
        return user;
    }
}
