package ua.hotel.dao;

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
public class Hotelmpl  implements Hotel{


    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Hotel> getHotells() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ua.hotel.model.Hotel> cq = cb.createQuery(ua.hotel.model.Hotel.class);
        Root<ua.hotel.model.Hotel> root = cq.from(ua.hotel.model.Hotel.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

     @Override
     public void addHotel(Hotel hotel) {
         Session session = sessionFactory.getCurrentSession();
         session.save(hotel);
     }
 }
