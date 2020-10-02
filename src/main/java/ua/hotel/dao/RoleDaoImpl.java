package ua.hotel.dao;

import ua.hotel.model.Roles;
import ua.hotel.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Roles> getRoles() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Roles> cq = cb.createQuery(Roles.class);
        Root<Roles> root = cq.from(Roles.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveRole(Roles roles) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(roles);


    }

    @Override
    public Roles getRole(int theId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Roles.class, theId);
    }
}
