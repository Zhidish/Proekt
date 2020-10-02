package ua.hotel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.hotel.model.Room;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RoomImpl implements ua.hotel.dao.Room {



    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRoom(Room room) {
        Session session =sessionFactory.getCurrentSession();
        session.save(room);

    }

    @Override
    public void addRoom(ua.hotel.dao.Room room) {

    }

    @Override
    public List<ua.hotel.dao.Room> getRooms() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root<Room> root = cq.from(Room.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }


}
